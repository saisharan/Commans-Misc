
import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {
   
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
       
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 80);
       
    }
   
    @Test
    public void schooleducation() {
        driver.get("http://whatnextbuddy.com");
        driver.findElement(By.xpath(".//*[@id='content_outer']/div[2]/table/tbody/tr[2]/td[2]/div/a")).click();
        Select state = new Select(driver.findElement(By.name("state")));
        state.selectByVisibleText("Tamil Nadu");
        wait.until(ExpectedConditions.textToBePresentInElement(By.name("city"), "Chennai"));
        Select city = new Select(driver.findElement(By.name("city")));
        city.selectByVisibleText("Chennai");
        wait.until(ExpectedConditions.textToBePresentInElement(By.name("schooltype"), "CBSE"));
        Select type = new Select(driver.findElement(By.name("schooltype")));
        type.selectByVisibleText("CBSE");
        driver.findElement(By.name("keys")).sendKeys("Maharishi");
        driver.findElement(By.name("submit")).click();
        assertEquals(driver.findElement(By.xpath("//td[@class='normal_text']/b")).getText(), "Maharishi Vidya Mandir");
    }
    @AfterMethod
    public void stop() {
        driver.quit();
    }
    }

