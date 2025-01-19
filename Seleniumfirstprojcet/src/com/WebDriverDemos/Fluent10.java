package com.WebDriverDemos;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Fluent10 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Additional delay Page loading (5)
		//Page should be load immediately  so 
		
		//driver.get method(Will wait maximum 30sec to page get loaded+Additional (pageloadTime)
		driver.get("https://www.redbus.in/");//Maximum 30sec wait(If not open SessionTimeout Exception)
		
		//1st Create a object
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		
		
		//From
		//Search box
		WebElement search=driver.findElement(By.id("src"));//To find input[id="src"]or #src
		search.sendKeys("kohlapur");
		//Here wait after written text
		
		//Main Container(From-to -date)To display
		 wait.withTimeout(Duration.ofSeconds(10))//Maximum //If get 2 sec it execute
		.ignoring(NoSuchElementException.class)//In java( Set interface we are getting this error)
		.pollingEvery(Duration.ofMillis(1));//Every Millis sec it checks weather the controll is visible or Not
	     //Container
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text"))).click();//Main container
		
		//IMP: The method visibilityOfElementLocated(By) in the type ExpectedConditions is not applicable for the arguments (WebElement)
		
		
		//To 
		driver.findElement(By.id("dest")).sendKeys("Ban");
		Thread.sleep(5000);
		//Main Container(Same as above)(From-to -date)to display
		driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[3]/div[1]/ul/li[1]/div/text")).click();
		
		//Calendar (Without object creation it created (These are  static methods (stfindElement)
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/i")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[6]/span[1]/div[6]/span[1]")).click();
		
		//Search Bus
		driver.findElement(By.id("search_button")).click();
		
		//Display result
		System.out.println(driver.findElement(By.xpath("//*[@id=\"13872137\"]/div/div[1]/div[1]/div[1]/div[1]")).getText());
		
		driver.close();
		
		
		
	}

}
