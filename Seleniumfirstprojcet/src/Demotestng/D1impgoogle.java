package Demotestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D1impgoogle {
	WebDriver driver;


	@BeforeTest
	public void SetUp() //For all
	{

		System.out.println("Before Execution Test");	
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.google.co.in/");//link will be opened once before any of the test methods execute

		//All test case execute on by one and go to @AfterMethod and @AfterTest(Page loads only once)
	}

	//In (Before& After(Test and Method)If used separate (Link added in Test( Thats why load new each web page one after another)
	//If you are using both (Then @BeforeTest(Link) (Will runs(load once and test case run one by one)
	//If you used Link (@BeforeMethod-Then for each test Cases page will load fresh

	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("Before method "); //VVVV IMP(Page loads each test case )
		driver.get("https://www.google.co.in/");//Each Individual test case and go to @AfterMethod and reload page and after @AfterTest
		System.out.println("Print Title"+driver.getTitle());

	}


	@Test(priority = 1)
	public void Gmail() 
	{
		WebElement google=driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a"));
		google.click();
		System.out.println("Print Title"+driver.getTitle());
	}

	@Test(priority =2)

	public void Image() 
	{


		WebElement google=driver.findElement(By.partialLinkText("Images"));
		google.click();
		System.out.println("Print Title"+driver.getTitle());
		// Assert.assertTrue(driver.getTitle().contains("Images"));
	}

	@Test(priority=3)
	public void  Adv()

	{
		WebElement Advs=driver.findElement(By.partialLinkText("Advertising"));  
		Advs.click();
		System.out.println("Print Title"+driver.getTitle());

	}


	@Test(priority=4)
	public void bussiness()
	{


		WebElement Advs=driver.findElement(By.partialLinkText("Business"));
		Advs.click();
		System.out.println("Print Title   : "+driver.getTitle());


	}



	@AfterMethod
	public void afterMethod() 
	{


		System.out.println("Logout"); 

	}



	@AfterTest
	public void afterTest()
	{

		driver.close();


	}



}