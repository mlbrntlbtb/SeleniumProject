package TestNGBasics;

import java.lang.reflect.Method;

import org.testng.annotations.*;

public class TestNGDataProviderSource 
{
	@DataProvider(name="data-provider") //Single parameter
	  public Object[][] DataProviderMethod()
	  {
		  return new Object[][] {{"First Value"}, {"Second Value"}};
	  }
	
	@DataProvider(name="data-provider-multi") //Multiple parameter
	  public Object[][] DataProviderMultiMethod()
	  {
		  return new Object[][] {{"John","Wick"}, {"Van","Helsing"}};
	  }
	
	@DataProvider(name="data-provider-use-method-param") //Using method as parameter
	public Object[][] DataProviderUsingMethodParamMethod(Method method)
	{
		switch(method.getName()) 
		{
			case "TestPrintFirstName":
				return new Object[][] {{"John"},{"Van"}};
			
			case "TestPrintLastName":
				return new Object[][] {{"Wick"},{"Helsing"}};
		}
		return null;
	}
}
