package Demotestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataDrivenReadWriteWeb {

	String fpath = "C:\\Users\\nagar\\git\\repository\\Seleniumfirstprojcet\\src\\ExcelTestNg\\Read.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;//2nd 
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int i;
	int j;
	WebDriver driver;
	
	int index=1;

//	@Test
//	
//	public void myreference()
//	{
//		
//	row=sheet.getRow(0);
//	cell=row.getCell(0);
//	System.out.println(cell.getStringCellValue());
//	
//	
//	
//	}

	@Test(dataProvider = "GetAlldata")
	// public void LoginToHRM(String un,String pw, String rs) //Before
	public void LoginToHRM(String un, String pw) throws IOException// After
	{
		// Take from data provider & Pass to console
		// System.out.println(un);//Before
		// System.out.println(pw);//Before
		// System.out.println(rs);//Before

		// Pass to //Take from data provider & Pass to web //2nd operation
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		File scree2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scree2, new File("ScreenShotTestNg\\MyScreen2"+index+".jpeg"));
	
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void Logout() throws InterruptedException, IOException { // Logout
		Thread.sleep(5000);
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("ScreenShotTestNg\\MyFirstsc.jpeg"));
		
		
		row=sheet.getRow(index); //2nd //For printing all data (Here i am writing in the Index 1(row) second (2 cell)0,1,2
		cell=row.getCell(2); //2nd

		if (driver.getCurrentUrl().contains("dashboard")) {   //For 1st 
			driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Test case pass");
			cell.setCellValue("Pass") ;//2nd (Print on Excel in  Result Heading)
		
		} else
		
		{
			
			System.out.println("Invalid data");//1st
			cell.setCellValue("Fail");//2nd
			
		}

		index++;
	}

	@DataProvider
	public Object[][] GetAlldata() {
		int rows = sheet.getPhysicalNumberOfRows();// To add more row 2nd
		// int cells=sheet.getRow(0).getPhysicalNumberOfCells();//To add more cell 2nd

		// String[][] logindata=new String[8][3]; //Before 1st
		// String[][] logindata=new String[rows][2]; //After 8row (Not run removed (3rd
		// clm) (2nd)

		String[][] logindata = new String[rows - 1][2];// Heading should be removed from 1row -2 (7 row) (3rd)

		// for(i =0; i<8 ; i++)//if 9 that row is null (1st)
		// for(i =0; i<rows; i++)//8Rows (2nd)
		for (i = 0; i < rows - 1; i++) // 7Rows ,2clm (3rd)
		{

			// row=sheet.getRow(i); //Before
			row = sheet.getRow(i + 1);

			// for(int j=0; j<3 ; j++) //1st

			// for(int j=0; j<cells ; j++) //2nd for more cells

			for (int j = 0; j < 2; j++) // 3rd only need two cell thats why not read all cell
			{
				cell = row.getCell(j);
				// Store it in Two dimensional array
				logindata[i][j] = cell.getStringCellValue();// Value of 0th Row 0th Column will copied in t dimensional
															// array
			} // Till give the Out put

		}

		return logindata;
	}

	@BeforeTest
	public void beforeTest() throws IOException {

		file = new File(fpath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("ReadSheet");// if i don know the name getSheet(0);(Multiple sheet then)
		fos=new FileOutputStream(fpath);//After configuration of sheet always (When we are performing both operation)
		

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterTest
	public void afterTest() throws IOException {
       wb.write(fos);
		wb.close();
		fis.close();
	}

}
