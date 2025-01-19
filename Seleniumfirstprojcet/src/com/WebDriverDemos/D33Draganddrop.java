
package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D33Draganddrop {

	public static void main(String[] args) throws InterruptedException {

		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://jqueryui.com/");
		
		
		Actions act=new Actions(driver);
		WebElement draglink=driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
		draglink.click();
		
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;//For my reference
		js.executeScript("window.scrollBy(0, 200)", "");

		//driver.switchTo().frame(0)//
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
		
		//Here (from where to where)
		
		WebElement from=driver.findElement(By.id("draggable"));
		WebElement to=driver.findElement(By.id("droppable"));
		Thread.sleep(5000);
	
	    act.dragAndDrop(from, to).perform();
	
	  
	
	}

}
