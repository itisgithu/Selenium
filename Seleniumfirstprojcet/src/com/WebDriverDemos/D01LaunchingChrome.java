package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D01LaunchingChrome {

	public static void main(String[] args)
	
	{
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		
		//If you're on the Google homepage (https://www.google.co.in/), the title could be "Google", while the current URL could be "https://www.google.co.in/"
		//For Get title -1
		String title= driver.getTitle();//It doesn't  have a Class name so direct call
		
		if(title.contains("Google"))
			System.out.println("Correct");
		else
		{
			System.out.println("Wrong");
			
		}
		
	//For current URL-2
//		Example: If the current URL is "https://www.google.co.in/", this will return "Current URL" because the URL contains the word "Google".
//		String curreentURL=driver.getCurrentUrl();
//		if (curreentURL.contains("Google"))
//	
//			System.out.println("Currecnt  URL");
//		else
//		{
//			System.out.println("Wrong");
//		}
//		
		
		// Find getPageSource()
		
		String pagesource=driver.getPageSource();
		
		System.out.println(pagesource); //It give the HTML Source code 
		
		
		//FindElement ()  send keys- click- From the webpage ( In assignment)
		
		
		
		
		
		driver.close();

	  
	}

}
