import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WNB {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
	//	System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	//	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		wait=new WebDriverWait(driver, 30);
	}
		
	// Handling drop down using webdriver
	@Test
	public void searchTest() {
		driver.get("http://www.whatnextbuddy.com");
		
		WebElement we = driver.findElement(By.xpath("//div[@class='menu']/ul/li[3]")); 
		
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform(); 
				
		driver.findElement(By.linkText("Schools")).click();
		
		Select state=new Select(driver.findElement(By.name("state")));
		state.selectByVisibleText("Tamil Nadu");
		
		wait.until(ExpectedConditions.textToBePresentInElement(By.name("city"), "Chennai"));
		Select city=new Select(driver.findElement(By.name("city")));
		city.selectByVisibleText("Chennai");
		
		wait.until(ExpectedConditions.textToBePresentInElement(By.name("schooltype"), "All"));
		Select type=new Select(driver.findElement(By.name("schooltype")));
		type.selectByVisibleText("All");
		
		driver.findElement(By.name("keys")).sendKeys("DAV");
		driver.findElement(By.name("submit")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("normal_head_text")));
				
		Assert.assertTrue(driver.getPageSource().contains("DAV Matriculation Higher Secondary School"));
		
	}
	@AfterMethod
	public void stop() {
		driver.quit();
	}

}
