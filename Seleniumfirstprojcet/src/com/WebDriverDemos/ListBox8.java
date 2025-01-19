package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBox8 {



	public static void main(String[] args) 
	{
		
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		
		//1st

		WebElement listbox=driver.findElement(By.id("multiselect1"));
		
		//2nd
		Select cars =new Select(listbox);
		
		//3rd
		List<WebElement> carssizeandall=cars.getOptions();
		System.out.println("Get size of List Box"+carssizeandall.size());//OutPut Get size of List Box4
		
		
		//System.out.println(carssizeandall.get(0).getText());
		
		//Enhanced For loop
	     for( WebElement  a: carssizeandall )
	     {
			System.out.println(a.getText());
		
         }
	    //cars.selectByVisibleText("Swift");
	   // cars.deselectByVisibleText("Swift");
	    cars.selectByValue("swiftx");
	    cars.deselectByValue("swiftx");
	     //Using Simple for loop
//		for(int a1=0 ; a1<carssizeandall.size();a1++)
//		{
//			System.out.println(" Total list box"+carssizeandall.get(a1).getText());
//		}
		
		//OutPut Total list boxVolvo
		// Total list boxSwift
		// Total list boxHyundai
		// Total list boxAudi
		
		
		
	
//		//Here Checking List Box or Drop down
	if(cars .isMultiple()==true) //Here we should check weather it is Drop down list or List Box
		{
			
			cars.selectByIndex(0);
		    cars.selectByIndex(3);
		
		
		List<WebElement> selectedCars=cars.getAllSelectedOptions();
		
		System.out.println("\nSelected cars...");
		for(WebElement  sc:  selectedCars)
		{
			System.out.println(sc.getText());
		}
		        // OutPut Selected cars...
		       //   Volvo
		         // Audi
		                       
		
		
		cars.deselectByIndex(0);

		
		}  
		
	
		
	}

}
