package com.crm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.BaseClass;

public class TestUtil extends BaseClass{

	public static long pagelod=20;
	public static long implicit=10;
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] readExcelData(String sheetName) throws IOException 
	{
		FileInputStream finstream=null;
		try
		{
		 finstream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		workbook=new XSSFWorkbook(finstream);
		sheet = workbook.getSheet(sheetName);
		System.out.println("data in a cell: "+sheet.getRow(0).getCell(1));
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	
	}
	
	
	public static void takeScreenshots() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+System.currentTimeMillis()+".png");
		org.apache.commons.io.FileUtils.copyFile(scrFile, targetFile);
}
}
