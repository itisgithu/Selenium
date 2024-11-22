package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Assignment {
	
	public static void main(String[] args)
	{

		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		//getPageSoucre code
//		String source=driver.getPageSource();
//		System.out.println(source);
		
		//FindElement ()  send keys- click- From the webpage ( In assignment)
		
		//Using ID
		
//		WebElement Emailid=driver.findElement(By.id("txtCustomerID"));//Class name:form-control-Name-txtCustomerID
//		 
//		Emailid.sendKeys("nagarajnaiknew36@gmail.com");			
//		
//		
//		WebElement Password=driver.findElement(By.id("txtPassword"));//Name:txtPassword:Class:form-control
//		
//		Password.sendKeys("Nagarj565656");
//		
//		WebElement Login=driver.findElement(By.id("Butsub"));//Name: Butsub ,Class: btn btn-lg btn-block btn-primary
//		Login.click();
//		
		
		
		//USING CLASSNAME
		
		WebElement Username=driver.findElement(By.className("form-control"));
		Username.sendKeys("Nagarajnaik");

		WebElement Password2=driver.findElement(By.id("txtPassword"));
		Password2.sendKeys("Nagaraj45645465");

		WebElement Loginbtn=driver.findElement(By.className("btn-primary"));
	    Loginbtn.click();
		
		
		
	    //Error Message 
	    WebElement Errormessage=driver.findElement(By.className("btn-primary"));
	    String msg=Errormessage.getText();
	    System.out.println("Error message"+msg);
}
}