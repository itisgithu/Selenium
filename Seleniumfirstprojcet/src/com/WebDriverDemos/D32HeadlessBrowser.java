
package com.WebDriverDemos;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class D32HeadlessBrowser {
	
	
	
	public static void main(String[] args) throws InterruptedException
	{
		
		//ChromeOptions op =new ChromeOptions();
		//op.addArguments("--headless");
		//op.addArguments("--disable-notifiaction"); //Headless (Means not open page)
		//--------------------------------------------------
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0, 0));
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		
		Actions act=new Actions(driver);
		
		
		WebElement rightclick=driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		
		act.contextClick(rightclick).perform();
		
		
		
		
		List<WebElement> menus = driver.findElements(By.xpath("//*[@id=\"authentication\"]/ul/li/span"));
		for(WebElement m : menus)
			System.out.println(m.getText());
		
		menus.get(4).click();//delete
		
	    //Handling alert
		
		Alert alt=driver.switchTo().alert();
		System.out.println("Text "+ alt.getText());
		alt.accept();
	    //Direct : diver.switchTo().alert().accept();
	     
	     //After double click
		WebElement dblClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		act.doubleClick(dblClick).perform();
	     
	     
	     
         //After double click Handling alert
        Alert doubleClickAlert = driver.switchTo().alert();
        System.out.println("Double-click alert text: " + doubleClickAlert.getText());
        doubleClickAlert.accept(); // Ok alert
		
		Thread.sleep(5000);
        
        WebElement insuranceProjectLink = driver.findElement(By.linkText("Insurance Project"));
		act.moveToElement(insuranceProjectLink).click().perform();
		//act.click(insuranceProjectLink).perform();
		//driver.close();		
		
	}
	

}
