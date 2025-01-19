package staragileAssignment;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AS02Loginpageclient {
	String expURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	AS02Loginpagecutility loginPage;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new AS02Loginpagecutility(driver);
		driver.get(expURL);
	}

	@Test(dataProvider = "validData", priority = 1)
	public void validLoginTest(String username, String password) {
		loginPage.username(username);
		loginPage.password(password);
		loginPage.login();
		String expectedDashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedDashboardUrl, "The current URL does not match the expected URL.");
		System.out.println("Executed validLoginTest with username: " + username + "and valid password  : " + password + "");
	}

	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "Admin", "admin123" } };
	}

	@Test(dataProvider = "invalidData", priority = 2)
	public void invalidLoginTest(String username, String password) {
		loginPage.username(username);
		loginPage.password(password);
		loginPage.login();
		// Check if the error message is displayed for invalid login
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid credentials.");
		System.out.println("Executed invalidLoginTest with username: " + username + ", password: " + password
				+ ", Error Message Displayed: " + loginPage.isErrorMessageDisplayed());
	}

	@DataProvider
	public Object[][] invalidData() {
		return new Object[][] { { "ramya", "ramya@123" }, { "sahana", "sahanaj@123" }, { "Admin", "ad789" },

		};
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
