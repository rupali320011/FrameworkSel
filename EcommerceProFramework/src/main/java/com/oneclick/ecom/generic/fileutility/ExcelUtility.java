package com.oneclick.ecom.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility 
{
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
	    FileInputStream fis = new FileInputStream("./Testdata/testScriptData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet(sheetName);
	    
	    String data = "";
	    Row row = sheet.getRow(rowNum);
	    if (row != null && row.getCell(cellNum) != null) {
	        data = row.getCell(cellNum).toString().trim();
	    }
	    
	    wb.close();
	    return data;
	}

	
	public void getAllDataFromExcelFile(String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream("./testdata/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rcount = sh.getLastRowNum();
		for (int i = 0; i <= rcount; i++) 
		{
			Row row = sh.getRow(i);
			short ccount = row.getLastCellNum();
			for (int j = 0; j < ccount; j++) 
			{
				String data = row.getCell(j).toString();
				System.out.println(data+ "\t");
			}
		}

		
		wb.close();
	}
	
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testdata/datadrvn.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public void setDataintoExcel(String sheetName, int rowNum, int CelNum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testdata/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(CelNum);
		
		FileOutputStream fos = new FileOutputStream("./testdata/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}

}
