package staragileAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigateweb {

	public static void main(String[] args) {
		
///1. Write a WebDriver script to navigate to a WebSite and click on a specific link.	
		
		WebDriver driver=new ChromeDriver();
		
		
		try	
		{
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		
		
		WebElement link=driver.findElement(By.linkText("Gmail"));
		System.out.println("Click on a specific link  : "+link.getText());
		  
//		    if(link.getText().contains("Gmail"))//My reference
//			{
//		
//		    System.out.println("Web page opened");
//		
//			}else
//			{
//				System.out.println("Not");
//			}
		
		
		link.click();
	    String CrntUrl=driver.getCurrentUrl();
		System.out.println("Current URL after clicking the link  : "+ CrntUrl);
		
		         if(link.getText().contains("Gmail"))
				{
			
			System.out.println("Web page opened");
			
				}else
				{
					System.out.println("Not");
				}
		
		
		}	
		catch(Exception e)
		{
			
			System.out.println("An error occurred:"+ e.getMessage());
			
		}
		
		finally
		{
			
		driver.close();
		System.out.println("Browser closed");
		}
		
		
	

}}