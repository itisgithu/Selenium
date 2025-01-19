package Demotestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Clientclass {   //PageObjectModule (Connected with Utility Class) operation are different
	
//public static WebDriver driver;               //It contains @Test methods , which will calling methods from Utility class
private WebDriver driver; 

Utilityclassformethods8 r1;    // Utility & Client class ( for WebDriver driver) Object Should be same
	


  @Test
  public void CallingMethods() throws InterruptedException 
  {
	   
	    r1.setFullname("Nagaraj Naik");
	    r1.setRediffId("123368");
		//System.out.println(r1.checkAvailablity());
		r1.setPassword("Manju@123");
		
		//r1.setConfirmPassword("Manju@123"); 
	
	  
  }
	 
	 
	 
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  
	driver=new ChromeDriver();  
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	
	r1 =new Utilityclassformethods8(driver); //Utility class ( Created object) &(driver) this pass to Utility
	 
  }

  @AfterTest
  public void afterTest() {
  }

}
