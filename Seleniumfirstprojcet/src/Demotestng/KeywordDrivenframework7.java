package Demotestng;
import java.io.File;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class KeywordDrivenframework7 {
	File file ;
	FileInputStream  fis; //To read
	Properties prop;
	
	
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  driver.findElement(By.cssSelector(prop.getProperty("FullnameCss"))).sendKeys("Nagaraj Naik");//sendkeys(prop.getProperty("Sangeetha")We can read i they mentioned value on hat file & 
	  driver.findElement(By.xpath(prop.getProperty("RedifId"))).sendKeys("Ramya");
	  driver.findElement(By.id(prop.getProperty("Password"))).sendKeys("Iii");
	  driver.findElement(By.id(prop.getProperty("Retypepsw"))).sendKeys("raj");
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	 //Configuration
	 file =new File("C:\\Users\\nagar\\git\\repository\\Seleniumfirstprojcet\\src\\Demotestng\\Rediffregistraition.properties");
	 fis=new FileInputStream(file);
	 prop=new Properties();
	 prop.load(fis); //This will load all the properties from the rediff file
	 
	 
	 
	 
	 
	 
	  
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(prop.getProperty("URL")); //Why URL bcs already link stored in the  Redif file
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
