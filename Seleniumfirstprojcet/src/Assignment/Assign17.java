package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assign17 {

	
	
	


public static void main(String[] args) throws InterruptedException 
{
	

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Implicit way
	
	driver.get("https://dash.bling-center.com/platform/signIn.html ");
	
	
	
	
	WebElement forgot=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[2]/div/div/div[5]/button"));
	forgot.click();
	WebElement emailid=driver.findElement(By.xpath("//*[@id=\"email1\"]"));
	emailid.sendKeys("nagara@123");
	
	WebElement resetpsw=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div/div[2]/button[2]"));
	resetpsw.click();
	
	WebElement greentext=driver.findElement(By.id("resetsuccess"));
	Thread.sleep(2000);
	System.out.println("Message"+greentext.getText());
	
	//Out put 
	
	//MessagePassword Reset Instructions Sent to the email
	//(Please check spam folder too.)

	
}}