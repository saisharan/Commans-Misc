package com.wiley.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.wiley.page.HomePage;

public class HomePageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void stop() {
		driver.quit();
	}
	
	@Test
	public void becomePartnerNavigationTest() {
		
		HomePage hp=new HomePage(driver);
		hp.loadPage();
		hp.loadBecomePartnerPage();
		Assert.assertEquals(driver.getTitle(), "Partners » Wiley EL");
		Assert.assertEquals(driver.getCurrentUrl(), "http://dev.efficientlearning.com/about/partners/");
		
	}

}
