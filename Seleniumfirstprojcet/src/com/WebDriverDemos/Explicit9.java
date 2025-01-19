package com.WebDriverDemos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicit9 {

	public static void main(String[] args) throws InterruptedException 
	
	
	//It same a Thread single statement but it does not wait for mandatory  delay 
	{
		
		     	WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				
				
			
				
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				driver.get("https://omayo.blogspot.com/"); 
				
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			//(Waiting for web page to load or specific element to become visible or click able
				
			    WebElement btn=	driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button"));
			    btn.click();
				
				WebElement chkBox = driver.findElement(By.id("dte"));
				System.out.println("Enabled: " + chkBox.isEnabled());
				
				wait.until(ExpectedConditions.elementToBeClickable(chkBox)).click();
				//Wait until 30sec
				//chkBox.click();
				System.out.println("Enabled: " + chkBox.isEnabled());
				
			
	       }

		} 	
		
		
		
		

