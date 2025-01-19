package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assign18 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login process
        Thread.sleep(5000);
        WebElement usern = driver.findElement(By.cssSelector("input[placeholder=\"Username\"]"));
        usern.sendKeys("Admin");

        WebElement psw = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        psw.sendKeys("admin123");

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        btn.click();

        // Click on the profile dropdown
        Thread.sleep(5000);
        WebElement dropimg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span"));
        dropimg.click();

        // Locate all dropdown options
        Thread.sleep(2000); // Wait for dropdown to become visible
        List<WebElement> drplist = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li"));

        // Print the size of the dropdown
        System.out.println("Number of options in dropdown: " + drplist.size());

        // Print all the options' text
        for (WebElement option : drplist) {
            System.out.println(option.getText().trim()); // Trim to avoid extra spaces
        }

        // Click on the "Logout" option
        WebElement logoutOption = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
        logoutOption.click();

        // Close the browser
        driver.quit();
    }
}
