package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multipletextboxhandle {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		//To handle multiple text ( User name password using direct CssSelector)
		
		List<WebElement> multitxtbox=driver.findElements(By.cssSelector("input[name^=\"txt\"]"));
		
		multitxtbox.get(0).sendKeys("Username enter");
		multitxtbox.get(1).sendKeys("Password Enter");
		Thread.sleep(5000);
		WebElement btn=driver.findElement(By.xpath("//*[@id=\"Butsub\"]"));
		btn.click();
		
		driver.close();
		
		
	}

}
