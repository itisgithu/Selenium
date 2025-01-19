package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class D27Fileuploader {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		//To scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)", "");
		
		//Upload a file
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\nagar\\Documents\\A\\Nagaraj Naik24R.pdf");
	//This will upload
	
	

	}

}
