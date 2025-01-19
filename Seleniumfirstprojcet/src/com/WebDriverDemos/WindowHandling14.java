package com.WebDriverDemos;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandling14 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.online.citibank.co.in/");
		
		//Window 1
		
		driver.findElement(By.xpath("//*[@id=\"popup1\"]/div/a"));
		//Window 1
		driver.findElement(By.xpath("//*[@id=\"popup2\"]/div/a"));
		
		//Click on span safe banking
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div[2]/div/div/div[2]/div/div/a[2]/span[2]")).click();		
		
		//After clicking (New window 2)
		System.out.println("Title"+ driver.getTitle());
		
		
		//Out put we will get : Window 1st page TitleCiti India - Credit Cards, Personal & Home Loans, Investment, Wealth Management & Banking
		
	  //Browser is showing (After clicking)Second window but selenium still in First page
		
		//So We need to take second page with selenium
		//How? (There is a method (
		
		
		//All window is having Id's we have to pass it here(Second window)
		
		//getWindowHandles()-To get Id's its Return (Set<String)
		Set<String> windows=driver.getWindowHandles();
		//Set is Un-oreder (We cant iterater(Using [0])
		System.out.println(windows);
		//Out put Window 1// [4341879F2CA76CAB55D40DDFA27C9489,Window-2 A5411FC570FF7A86387779E0200D0C6B]
		
		//If we want read /iterator Set value we can use iterator

		 Iterator<String> itr= windows.iterator(); 
		 String win1=itr.next();
		 String win2=itr.next();
		 
		 //System.out.println(win1);
		 //System.out.println(win2);
		
		
		
		//So We need to take second page with selenium
			//How? (There is a method (Switch Method)
			
		 driver.switchTo().window(win2);//Go to 1st window to Second
		System.out.println("Title :  "+driver.getTitle());
		//Out put Title :  Citibank India
		
		driver.findElement(By.linkText("Continue")).click();
		
		Thread.sleep(5000);
		//If you want come back to first window(1)
		driver.switchTo().window(win1);
		
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/ul[2]/li[1]/a")).click();
		
		driver.close();
		  

	}

}
