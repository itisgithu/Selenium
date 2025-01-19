package Demotestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Utilityclassformethods8 {
	WebDriver driver;   //Utility & Client class ( for WebDriver driver) Object Should be same
	
	//Last page factory
	
	@FindBy (id="newpasswd")private WebElement Password;
	@FindBy (xpath="//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")private WebElement RediffId;
	//Or@FindBy (id="newpasswd") WebElement Password;
	
	
	//Create Constructor
	
	public Utilityclassformethods8(WebDriver d) //This from Client ((WeDriver pass to d) >  Store it in d)
	{
		
   driver=d;//d will pass to driver
   PageFactory.initElements(driver,this);//This will refers to driver object
		
	}
	
	
	
	
	
	public void setFullname(String fullname)   //It contains WebElement and  Methods
	{
		//Clientclass.driver.findElement(By.cssSelector("input[maxlength=\"61\"]")).sendKeys("Nagaraj Naik");
		driver.findElement(By.cssSelector("input[maxlength=\"61\"]")).sendKeys("Nagaraj Naik");
		
	}
	
	
	public void setRediffId(String id) {
		
		//driver.findElement(By.cssSelector("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("setRediffId");//PageObject
		
		RediffId.sendKeys(id);
	
	}
	
	public void setPassword(String ps) {
		//driver.findElement(By.id("newpasswd")).sendKeys("pas123");
		
		//Password.sendKeys("NAAGA123");//Page factory
		Password.sendKeys(ps);
		
		
		
	}
	

	public void setConfirmPassword(String rpsw) {
		driver.findElement(By.id("newpasswd1")).sendKeys(rpsw);
	}
	
	public String checkAvailablity() throws InterruptedException
	{
		driver.findElement(By.className("btn_checkavail")).click();//To click
		Thread.sleep(2000);
		return(driver.findElement(By.xpath("//*[@id=\"check_availability\"]/font"))).getText();//To get Text
	}
	
	
	
  
}
