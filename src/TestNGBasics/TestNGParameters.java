package TestNGBasics;

import org.testng.annotations.*;
import org.testng.annotations.Optional;

public class TestNGParameters 
{
	//Parameters pass value of parameters just once per execution
  @Test
  @Parameters ({"firstName","lastName"})
  public void Test(@Optional("default") String firstName, @Optional("default")String lastName) 
  {
	  System.out.println("Hello: [" + firstName + "] + [" + lastName + "]");
  }
}
