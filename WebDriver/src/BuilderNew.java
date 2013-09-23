
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BuilderNew {

	public WebDriver driver;
	int i,temp=0;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void testMethod() throws Exception  {   
		driver.get("https://192.168.5.61:9090");
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		driver.findElement(By.name("sm_user")).sendKeys("venkat");
		driver.findElement(By.name("password")).sendKeys("baicode");
		driver.findElement(By.xpath("//table/tbody/tr[7]/td/table/tbody/tr[2]/td/input")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("detailspane"));
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frames.get(0));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
		driver.findElement(By.linkText("Create a New Ad Campaign")).click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("detailspane"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Cancel")));
		driver.findElement(By.name("Cancel")).click();
		}
	@AfterClass
	public void tearDown() {
//	 driver.quit();
		}
	}

