package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGParallelDataProvider 
{
  @Test(dataProvider="loginCredentialsExcelParallel", dataProviderClass= TestNGDataProviderExcelSource.class)
  public void PrintName(String userName, String passWord) 
  {
	  System.out.println("Thread ID: [" + Thread.currentThread().getId() + "]");
	  System.out.println("Value from data provider. Username: [" + userName + "] Password: [" + passWord + "]");
  }
}
