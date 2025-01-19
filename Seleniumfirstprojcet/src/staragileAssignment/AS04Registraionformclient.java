package staragileAssignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AS04Registraionformclient {

    WebDriver driver;
    AS04Registrationformutility reg;

    @Test(priority = 1)
    public void registration() throws InterruptedException {
        reg.fullname("Nagaraj Manjunath Naik");
        reg.remailid("nagaraj123");
        reg.vailibilitybtn();
        Assert.assertTrue(reg.checkAvailablity(), "Availability Message not displayed");
        reg.selectedemail();
        reg.newpassword("NJg4@j@124//");
        reg.repassword("NJg4@j@124//");
        reg.altrid();
        reg.selectsecurityqn();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        reg.enteranswer("Chikken Biryani");
        reg.mothermname("Mnaik");
        reg.mobilenumber("9353127257");
        reg.Selectedday();
        reg.SelectedMonth();
        reg.SelectedYear();
        reg.Maleorfemale();
        reg.SelectedCountry();
        reg.SelectedCity();
        reg.Captcha();
        Thread.sleep(10000);
        reg.CreatedAccount();
    }
    
   
    
    @BeforeMethod
    public void beforeMethod() {
        // Can add pre-test setup logic if required
    }

    @AfterMethod
    public void afterMethod() {
        // Can add post-test cleanup logic if required
    }

    @BeforeTest
    public void beforeTest() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
        reg = new AS04Registrationformutility(driver);
    }

    @AfterTest
    public void afterTest() {
      if (driver != null) {
          driver.quit();
        
    }
}}
