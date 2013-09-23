import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AlertHandling {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
	//	System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	//	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 30);
	}
		
	// Handling drop down using webdriver
	@Test
	public void searchTest() {
		driver.get("http://www.whatnextbuddy.com");
		
		 Actions action = new Actions(driver);
		 WebElement we = driver.findElement(By.xpath("//div[@class='menu']/ul/li[3]"));
		 action.moveToElement(we).build().perform(); 
		
		driver.findElement(By.linkText("Schools")).click();
		
		driver.findElement(By.name("submit")).click();
		
	/*	Alert a=driver.switchTo().alert();
		
		String msg=a.getText();
		a.accept(); */
		
		String msg=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(msg, "Please select the state");
		
		driver.findElement(By.name("keys")).sendKeys("dadasdsa");
		
	}
	 @AfterMethod
	    public void stop() {
	    //    driver.quit();
	    }
}
