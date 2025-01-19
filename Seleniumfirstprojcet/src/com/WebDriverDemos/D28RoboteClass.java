package com.WebDriverDemos;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D28RoboteClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://sampleapp.tricentis.com/101/index.php");
		

		driver.findElement(By.linkText("Automobile")).click();
		driver.findElement(By.linkText("Enter Insurant Data")).click();

		driver.findElement(By.id("open")).click();
		
		
		
		Robot rbt = new Robot();
		
		for(int i=0;i<9;i++)
		{
		
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_TAB);
		
		}
		
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		
		rbt.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyPress(KeyEvent.VK_TAB);
		
		
		for(int i=0;i<13;i++);
		{
		
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_DOWN);//DOWNLOADS FILE OPEN
		
		}
		
		rbt.keyPress(KeyEvent.VK_ENTER);//File has been Uploaded
		
}
}