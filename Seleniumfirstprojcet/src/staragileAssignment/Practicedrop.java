package staragileAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practicedrop {

	public static void main(String[] args) {
		
		
		    WebDriver driver=new ChromeDriver();
	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		
		   WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		   
		   WebElement drop=driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
		   wait.until(ExpectedConditions.visibilityOfAllElements(drop));
		   Select select=new Select(drop);
		
		
		   List<WebElement> all=select.getOptions();
		   System.out.println("Total number of dropdown"+all.size());
		   
		   
		   // For Individual
		   System.out.println(all.get(1).getText());
		  
		   //Iterate all
		   	   for(WebElement iterate: all )
		   {
			   System.out.println("Get all test "+iterate.getText());
		   }
			   
		   
		  //Select Particular Individual index(1)-1 way 
		  select.selectByIndex(4);
		 
		  //Select Particular Individual index(4)-2 way
		  WebElement index=all.get(4);
		  wait.until(ExpectedConditions.elementToBeClickable(index));
		  select.selectByIndex(4);
		   	   
		 
		  //Select Particular Individual index Using name(2)
		   String name ="Chennai";
		  select.selectByVisibleText(name);
		  
		  
		  
		  //  Print Selected item  
		 String print= select.getFirstSelectedOption().getText();
		 System.out.println("Selected Item  : "+print);
		   	   
		
		
		
	
	}

}
