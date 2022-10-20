package automationFramework.SeleniumBasics;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SeleniumJUnitTestRunner {

	public static void main(String[] args) 
	{
		//Run JUnit test
		Result result = JUnitCore.runClasses(SeleniumJUnitTestSuite.class);
		//Result result = JUnitCore.runClasses(<class>,<class>);
		
		//Display results
		System.out.println("Total number of tests passed: [" + result.getRunCount() + "]");
		System.out.println("Total number of tests failed: [" + result.getFailureCount() + "]");
		
		for(Failure failure: result.getFailures()) 
		{
			System.out.println(failure.getMessage());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
