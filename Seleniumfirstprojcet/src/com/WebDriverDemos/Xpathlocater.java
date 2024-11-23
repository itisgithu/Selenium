package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathlocater {

	public static void main(String[] args) 
	
	{
	
		//XPath Locator- ( Lengthy) Index start with -1 [1]
		
        //X path is _Telling to check  path to the [Input control >from HTML ] Reverse order
		//If number div tag is there -div>div>like that...

    //1 - Absolute Xpath (Start With HTML)
		
	       WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
			
		
		   WebElement expathusername=driver.findElement(By.xpath("html>body>div>div>div>div>input"));
		   expathusername.click();
		   
		// input[name="txtCustomerID"]
		
		
		  
		
		
		

	}

}
