package TestNGBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryAnalyzerTest {
  @Test (retryAnalyzer= TestNGRetryAnalyzer.class)
  public void Test() 
  {
	  System.out.println("This is a sample test case for RetryAnalyzer interface.");
	  Assert.assertEquals("Value1","Value2","Assert Equals(): ");
  }
  
  @Test (retryAnalyzer= TestNGRetryAnalyzer.class)
  public void Test2() 
  {
	  System.out.println("This is a sample test case 2 for RetryAnalyzer interface.");
	  Assert.assertEquals("Value1","Value1","Assert Equals(): ");
  }
}
