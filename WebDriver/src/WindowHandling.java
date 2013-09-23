import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WindowHandling {
	
	WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
       
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
       
    }
   
    @Test
    public void windowTest() {
    	driver.get("http://www.google.com");
    	driver.findElement(By.linkText("News1234566")).click();
    	String parentWindow=driver.getWindowHandle();
       	driver.findElement(By.xpath(".//*[@id='MAA4AEgAUABgAWoCaW4']/span")).click();
    	
    	while(driver.getWindowHandles().size()<1)
    	{
    		continue;
    	}
    	
    	Set<String> handles=driver.getWindowHandles();
    	
    	for (String handle:handles)
    	{
    		if(!(handle.contains(parentWindow)))
    			driver.switchTo().window(handle);
    	}

    	
    	System.out.println(driver.findElement(By.xpath("//h1")).getText());
    	
    	driver.close();
    	
    	driver.switchTo().window("");
    	System.out.println(driver.getTitle());
    	
}
}