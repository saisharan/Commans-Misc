import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Ebay {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
	//	System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	//	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,60);
	}
	
	// Checking the Text for just one left link 
//	@Test
	public void linkCheck() {
		driver.get("http://www.ebay.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navigationDF']/div/ul/li[1]/a")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='navigationDF']/div/ul/li[1]/a")).getText(), "Motors");
	}
	// Check the Text for all left links using driver.findElements
	@Test
	public void totalLinkTest() {
		driver.get("http://www.ebay.com");
		String l[]={"Motors",
				"Fashion",
				"Electronics",
				"Collectibles & Art",
				"Home & Garden",
				"Sporting Goods",
				"Toys & Hobbies",
				"Deals & Gifts"};
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='navigationDF']/div/ul/li/a")));
		List<WebElement> links=driver.findElements(By.xpath("//div/div/ul/li/a"));
		
		for(WebElement link:links)
		{
			if (link.getText().equals("Cart") && link.isDisplayed())
				link.click();
		}
	}
	
	// Check the list of values available in the drop down (getOptions)
//	@Test
	public void checkList() {
		driver.get("http://mail.yahoo.com");
		String mon[]={"Month",
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"};
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signUpBtn")));
		driver.findElement(By.id("signUpBtn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("month")));
		Select month=new Select(driver.findElement(By.id("month")));
		
		List<WebElement> months=month.getOptions();
		int i=0;
		for(WebElement m:months)
		{
			Assert.assertEquals(m.getText(), mon[i]);
			Reporter.log("Actual="+m.getText()+":Expected="+mon[i]);
			i++;
		}
	}
	
	
	
	
	
	@AfterMethod
	public void stop() {
		driver.quit();
	}

}

