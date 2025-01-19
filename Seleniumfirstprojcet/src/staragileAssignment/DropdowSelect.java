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

public class DropdowSelect {

	public static void main(String[] args) {


		//Write a WebDriver script to handle a dropdown and select an option based on specific criteria.	

		WebDriver driver=new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
			


			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

			WebElement dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));//Or

			//	WebElement dropdown = driver.findElement(By.id("country"));
			//	wait.until(ExpectedConditions.visibilityOf(dropdown));
			
			Select select=new Select(dropdown);

			List<WebElement> allistoption=select.getOptions();
			System.out.println("Total number Countries in dropdownlist : "+allistoption.size());
			//We can use this also & also Add it in object pass to Explicit
			//allistoption.get(1).getText();

			for(WebElement option: allistoption)
			{
				System.out.println(" Name of the Countries : "+option.getText());//It returns only single data at a time

			}

			//		String countryName = "India"; // Select driver will select this   country
			//        select.selectByVisibleText(countryName);Or

			//Or
			//		WebElement index=allistoption.get(4);
			//		wait.until(ExpectedConditions.elementToBeClickable(index));
			//		select.selectByIndex(4);
			
			

			select.selectByIndex(10);//Which index should be select

			String selectedoption=select.getFirstSelectedOption().getText();//getFirstSelectedOption(Selected name )
			System.out.println("Seleted contry name is : "+selectedoption);

		}
		catch(Exception e)
		{

			System.out.println("An error occurred:"+e.getMessage());
		}

		finally {

			driver.close();
			System.out.println("Browser closed");


		}

	}
}






















