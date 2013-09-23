

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverExample { 
public WebDriver driver;

@BeforeClass
public void setUp() {
	driver = new FirefoxDriver();   
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
@Test
public void testMethod() throws Exception  {   
	driver.get("http://www.google.com");
	driver.findElement(By.id("gbqfq")).sendKeys("webdriver");
	driver.findElement(By.name("btnG")).click();
	Thread.sleep(5000);
	  Robot robot = new Robot();
      // Capture the screen shot of the area of the screen defined by the rectangle
      BufferedImage bi=robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
      ImageIO.write(bi, "jpg", new File("D:/imageTest.jpg"));

   	Assert.assertEquals(driver.getTitle(),"webdriver - Google Search");
   	Assert.assertEquals(driver.findElement(By.xpath("//html/body/div[4]/div[2]/div/div[6]/div/div[3]/div/div[2]/div[2]/div/ol/li/div/h3/a")).getText(), "Getting started with WebDriver - Google Code");
   	
}
@AfterClass
public void tearDown() {
 driver.quit();
	}
}
