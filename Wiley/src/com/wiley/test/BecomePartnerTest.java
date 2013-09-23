package com.wiley.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wiley.page.BecomePartnerPage;

public class BecomePartnerTest {
	
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
	public void becomePartnerTest() {
		
		BecomePartnerPage bp=new BecomePartnerPage(driver);
		bp.loadPage();
		bp.SubmitDataForBecomingPartner("test", "test1", "abcd@xyz.com", "asdda");
		Assert.assertEquals(bp.getSuccessMsg(), "Thanks for contacting us! We will get in touch with you shortly.");
	}
	
	@Test
	public void emptyFirstNameErrorTest() {
		BecomePartnerPage bp=new BecomePartnerPage(driver);
		bp.loadPage();
		bp.SubmitDataForBecomingPartner("", "test1", "abcd@xyz.com", "asdda");
		Assert.assertEquals(bp.getFirstNameErr(), "This field is required.");
	}

}
