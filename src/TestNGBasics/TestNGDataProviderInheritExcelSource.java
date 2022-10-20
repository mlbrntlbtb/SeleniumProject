package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGDataProviderInheritExcelSource 
{
	@Test(dataProvider="loginCredentialsExcel", dataProviderClass=TestNGDataProviderExcelSource.class)
	 public void TestMultiParam(String userName, String passWord) 
	 {
		 System.out.println("Value from data provider. Username: [" + userName + "] Password: [" + passWord + "]");
	 }
}
