package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assign19 {

	public static void main(String[] args) throws InterruptedException {
	
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Implicit way(Most Using this)
		
		
		
		driver.get("https://omayo.blogspot.com/");
		
		//https://omayo.blogspot.com/
		//Check box
		WebElement checkbox=driver.findElement(By.xpath("//*[@id=\"dte\"]"));
		//checkboxbtnButton
		WebElement checkboxbtn=driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button"));
		//Before 
		System.out.println("Before Clicking the btn");
		if(checkbox.isDisplayed())
			
		{
			System.out.println("Check box is Displayed");
		}else
		{
			System.out.println("Check box is Not Displayed");
		}
		
		
		System.out.println("Before Clicking the btn");
		
		if(checkbox.isEnabled())
			
		{
			System.out.println("Before Check box is Not Enabled");
		}
		else
		{
			System.out.println("Check box is disabled");
		}
		
		//Button
		if(checkboxbtn.isEnabled())
		{
			System.out.println("Button is Enabled");
		}
		else
		{
			System.out.println("Button is Not Enabled");
			
		}
		
	//After click the button	
		
		checkboxbtn.click();
		Thread.sleep(10000);
		
		checkbox.click();
		System.out.println("After clicking the buttn");
		
		if(checkbox.isDisplayed())
		
		{
			
			System.out.println("after click Check box is displayed");	
		
		}else
		{
			 System.out.println("after click Check box is not displayed	"); 
			
		}
		
		if(checkbox.isEnabled())
		{
			System.out.println("Check Box Is enabled");
		}
		else
		{
			System.out.println("Check Box Is not enabled");
			
		}
		
		//If condition not  Isdisplay btn required bcs we already find out on using X.path
		

		
		//If button Is disable can't click then    Use = ( IsEnable)method
		
		//If checking button is Displaying or Visible on the screen and 
		//height and width is greater than 0 = then Use IsDisplay 

	}

}
