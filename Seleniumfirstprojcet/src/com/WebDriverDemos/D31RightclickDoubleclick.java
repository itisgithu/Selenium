
package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D31RightclickDoubleclick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		Actions act = new Actions(driver);
		
		WebElement rightClickbtn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		//act.moveToElement(rightClick).contextClick().perform(); Using mouse
		act.contextClick(rightClickbtn).perform();//r(Action-Right click
		//act.moveToElement(rightClickbtn).perform();or
		
		List<WebElement> menus = driver.findElements(By.xpath("//*[@id=\"authentication\"]/ul/li/span"));
		for(WebElement m : menus)
			System.out.println(m.getText());
		
		menus.get(4).click();//index
		
		//Without JavaScriptExecutor (Go to alert)
		System.out.println("Alert Says: " + driver.switchTo().alert().getText());//Twp action
        driver.switchTo().alert().accept();//Go to alert
		
        
        
        
        
        //Next btn (Double Click)
        
		WebElement dblClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		//act.moveToElement(dblClick).doubleClick().perform();//MovetoElement is mouse
		act.doubleClick(dblClick).perform();//Action :doubleClick(dblClick)
		
		//Handling Alert
		System.out.println("Alert Says: " + driver.switchTo().alert().getText());//Alert test
		driver.switchTo().alert().accept();////Go to alert (Click Ok)
		
		
		WebElement insuranceProjectLink = driver.findElement(By.linkText("Insurance Project"));
		//act.moveToElement(insuranceProjectLink).click().perform();//
		//Three ways can click btn
		act.click(insuranceProjectLink).perform();
		act.doubleClick(insuranceProjectLink).perform();
		act.moveToElement(insuranceProjectLink).click().perform();
	}

}
