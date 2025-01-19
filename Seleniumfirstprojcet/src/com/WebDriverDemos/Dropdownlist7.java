package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownlist7 {

	public static void main(String[] args) {
		
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//To find single name should create a select object
		
		//1st
		WebElement  droplist=driver.findElement(By.id("country"));
		//2nd
		Select countries =new Select(droplist);
		
		//Selected first text
		System.out.println("Selected Country"+ countries.getFirstSelectedOption().getText());//First Selected CountryIndia
		
		countries.selectByVisibleText("Zimbabwe");//Particular inner text(Selected On web page)
		countries.selectByValue("222");//Selecting By value value="222";
		countries.selectByIndex(2); ///Selecting By Index[2] Andorra
		
		
		//Handle Multiple 
		//3rd
		List<WebElement>countryList =countries.getOptions();
		System.out.println("Total Number of countries "+countryList.size()); //228
		
		//4th
		//Using Simple for loop 
		for(int i =0 ; i<countryList.size();i++)
		{
			System.out.println(i + ". " + countryList.get(i).getText());
		}
		
		
		
		driver.close();

	}

}
