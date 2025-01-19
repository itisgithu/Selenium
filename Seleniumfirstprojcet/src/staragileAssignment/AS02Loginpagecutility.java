package staragileAssignment;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class AS02Loginpagecutility {

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	private WebElement username;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	private WebElement password;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement loginbutton;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")private WebElement errormessage;
	
	
	WebDriver driver;

	public AS02Loginpagecutility(WebDriver d1) {
		driver = d1;
		PageFactory.initElements(driver, this);
	}

	public void username(String un) {

		username.sendKeys(un);

	}

	public void password(String pw)

	{
		password.sendKeys(pw);
	}

	public void login()

	{
		loginbutton.click();

	}

	public boolean isErrorMessageDisplayed() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(errormessage));
	        return errormessage.isDisplayed();
	    } catch (NoSuchElementException | TimeoutException e)
	    {
	        return false;
	    }
	}



}
