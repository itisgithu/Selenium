package Demotestng;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {

WebDriver driver;
//Here after login Expected  URL
String expURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",ActURL;
//String  ActURL=driver.getCurrentUrl(); Without initialize the we can create like driver.getCurrectURL();

//ActURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//expURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
  @BeforeTest(alwaysRun=true)//For XML file
	public void launchchrome()
	{
	  
	 
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
  
	}
	
	
  
  @DataProvider                            //Data Provider(Sender)
  public Object[][] getLoginData()
  {
	  return new Object[][] {
			new Object[] { "admin", "admin123" },
			new Object[] { "shikha", "shikha123" },
			new Object[] { "vijaya", "vijaya123" },
			new Object[] { "admin", "admin123"  },
  };
  }
  @Test(dataProvider = "getLoginData")                  //Data Receiver (@Test)
  public void logintoHRM(String un, String ps)
  {
 
  WebElement login=driver.findElement(By.cssSelector("input[name=\"username\"]"));
  login.sendKeys(un);
  WebElement psw=driver.findElement(By.cssSelector("input[name=\"password\"]"));
  psw.sendKeys(ps);
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  
  ActURL = driver.getCurrentUrl();
  
 // Assert.assertEquals(ActURL,expURL,"Invalid credentials");
  Assert.assertTrue(ActURL.contains("dashboard"),"Invalid Credentials");
  
 // Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Invalid credentials");
  
  
  }
  
  @Test(priority =2 , invocationCount =4, enabled=true, groups="My family")
  public void myreference()
  {
	  System.out.println("My reference 1");
	  
  }
 
  @Test(priority=3 ,invocationCount=2 ,enabled=true,groups="My family")
  public void myreference2()
  {
	  
	 System.out.println("My reference 2"); 
	  
  }
  
  
  
  
  @BeforeMethod
  public void beforeMethod() 
  {
  
  System.out.println("Before Method");
	  
  }

  @AfterMethod
  public void afterMethod()               //Logout
  {
	  
	  
	  if(driver.getCurrentUrl().contains("Dashboard"))
	  {
	  driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();//Image link
	  driver.findElement(By.linkText("Logout")).click();//Login link
	  System.out.println("Test case pass");
  
     }
  else
      {
	  System.out.println("Unsuccessfull");
       }
 
	 
  }		
  
  {
			
	  System.out.println("Invalid data");
  
  }
  
  
  @AfterTest                         //All execution  Completed
  public void afterTest() 
  {
	  
	driver.close();
	  
  }

}
