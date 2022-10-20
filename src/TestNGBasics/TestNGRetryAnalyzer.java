package TestNGBasics;

import org.testng.*;

public class TestNGRetryAnalyzer implements IRetryAnalyzer
{
	int counter = 0;
	int retryLimit = 4; //Set retry limits here
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(counter < retryLimit) 
		{
			counter++;
			return true;
		}
		return false;
	}
}
