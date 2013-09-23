package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public GmailPage(WebDriver driver) {
		
		this.driver=driver;
		wait=new WebDriverWait(driver,60);
	}
	
	public void loadPage() {
		
		GoogleHomePage gp=new GoogleHomePage(driver);
		gp.loadPage();
		gp.loadGmailPage();
	}
	
	public void login(String username,String password) {
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
	}
	
	public String getPasswordError() {
		return driver.findElement(By.id("errormsg_0_Passwd")).getText();
	}
}