
package com.WebDriverDemos;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D30Hoveringmouse {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://istqb.in/");
		
		Actions act = new Actions(driver);//Pass the Object of WebDriver
	
	  
		WebElement spMenu = driver.findElement(By.linkText("SPECIALIST"));
		
		act.moveToElement(spMenu).perform();//(Mouse move to specific element moveToElement)SPECIALIST
		//perform(); (Specified action will only when we use this method)
		
		
		Thread.sleep(2000);
		
		List<WebElement>subMenus = driver.findElements(By.xpath("//*[@id=\"sp-menu\"]/div/nav/ul/li[6]/div/div/ul/li/a"));
		System.out.println(subMenus.get(2).getText());//Particular : DOWNLOADS RESOURCES
		
		
		System.out.println("Sub menus from Specialist menu are");
		for(WebElement s : subMenus)
		System.out.println(s.getText());
		
		
		///Naviagtion
		
		//driver.get("https://www.google.com");
				driver.navigate().to("https://www.google.com");
				
				driver.findElement(By.partialLinkText("How")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				driver.navigate().refresh();
				Thread.sleep(2000);
				driver.navigate().forward();
				
		
		driver.close();
	}

}
