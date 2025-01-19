
package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D34Slide {

	public static void main(String[] args) {
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://jqueryui.com/");
		
		
		
				
		Actions act=new Actions(driver);
		
		
		WebElement slidelink=driver.findElement(By.partialLinkText("Slider"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);"+slidelink);//Not arguments[0].

		
		slidelink.click();
		
		
		
		//Inside 
        driver.switchTo().frame(0);
       WebElement  slide=driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
       act.dragAndDropBy(slide,slide.getLocation().x+500,slide.getLocation().y).perform();
       
	}

}
