package TestNGBasics;

import org.testng.annotations.*;

public class TestNGDataProviderInherit 
{
	 @Test(dataProvider = "data-provider", dataProviderClass = TestNGDataProviderSource.class, priority=1)
	  public void Test(String val) 
	  {
		  System.out.println("Value from data provider: [" + val + "]");
	  }
	 
	 @Test(dataProvider = "data-provider-multi", dataProviderClass = TestNGDataProviderSource.class, priority=2)
	 public void TestMultiParam(String firstName, String lastName) 
	 {
		 System.out.println("Value from data provider. First Name: [" + firstName + "] Last Name: [" + lastName + "]");
	 }
	 
	 @Test(dataProvider = "data-provider-use-method-param", dataProviderClass = TestNGDataProviderSource.class, priority=3)
	 public void TestPrintFirstName(String firstName) 
	 {
		 System.out.println("Value from data provider. First Name Only: [" + firstName + "]");
	 }
	 
	 @Test(dataProvider = "data-provider-use-method-param", dataProviderClass = TestNGDataProviderSource.class, priority=4)
	 public void TestPrintLastName(String lastName) 
	 {
		 System.out.println("Value from data provider. Last Name Only: [" + lastName + "]");
	 }
}
