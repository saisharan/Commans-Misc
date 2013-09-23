package com.google.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.page.GmailPage;

public class GmailPageTest {
	
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
	public void invalidLoginTest() {
		
		GmailPage gp=new GmailPage(driver);
		gp.loadPage();
		gp.login("ffsdfsdfsd", "fffffffffa");
		Assert.assertEquals(gp.getPasswordError(), "The username or password you entered is incorrect. ?");
	}

}
