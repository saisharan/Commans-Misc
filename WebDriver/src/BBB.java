import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class BBB {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
	
		 FirefoxProfile customProfile = new FirefoxProfile();
         customProfile.setAcceptUntrustedCertificates(true);
         customProfile.setAssumeUntrustedCertificateIssuer(false);
		driver=new FirefoxDriver(customProfile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 30);
	}
		
	// Handling drop down using webdriver
//	@Test
	public void searchTest() {
		driver.get("http://www.aol.com/");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'+')]")));
		List<WebElement> links=driver.findElements(By.xpath("//span[contains(text(),'+')]"));
		
		for (WebElement link:links)
			System.out.println(link.getText());
		
	
		
	}
	
	@Test
	public void sampleTest() {
		
		driver.get("http://www.aol.com/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='follow-aol-new']")));
		WebElement mainDiv=driver.findElement(By.xpath("//div[@id='follow-aol-new']"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(),'+')]")));
		wait.until(ExpectedConditions.visibilityOf(mainDiv.findElement(By.xpath(".//span[contains(text(),'+')]"))));
		List<WebElement> links=mainDiv.findElements(By.xpath(".//span[contains(text(),'+')]"));
		
		for (WebElement link:links)
			System.out.println(link.getText());
		
		
	}
	
	 @AfterMethod
	    public void stop() {
	        driver.quit();
	    }
}
