




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;

public class GmailClass {
	
	WebDriver driver;
	Selenium selenium;
	
	// Using WebDriverBackedSelenium for Selenium RC backward compatibility
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		selenium=new WebDriverBackedSelenium(driver, "http://www.google.com");
		selenium.setTimeout("80000");
		selenium.windowMaximize();
		}
	

	@Test(priority=1)
	public void invalidLogin() {
		selenium.open("/");
		selenium.click("id=gb_70");
		selenium.waitForPageToLoad("60000");
		selenium.type("id=Email", "aswerty");
		selenium.type("id=Passwd", "dndndn");
		selenium.click("id=signIn");
		selenium.waitForPageToLoad("60000");
		Assert.assertEquals(selenium.getText("id=errormsg_0_Passwd"), "The username or password you entered is incorrect. ?");
		Assert.assertEquals(selenium.getAttribute("id=signIn@value"), "Sign in");
	}
	
	@Test(priority=0)
	public void emptyEmail() {

		selenium.open("/");
		selenium.click("id=gb_70");
		selenium.waitForPageToLoad("60000");
		selenium.type("id=Email", " ");
		selenium.click("id=signIn");
		selenium.waitForPageToLoad("60000");
		Assert.assertEquals(selenium.getText("id=errormsg_0_Email"), "Enter your email address.");
		
	}
	
	@AfterMethod
	public void stop() {
		selenium.stop();
	}
	

}

