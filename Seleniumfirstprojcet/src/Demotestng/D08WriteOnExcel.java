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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D08WriteOnExcel { // First step

	    String fpath = "C:\\Users\\nagar\\git\\repository\\Seleniumfirstprojcet\\src\\ExcelTestNg\\Write.xlsx";//Where we want to store
	    //If we have not mentioned by default it store in package
	    File file;
	    FileOutputStream fos;
	    XSSFWorkbook wb;
	    XSSFSheet sheet; 
	    XSSFRow row;
	    XSSFCell cell;

	    @Test
	    public void writeTest() {
	        row = sheet.createRow(0);
	        cell = row.createCell(0);
	        cell.setCellValue("Nagaraj Naik");
	   
	    
	        sheet.getRow(0).createCell(1).setCellValue("Ramya Naik");
	        sheet.getRow(0).createCell(2).setCellValue("Amma");
	    
	    
	    
	    }
	    
	    
	    
	    
	    

	    @BeforeMethod
	    public void beforeMethod() {}

	    @AfterMethod
	    public void afterMethod() {}

	   
	    

	    @BeforeTest
	    public void beforeTest() throws FileNotFoundException {
	        file = new File(fpath);// Without file path direct (MyFirstExcel.xlsx)
	      fos = new FileOutputStream(file);
	        wb = new XSSFWorkbook();//For writing dont pass anything
	        sheet = wb.createSheet("Mysecond");//If we not written any name it takes by default
	    }

	    @AfterTest
	    public void afterTest() throws IOException {
	      wb.write(fos); // Write the workbook to the file
	        fos.close();   // Close the FileOutputStream
	        wb.close();    // Close the Workbook
	    }
	}
