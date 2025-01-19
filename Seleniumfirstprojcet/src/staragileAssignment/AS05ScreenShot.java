package staragileAssignment;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AS05ScreenShot {
	WebDriver driver;

	@Test
	public void Search() throws InterruptedException, IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement searchBar = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
			searchBar.sendKeys("macbook pro");

			Thread.sleep(5000);
			List<WebElement> Searchlists = driver
					.findElements(By.cssSelector("div[aria-label=\"macbook pro m4 max\"]"));
			for (WebElement searchlist : Searchlists) {
				if (searchlist.getText().contains("macbook pro m4 max")) {
					searchlist.click();
					System.out.println("Clicked on macbook pro m4 max");

					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(screenshot, new File("AS05Screenshot\\Asnone.jpeg"));
					System.out.println(" capture a screenshot of a webpage  and Saved in the Specific Location'");

					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());

		} finally {

			System.out.println("");

		}

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {

	}

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException, IOException {

		driver.navigate().back();
		System.out.println("Returned to the home page.");
		File Screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(Screenshot2, new File("AS05Screenshot\\AsnTwo.jpeg"));
		System.out.println(" capture a screenshot of a webpage  and Saved in the Specific Location'");

	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
