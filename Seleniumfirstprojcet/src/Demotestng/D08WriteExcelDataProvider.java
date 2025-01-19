package Demotestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D08WriteExcelDataProvider {
	
	String fpath="C:\\Users\\nagar\\git\\repository\\Seleniumfirstprojcet\\src\\ExcelTestNg\\Write.xlsx";

	//String fpath2=System.getProperty("user.dir")+"\\ExcelTestNg\\Write.xlsx";   
	//This will give the path of folder
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=1;
	
  @Test(dataProvider = "Getlogindata")
  
  public void Createlogin(String Un, String Pw) 
  
  
  {

  row=sheet.createRow(index);
  cell=row.createCell(0);
  cell.setCellValue(Un);  // Username      //  (Username","Password",)   ("Not Run )
  
  cell=row.createCell(1);
  cell.setCellValue(Pw);//  Password
  
  cell=row.createCell(2);
  cell.setCellValue("Not run");//Not Run
  
  
  index++;
  
 }
  
 
  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] Getlogindata() 
  {
    
	 return new Object[][] 
   
    {	
     
    
      
      new Object[] { "admin","admin123"},
      new Object[] { "nagaraj","admin124"},
      new Object[] { "sonu","admin124"},
      new Object[] { "Ramaya","admin124"},
      new Object[] {"Raj","Naga123"},
     };
   
  }
  
  
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  
	file=new File (fpath);
	fos=new FileOutputStream(file);
	wb=new XSSFWorkbook();
	sheet=wb.createSheet("Mynewsheet");
	  
	 // Create header row //This is header row thats why here//
    XSSFRow headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("User Name");
    headerRow.createCell(1).setCellValue("Password");
    headerRow.createCell(2).setCellValue("Result");
  }

  @AfterTest
  public void afterTest() throws IOException {
	  
	  wb.write(fos);
	  wb.close();	
	  fos.close();
	  
  }

}
