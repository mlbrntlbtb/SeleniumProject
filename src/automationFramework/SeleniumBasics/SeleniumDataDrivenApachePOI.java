package automationFramework.SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SeleniumDataDrivenApachePOI 
{
	//HSSFWorkbook - .xls format [old format] excel files
	//XSSFWorkbook - .xls/.xlsx format [new format] excel files
	public static void main(String args[]) throws IOException 
	{
		//Create file with file path
		String filePath = "C:\\Users\\Melbourne\\Documents\\TestData.xlsx";
		File file = new File (filePath);
		FileInputStream inputStream = new FileInputStream(file); // Convert to FileInputStream to read file in sequence of bytes
		
		//Read excel file using XSSFWorkbook
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		//Read sheet using XSSFSheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//Read row using XSSFRow
		//XSSFRow row = sheet.getRow(1);
		//int firstRowNumber = sheet.getFirstRowNum();
		//int lastRowNumber = sheet.getLastRowNum();
		//int rowCount = 	lastRowNumber - firstRowNumber;
		
		//int firstCellNumber = sheet.getRow(1).getFirstCellNum();
		//int lastCellNumber = sheet.getRow(1).getLastCellNum();
		//int cellCount = lastCellNumber - firstCellNumber;
		
		for(Row row: sheet) 
		{
			if(row.getRowNum() != 0) 
			{
				//Read cell using XSSFCell
				XSSFCell userNameCell = (XSSFCell) row.getCell(0);
				XSSFCell passWordCell = (XSSFCell) row.getCell(1);
				
				//Get string value
				String userName = userNameCell.getStringCellValue();
				String passWord = passWordCell.getStringCellValue();
				
				System.out.println("Username: [" + userName + "] Password: [" + passWord + "]");
			}
		}
		
		//Close excel file
		workbook.close();
	}
}
