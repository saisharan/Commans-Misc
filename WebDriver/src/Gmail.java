import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Gmail {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	//	System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	//	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void invalidLogin() {
		driver.get("http://www.google.com");
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.id("Email")).sendKeys("fsfsfsf");
		driver.findElement(By.id("Passwd")).sendKeys("fsdff");
		driver.findElement(By.id("signIn")).click();
		assertEquals(driver.findElement(By.id("errormsg_0_Passwd")).getText(), "The username or password you entered is incorrect. ?");
	}
	
	@Test
	public void emptyLogin() {
		driver.get("http://www.google.com");
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("signIn")).click();
		String Expected="Enter your email address.";
		String Actual=driver.findElement(By.id("errormsg_0_Email")).getText();
		assertEquals(Actual, Expected);
	}
	
	@AfterMethod
	public void stop() {
		driver.quit();
	}

}
