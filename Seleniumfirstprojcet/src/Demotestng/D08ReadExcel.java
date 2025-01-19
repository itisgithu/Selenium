package Demotestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D08ReadExcel {
	 
	String fpath="C:\\Users\\nagar\\git\\repository\\Seleniumfirstprojcet\\src\\ExcelTestNg\\Read.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test(enabled = false)
	public void readData() {
		row = sheet.getRow(0);
		cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		
		row = sheet.getRow(0);
		cell = row.getCell(1);
		System.out.println(cell.getStringCellValue());
		
		row = sheet.getRow(0);
		cell = row.getCell(2);
		System.out.println(cell.getStringCellValue());
	
		//Instead of (16 lines of code used below ) used for loop
	
	
	}
	
		
  @Test
  public void Readalldata() {
	  

	  //Loop 
	  //Number of rows getPhysicalNumberOfRows();
	  int rows=sheet.getPhysicalNumberOfRows();//All rows
	  // //Number of Cell getPhysicalNumberOfCells();
	  //sheet.getRow (The number of columns in Every row will be same number row in in first row )
	  int cells=sheet.getRow(0).getPhysicalNumberOfCells();//First row columns (generally we are not doing this)
	  
	  
	  for(int i =0; i<rows; i++) //Instead of i<6 used int
		 {
        	  
		  row=sheet.getRow(i);//Single row
		  
		  for(int j=0 ; j<cells; j++) //cells ////Instead of j<3(fixed) used int
		  {
	  
			  cell=row.getCell(j);//Single column
			  
			  System.out.print(cell.getStringCellValue()+"\t");
			  
	 
		  } 
		  
		  System.out.println();
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  @BeforeTest
  public void beforeTest() throws IOException 
  {
	  
file=new File(fpath);
fis=new FileInputStream(file);
wb=new XSSFWorkbook(fis);
sheet=wb.getSheet("ReadSheet");
	  
	  
	  }

  @AfterTest
  public void afterTest() throws IOException {
	  
	  wb.close();
	  fis.close();
	  
  }

}
