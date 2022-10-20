package TestNGBasics;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.*;
import utilities.ExcelHandler;
import utilities.Constants;

public class TestNGDataProviderExcelSource 
{
  @DataProvider (name="loginCredentialsExcel")
  public Object [][] LoginCredentials() throws IOException
  {
	  ExcelHandler excel = new ExcelHandler(new File(Constants.testDataPath, Constants.fileName).getPath(), Constants.sheetName);
	  return excel.getExcelData();
  }
  
  @DataProvider (name="loginCredentialsExcelParallel", parallel=true)
  public Object [][] LoginCredentialsParallel() throws IOException
  {
	  ExcelHandler excel = new ExcelHandler(new File(Constants.testDataPath, Constants.fileName).getPath(), Constants.sheetName);
	  return excel.getExcelData();
  }
}
