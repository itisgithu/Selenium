package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linktest4 {

	public static void main(String[] args) {
		
		
       WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		
		//Linktest or Partial link -Only  (a (anchor tag )
		
		//1Linktest
		
		WebElement storelink=driver.findElement(By.linkText("Echo Employee Login")); //Echo Employee Login(Inner Text)
		storelink.click(); //
    
		if(driver.getTitle().contains("Echo Employee Login"))
		{
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
		driver.navigate().back();//For test the another link(Home page)
		
		//2- PartialLink -If too many(Lengthy) InnerText is there in a(anchor tag then )we can use single word
		
		WebElement partiallink=driver.findElement(By.partialLinkText("your")); //Instead of(Forgot your password?
		
		partiallink.click();
		if(driver.getTitle().contains("your"))
		{
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		
		}
		
		driver.navigate().back();//For test the another link(Home page)
		//driver.close();
		
		
		//Only For Single operation we can create like this also(No need to create reference variable object(Like obove)
		//driver.findElement(By.partialLinkText("your")).click();
		
		
	}

}
