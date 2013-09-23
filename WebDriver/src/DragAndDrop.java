import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DragAndDrop {
	
	 WebDriver driver;
	    WebDriverWait wait;

	    @BeforeMethod
	    public void setUp() {
	       
	    //    System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	    	driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, 30);
	       
	    }
	   
	    @Test
	    public void schooleducation() {
	        driver.get("http://jqueryui.com/demos/");
	        driver.findElement(By.linkText("Droppable")).click();
	        driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(0));
	        WebElement from=driver.findElement(By.id("draggable"));
	        WebElement to=driver.findElement(By.id("droppable"));
	        Actions action=new Actions(driver);
	        action.dragAndDrop(from, to).build().perform();
	        driver.switchTo().window(driver.getWindowHandle());
	        driver.findElement(By.linkText("Draggable")).click();
	       
	    }
	    @AfterMethod
	    public void stop() {
	    //    driver.quit();
	    }
	    }




