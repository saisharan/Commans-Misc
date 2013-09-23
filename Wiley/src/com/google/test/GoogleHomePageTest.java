package com.google.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.page.GoogleHomePage;

public class GoogleHomePageTest {
	
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
	public void searchTest() {
		
		String SearchText="WebDriver";
		GoogleHomePage gp=new GoogleHomePage(driver);
		gp.loadPage();
		gp.search(SearchText);
		Assert.assertTrue(gp.getFirstSearchResult().contains(SearchText));
		
	}
	
	

}
