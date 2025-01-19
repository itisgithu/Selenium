package com.WebDriverDemos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandligAlert13 {

	public static void main(String[] args) throws InterruptedException {
	
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts" );
		
		
		
		Alert alt; //reference of Alert Interface
		
		//Click button
		//driver.findElement(By.id("alertButton")).click();
		
		
		//1>Jump to Alert : switchTo()
		//alt=driver.switchTo().alert();
		
		//2>Display or read :Alert -getText
		//System.out.println("Display or Read a Text "+ alt.getText());
		
		//3> Click On Alert Ok button accept()
		//alt.accept();//Not directly click Selenium is not able to click the control(Hidden by another controll)
		//
		
        //Using JavaScriptExecutor We can Handle ( Interface)
		
		//JavascriptExecutor js=driver ;      //Reference Of Alert interface
		//Using type casting
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",driver.findElement(By.id("alertButton")));	
		//Arguments [0] -means above control 1st Control (Free defined Arguments)
		alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(10000);
		alt.accept();
		
		//driver.close();
		
		//2>Next btn
         
		js.executeScript("arguments[0].click()",driver.findElement(By.id("timerAlertButton")));
		//jump to alert
		//alt=driver.switchTo().alert();(Until will return not required we using Explicit)
		
		
		//alt.accept();//This will click before 5sec so we should handle with Explicit
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		alt=wait.until(ExpectedConditions.alertIsPresent());//Store it in alert
		//get display
		System.err.println(alt.getText());
		alt.accept();
		
		
		//3>Click on Cancel button use Dismiss(Using Scroll)
		
		//Until will return Alert (Not required this alt=driver.switchTo().alert();)
		
	    js.executeScript("window.scrollBy(0,400)","");
	    driver.findElement(By.id("confirmButton")).click();
		alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
		
		
		//4rth(Js.executeScript is not required bcs not webpage scrolled
		driver.findElement(By.id("promtButton")).click();
		alt=driver.switchTo().alert();
		alt.sendKeys("Nagaraj Naik");
	    alt.accept();
	}

}
