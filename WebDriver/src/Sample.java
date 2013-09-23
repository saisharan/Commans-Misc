import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Sample {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void testMethod() throws Exception  {   
		driver.get("https://192.168.5.61:9091");
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		driver.findElement(By.name("sm_user")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("baicode");
		driver.findElement(By.xpath("//table/tbody/tr[7]/td/table/tbody/tr[2]/td/input")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("leftpane"));
		driver.findElement(By.linkText("FI Management")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("detailspane"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Default')][1]")));
		driver.findElement(By.xpath("//a[contains(text(),'Default')][1]")).click();
		ExpectedConditions.presenceOfElementLocated(By.id("name"));
	}
	@AfterClass
	public void tearDown() {
//	 driver.quit();
		}
	}
