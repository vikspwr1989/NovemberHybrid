package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.testbase.TestBase;

public class TestUtils extends TestBase{

	public static int IMPLICIT_WAIT = 30;
	public static int EXPLICIT_WAIT = 60;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	public static String getScreenshot(String ssName)
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("src/test/resources/Screenshots/"+ssName+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	public static Object[][] getData(String sheetName)
	{
		try {
			workbook = new XSSFWorkbook("src/test/resources/data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object obj[][] = new Object[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				obj[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
	}
	
}
