package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cssseslector3 {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		//4
		//CSSSELECTOR SINGLE ATTRIBUTE (To select the ELEMENTS)
		
		//If do not have any Unique id,name,attribute then
		//It should be show 1/1 uniquely identified
		
		//Single Attribute input[type=\"text\"]
		WebElement Emailid=driver.findElement(By.cssSelector("input[type=\"text\"]"));
		Emailid.sendKeys("Single cassSelector with text ");
		
		WebElement Password=driver.findElement(By.cssSelector("input[type=\"password\"]"));
		Password.sendKeys("Single cassSelector password");
		//Password.sendaKeys("Multioperation");
		
		
		//Double Attribute//input[type="submit"][name="Butsub"]
		
		//Tagname +[ any attribute]
		//input[type="submit"][class="btn btn-lg btn-block btn-primary"]//Only in Css selector we should put Complete value
		WebElement Loginbtn=driver.findElement(By.cssSelector("input[type=\"submit\"][class=\"btn btn-lg btn-block btn-primary\"]"));
		Loginbtn.click();
		
		//1>Special Characters ,^ [Start with)If in control Starting character is Fixed ending will changing
		
		//input[type^="ag_jkj_jj_56"]//56 is dynamic and it will change always
		
		//We should select only this much -input[type^="ag_jkj_jj]
		
		
		//$2>(Dollar )o (Ending is fixed -starting are changing) in control(Might possible)
		
		//input[type$="ag_jkj_jj]
		
		
		//3 *//If don't want to give complete value only ("phone")-Placeholder="Email address or phone number"]
		
	    // * means Contains (Means value is there or Not )
		
	    // input[placeholder*="Phone"]
	
	  //4) . (dot)(Get class name ) By.cssSelector(".myB");
		
	// 5 (#) to get ID( By.cssSelector("#myID");
	
	}

	
}



