package com.WebDriverDemos;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Table11 {

	public static void main(String[] args) 
	{
	
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    
    driver.get("https://money.rediff.com/gainers");
 
	
	//1>First Display the Headers
    
   // List<WebElement> header=driver.findElements(By.tagName("th"));
    
    //Or(If table adding dynamically we are using X.path
    List<WebElement> header=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
    
    //For Header Size
	System.out.println("Display All Header size = "+header.size()); // Out Put: Header size6
	
	
	//For Header Text
	for(WebElement c: header)
	{
		
		System.out.println("Display all header List:  "+c.getText());
		
	}
		//OutPut Display all header TextCompany
//	Display all header TextGroup
//	Display all header TextPrev Close (Rs)
//	Display all header TextCurrent Price (Rs)
//	Display all header Text% Change
//	Display all header TextTrade on Dhan
	
	//Output for Dynamic
//	Display All Header size = 6
//			Display all header List :Company
//			Display all header List :Group
//			Display all header List :Prev Close (Rs)
//			Display all header List :Current Price (Rs)
//			Display all header List :% Change
//			Display all header List :Trade on Dhan

	
	//For first(Singal) clmn /and data
	WebElement firstcolumn= driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[1]"));
	
	System.out.println("Header: " + firstcolumn.getText());
	
	//First column
	List<WebElement> firstclmall=  driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
	
	
	for (WebElement row : firstclmall)
	{
	    System.out.println(row.getText());
	}
	
	
	

	

//	//2>Total Number of Rows
	

List<WebElement> row=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
//	//Toatl Size of all row
	
	
//	//Toatl Size of all row
System.out.println("Number of rowe"+row.size()); // Number of rowe 2182

//	//Specific row
	System.out.println("Specific Row ="+ row.get(0).getText());
	
//	//Random Row(List index(0-7)=8(Like rock-paper-scesers(Java script)
	
	Random rnd=new Random();
	int i = rnd.nextInt(row.size());//Here i 7 means index (0,7) 8Value
	System.out.println("Random row    = " + row.get(i).getText()); //get for(Index ,links)
	
//	//Random Row Using Xpath Index(1-7) (Like rock-paper-scesers(Java script)
	WebElement xrandom=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+ (i+1) + "]"));//Index start from 1-7 means index 7
    System.out.println("Xpath randam ="+xrandom.getText());
	
    //So (i+1)
	
    
    
   
	// AllNumber of rowe 2182
		for(WebElement my: row)
{
		System.out.println("Total number of row should update"+my.getText());
		
		}
		
		
	
	driver.close();

	}

}
