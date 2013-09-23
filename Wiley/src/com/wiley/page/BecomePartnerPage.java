package com.wiley.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BecomePartnerPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public String BecomePartner_Link="Become a Partner";
	public String FirstName_id="input_2_1";
	public String LastName_id="input_2_2";
	public String Email_id="input_2_3";
	public String Company_id="input_2_4";
	public String Submit_id="gform_submit_button_2";
	public String Message_id="gforms_confirmation_message";
	public String FirstNameError_xpath="//li[@id='field_2_1']/div[2]";
	
public BecomePartnerPage(WebDriver driver) {
		
		this.driver=driver;
		wait=new WebDriverWait(driver,60);
	}
	
	public void loadPage() {
		
		HomePage hp=new HomePage(driver);
		hp.loadPage();
		hp.loadBecomePartnerPage();
	}
	
	public void SubmitDataForBecomingPartner(String fname,String lname,String email,String company) {
		
		driver.findElement(By.linkText(BecomePartner_Link)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FirstName_id)));
		
		driver.findElement(By.id(FirstName_id)).sendKeys(fname);
		driver.findElement(By.id(LastName_id)).sendKeys(lname);
		driver.findElement(By.id(Email_id)).sendKeys(email);
		driver.findElement(By.id(Company_id)).sendKeys(company);
		
		driver.findElement(By.id(Submit_id)).click();
		
	}
	
	public String getSuccessMsg() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Message_id)));
		String Msg=driver.findElement(By.id(Message_id)).getText();
		return Msg;
	}
	
	public String getFirstNameErr() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FirstNameError_xpath)));
		String Msg=driver.findElement(By.xpath(FirstNameError_xpath)).getText();
		return Msg;
	}
}
