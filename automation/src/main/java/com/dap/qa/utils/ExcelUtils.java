package com.dap.qa.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

	@DataProvider (name = "CaseData")
    public static Object[][] getexceldata() throws Exception 
    {
			String path = ConfigReader.get("excelpath");
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("CaseData");

            int rowCount = sheet.getPhysicalNumberOfRows();
            
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            

            Object[][] data = new Object[rowCount - 1][colCount];
            DataFormatter formatter = new DataFormatter();
            // Loop through rows and columns
            for (int i = 1; i < rowCount; i++) 
            { // Start from 1 to skip header
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) 
                {
                    if (row.getCell(j) != null) 
                    {
                    	
                        data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                        
                    } else 
                    {
                        data[i - 1][j] = "";
                    }
                }
            }

            workbook.close();
            fis.close();

            return data;
        }
	public static void updateTestStatus(String testCaseName, String status) {

	    try {
	        String path = ConfigReader.get("excelpath");
	        FileInputStream fis = new FileInputStream(path);
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet("CaseData");

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int statusColIndex = 8; // Status column index

	        for (int i = 1; i < rowCount; i++) {

	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            Cell tcCell = row.getCell(0);
	            if (tcCell == null) continue;

	            String currentTestCase = tcCell.toString().trim();

	            if (currentTestCase.equalsIgnoreCase(testCaseName)) {

	                Cell statusCell = row.getCell(statusColIndex);

	                if (statusCell == null) {
	                    statusCell = row.createCell(statusColIndex);
	                }

	                statusCell.setCellValue(status); // Pass / Fail

	                break;
	            }
	        }

	        fis.close();

	        FileOutputStream fos = new FileOutputStream(path);
	        workbook.write(fos);
	        workbook.close();
	        fos.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}
