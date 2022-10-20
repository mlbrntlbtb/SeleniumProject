package TestNGBasics;

import org.testng.annotations.*;

@Listeners(TestNGListenersITestListener.class)
public class TestNGListenersITestListenerHandler 
{
  @Test
  public void Test() 
  {
	  System.out.println("This is a sample test case for ITestListener.");
  }
}
