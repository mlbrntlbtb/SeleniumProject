package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHandler 
{
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	public ExcelHandler(String filePath, String sheetName) throws IOException 
	{
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
	}
	
	public List<String> getColumnData(int columnNumber) 
	{
		List<String> columnDataList = new ArrayList<String>();
		for(Row row: sheet) 
		{
			if(row.getRowNum() != 0) 
			{
				columnDataList.add(row.getCell(columnNumber).getStringCellValue());
			}
		}
		return columnDataList;
	}
	
	public int getColNumberFromHeader(String headerName) 
	{
		Iterator<Cell> cellIterator = sheet.getRow(0).iterator();
		while(cellIterator.hasNext()) 
		{
			Cell cell = cellIterator.next();
			if(cell.toString().equals(headerName)) 
			{
				return cell.getColumnIndex();
			}
		}
		return -1;
	}
	
	public Object[][] getExcelData()
	{
		//Subtract '1' to row size to exclude count for column header
		//Start with '1' in for loop to start with first row and not column header row
		//Subtract '1' in object list row to avoid null rows
		
		Object[][] list = new Object[getRowSize()-1][getColumnSize()];
		for(int r=1; r < getRowSize(); r++) 
		{
			for(int c=0; c < getColumnSize(); c++) 
			{
				list[r-1][c] = sheet.getRow(r).getCell(c).getStringCellValue();
			}
		}
		return list;
	}
	
	public int getRowSize() 
	{
		return sheet.getPhysicalNumberOfRows(); //Actual number of rows
	}
	
	public int getColumnSize() 
	{
		return sheet.getRow(0).getPhysicalNumberOfCells(); //Getting number of cells from first row since this is declared with column headers
	}
	
	public int getRowSizeExcludeColumnHeader() 
	{
		return sheet.getLastRowNum(); //Using this instead starting with '0' since row 1 is not included (column names)
	}
}
