package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
	
		WebDriver driver;
		WebDriverWait wait;
		
		public GoogleHomePage(WebDriver driver) {
			
			this.driver=driver;
			wait=new WebDriverWait(driver,60);
		}
		
		public void loadPage() {
			
			driver.get("http://www.google.com");
		}
		
		public void loadGmailPage() {
			driver.findElement(By.id("gb_70")).click();
		}
		
		public void search(String text) {
			driver.findElement(By.name("q")).sendKeys(text);
			driver.findElement(By.name("btnG")).click();
		}
		
		public String getFirstSearchResult() {
			return driver.findElement(By.xpath(".//*[@id='rso']/li[1]/div/h3/a")).getText();
		}

}
