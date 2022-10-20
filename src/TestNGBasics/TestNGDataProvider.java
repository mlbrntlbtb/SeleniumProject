package TestNGBasics;

import org.testng.annotations.*;

public class TestNGDataProvider 
{
	//Data providers pass the different parameters on a single test in a single execution (repeats test depending number of parameters)
  @DataProvider(name="data-provider")
  public Object[][] DataProviderMethod()
  {
	  return new Object[][] {{"First Value"}, {"Second Value"}};
  }
	
  @Test(dataProvider = "data-provider")
  public void Test(String val) 
  {
	  System.out.println("Value from data provider: [" + val + "]");
  }
}
