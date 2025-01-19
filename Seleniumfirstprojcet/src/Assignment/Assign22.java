package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign22 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//1
		WebElement usernm =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		usernm.sendKeys("Admin");//admin also okey bcs username is no case sensitive
		//Thread.sleep(5000);
		
		
		WebElement psw=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		psw.sendKeys("admin123");
		//Thread.sleep(5000);
		
		
		WebElement btn=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		btn.submit();
		//Thread.sleep(5000);
		
		//Click on PIM (In Menus)
		
		List<WebElement> menus= driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a"));
		menus.get(1).click();
		
		
		//Click on +Add buttton
		
		WebElement plusaddbtn=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		plusaddbtn.click();
		
		//First Name
		
		Thread.sleep(4000);
		WebElement ftname=driver.findElement(By.name("firstName"));
		ftname.sendKeys("Nagaraj  Manjunath Naik");
		
		
		//Second name
		
		Thread.sleep(4000);
		WebElement mname=driver.findElement(By.name("middleName"));
		mname.sendKeys("Manjunath");
		
		//Thread.sleep(4000);
		WebElement Lname=driver.findElement(By.name("lastName"));
		Lname.sendKeys("Naik");
		
		
		//Click btn
		WebElement createlogin=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
		createlogin.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)", "");
		
		//Next enter user name:
		
		WebElement usrn= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
		usrn.sendKeys("nagarajmnaik@1997");
		
		Thread.sleep(4000);
		WebElement psww=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
		psww.sendKeys("nagaraj@100");
		
		WebElement cnfpsw= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
		cnfpsw.sendKeys("nagaraj@100");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		// Retrieve the values from the user(When we entered above) input fields
		
		String passwordValue = psww.getAttribute("value");
		String confirmPasswordValue = cnfpsw.getAttribute("value");
		
		if(passwordValue.equals(confirmPasswordValue))
		{
			System.out.println("User account has been created");
		}
		else
		{
			System.out.println("Password mismatch");
		}
		
		//save btn
		WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
		savebtn.click();
		wait.until(ExpectedConditions.invisibilityOf(savebtn));
		
		//Logout //For menu (ul[]) ignore this
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='oxd-userdropdown-tab']")));
		
		WebElement clickdropdown=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
		clickdropdown.click();
		
		
		List<WebElement> list=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='oxd-dropdown-menu']/li/a")));
		WebElement logoutButton = list.get(3);
		logoutButton.click();
	
	//Or
	
      //Exception Handles(StaleElementReferenceException-Bcs some times Twice refreshed page)
//	    for (WebElement option : list) 
//	    {
//            if (option.getText().equals("Logout"))
//            {
//                try {
//                	option.click();
//                  } catch (StaleElementReferenceException e) {
//                    System.out.println("Retrying due to stale element.");
//                    option = driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li/a[contains(text(),'Logout')]"));
//                    option.click();
//                }
//                break;
//            }
//        }
//		
	
		
	
		// Re-login with the newly created user credentials
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Wait for the page to load (you can use an explicit wait here for better performance)
        // Wait for the page to load using WebDriverWait
     
		
		WebElement usernLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
		usernLogin.clear();  // Clear user name field
		usernLogin.sendKeys("nagarajmnaik@1997");

		//Thread.sleep(5000);
		WebElement pwLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")));
		pwLogin.clear();  // Clear password field
		pwLogin.sendKeys("nagaraj@100");

		Thread.sleep(5000);
		WebElement btLogin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		btLogin.submit();

		// Logging entered credentials
		String enteredUsername = usernLogin.getAttribute("value");
		System.out.println("Entered Username: " + enteredUsername);

		String enteredPassword = pwLogin.getAttribute("value");
		System.out.println("Entered Password: " + enteredPassword);

		// Add this to check if the login failed due to incorrect credentials
		try {
		    WebElement errorMessage = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']"));
		    System.out.println("Login failed with error: " + errorMessage.getText());
		} catch (Exception e) {
		    System.out.println("Login successful.");
		}
		

		// Validate employee name
		
		 
		
       WebElement logutEname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]")));		
      	
      	String empployeename = logutEname.getText();
        System.out.println("Employee Name: " + empployeename);

		if (empployeename.contains("Nagaraj Manjunath") && empployeename.contains("Naik")) 
		{
		    System.out.println("Employee profile created successfully.");
		} else {
		    System.out.println("The displayed name is incorrect: " + empployeename);
		}

        
        Actions act=new Actions(driver);
        
        WebElement myinfo=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span"));
        
        act.click(myinfo).perform();
        
        
        //Display EmployeeId
        
        
        
        
			//driver.close();	
		
	}

}
