package staragileAssignment;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AS04Registrationformutility {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")
	private WebElement fname;

	@FindBy(xpath = "/html/body/center/form/div/table[2]/tbody/tr[7]/td[3]/input[1]")
	private WebElement emailid;

	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")
	private WebElement checkavbutton;

	@FindBy(xpath = "//*[@id=\"check_availability\"]/font/b")
	private WebElement avmsg;

	@FindBy(xpath = "//div[@id='recommend_text']//input[@name='radio_login']") // Starting and ending
	private List<WebElement> suggestionsradiobuttons;//Radio button

	@FindBy(id = "newpasswd")
	private WebElement password;

	@FindBy(id = "newpasswd1")
	private WebElement retypepassword;

	@FindBy(xpath = "//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")
	private WebElement alteremail;

	@FindBy(css = "input[type=\"checkbox\"]")
	private WebElement altrid;

	@FindBy(xpath = "//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select")
	private WebElement securityQuestionDropdown;
	// answer
	@FindBy(xpath = "//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")
	private WebElement enteranswer;
	// Mother' M name
	@FindBy(xpath = "//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")
	private WebElement mothermname;

//	@FindBy(xpath = "//*[@id='country_id'] | //*[@id='country_id']//li")
//	private List<WebElement> countryDropdownOptions;

	// Mobile number
	@FindBy(xpath = "//*[@id=\"mobno\"]")
	private WebElement mobilenumber;

	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")
	private WebElement selectday;

	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")
	private WebElement selectmonth;
	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")
	private WebElement selectyear;

	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]")
	private WebElement maleorfemale;

	@FindBy(xpath = "//*[@id=\"country\"]")
	private WebElement country;
	@FindBy(xpath = "//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")
	private WebElement city;

	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[32]/td[3]/input")
	private WebElement captcha;

	@FindBy(className = "submitbtn")
	private WebElement CreateAccount;

	public AS04Registrationformutility(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fullname(String fn) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fname));
		fname.sendKeys(fn);
	}

	public void remailid(String emid) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(emailid));
		emailid.sendKeys(emid);
	}

	public void vailibilitybtn() {
		checkavbutton.click();
	}

	public boolean checkAvailablity() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(avmsg));
			return avmsg.isDisplayed();

		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public void selectedemail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElements(suggestionsradiobuttons));

		if (!suggestions.isEmpty()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", suggestions.get(5)); // Click

			System.out.println("Selected: " + suggestions.get(5).getAttribute("value"));
		} else {
			throw new NoSuchElementException("No suggestions available");
		}
	}

	public void newpassword(String psw)

	{
		System.out.println("Waiting for password field to be visible...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(password));

		System.out.println("Password field is visible. Entering password.");
		password.sendKeys(psw);

	}

	public void repassword(String rpsw)

	{

		System.out.println("Waiting for the retype password field to be visible...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(retypepassword)); // Wait for visibility
		System.out.println("Retype password field is visible. Entering password.");
		retypepassword.sendKeys(rpsw); // Enter the retype password
	}

	public void altrid()

	{
		altrid.click();
	}

	public String selectsecurityqn() {

		// Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(securityQuestionDropdown));

		// Select
		Select select = new Select(securityQuestionDropdown);

		// Options for my reference
		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			System.out.println("Available option: " + option.getText());
		} // Reference

		// Return selected
		select.selectByIndex(2);
		String selectedOption = select.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		return selectedOption;

	}

	public void enteranswer(String ans) {

		enteranswer.sendKeys(ans);

	}

	public void mothermname(String mname) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", mothermname, mname); // Set the value using JavaScript

	}

	    public void selectCountrycode(String countryName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='country_id']")));
	    
	    // Click on the dropdown to open the options
	    countryDropdown.click();
	
	    List<WebElement> countryOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='country_id']//li")));
	   
	    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfAllElements(countryOptions));

	    // countryOptions.get(0).click();
	    
	    for (WebElement optioncode : countryOptions) {
	        if (optioncode.getText().equalsIgnoreCase(countryName)) {
	            optioncode.click();
	            break;
	        }
	    }
	}


	// Mobile number

	public void mobilenumber(String mb)
	{

		mobilenumber.sendKeys(mb);

	}

	// Day
	public String Selectedday()

	{

		Select select = new Select(selectday);

		List<WebElement> option = select.getOptions();

		for (WebElement options : option)

		{
			System.out.println("All list" + options.getText());

		}

		select.selectByValue("10");
		String selectedOption = select.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		return selectedOption;

	}
//Month

	public String SelectedMonth()

	{

		Select select = new Select(selectmonth);

		List<WebElement> option = select.getOptions();

		for (WebElement options : option)

		{
			System.out.println("All list" + options.getText());

		}

		select.selectByIndex(4);
		String selectedOption = select.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		return selectedOption;

	}

	// Year
	public String SelectedYear()

	{

		Select select = new Select(selectyear);

		List<WebElement> option = select.getOptions();

		for (WebElement options : option)

		{
			System.out.println("All list" + options.getText());

		}

		select.selectByValue("1997");
		String selectedOption = select.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		return selectedOption;

	}
	// Male/Female

	public void Maleorfemale() {
		maleorfemale.click(); // or if(maleorfemale.isSeleted())
	}

	// Country
	public String SelectedCountry()

	{

		Select select = new Select(country);

		List<WebElement> option = select.getOptions();

		for (WebElement options : option)

		{
			System.out.println("All list" + options.getText());

		}

		select.selectByIndex(0);
		String selectedOption = select.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		return selectedOption;

	}

	// City
	public String SelectedCity()

	{

		Select select = new Select(city);

		List<WebElement> option = select.getOptions();

		for (WebElement options : option)

		{
			System.out.println("All list" + options.getText());

		}

		select.selectByIndex(9);
		String selectedOption = select.getFirstSelectedOption().getText();
		System.out.println("Selected option: " + selectedOption);
		return selectedOption;

	}

	// Captcha

	public void Captcha() {

		captcha.sendKeys("");

	}

	// Create Account

	public void CreatedAccount() {

		CreateAccount.click();

	}

}
