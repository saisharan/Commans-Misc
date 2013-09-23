package com.wiley.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public String CMA_Arrow_Xpath="(//div[@class='slideNAV']/a)[1]";
	public String Wiley_CMA_Button_Link="View Wiley CPA Test Solutions";
	public String BecomePartner_Link="Become a Partner";
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		wait=new WebDriverWait(driver,60);
	}
	
	public void loadPage() {
		
		driver.get("http://dev.efficientlearning.com/");
	}
	
	public void loadBecomePartnerPage() {
		
		driver.findElement(By.linkText(BecomePartner_Link)).click();
	}
	
	public void loadCMAExcelPage() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CMA_Arrow_Xpath)));
		driver.findElement(By.xpath(CMA_Arrow_Xpath)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Wiley_CMA_Button_Link)));
		driver.findElement(By.linkText(Wiley_CMA_Button_Link)).click();
	}

}
