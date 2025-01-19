package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tagnamegetalllinks5 {

	public static void main(String[] args) 
	
	{
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");//How many links (Find)
		
		driver.manage().window().maximize();
	
		//1st
		List<WebElement> links=driver.findElements(By.tagName("a"));//Find all a tag
		
		System.out.println("Total Link : "+links.size()); //Out put 25
		
		//2nd
		//To get individual link name
		//System.out.println(links.get(0).getText());
		//System.out.println(links.get(1).getText());
        
		 //At time//Using Simple for loop
		 
		//for(int i = 0; i < links.size(); i++)
		//System.out.println(links.get(i).getText());
		 
		//3rd
   
		 //At time//Using Enhanced for loop  
	
	     for( WebElement b:  links)
	
	       System.out.println(b.getText()); //text name
	    
	     driver.close(); 	 
	    	 
	}
	
}
