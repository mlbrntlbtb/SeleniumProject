package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGDependentGroupTest 
{
  @Test (groups={"SignIn"})
  public void SignIn() 
  {
	  System.out.println("Sign in test.");
  }
  
  @Test (groups={"LogOut"})
  public void LogOut() 
  {
	  System.out.println("Logout test.");
  }
  
  @Test (groups={"OpenBrowser"})
  public void OpenBrowser() 
  {
	  System.out.println("Open browser test.");
  }
}
