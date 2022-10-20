package TestNGBasics;

import org.testng.asserts.*;
import org.testng.annotations.Test;

public class TestNGAssert {
	
  @Test
  public void Test() 
  {
	  String value1 = "Value 1";
	  String value2 = "Value 2";
	  
	  //Hard asserts - default assert - stops execution if conditions is not satisfied
	  //Assert.assertEquals(value1, value2); //Default
	  //Assert.assertEquals(value1, value2, "Hard Assert(): "); //With message
	  
	  //Soft asserts also known as 'Verify' - does not stop execution
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertEquals(value1, value2, "Soft Assert(): ");
	  System.out.println("Soft assert 1 executed");
	  softAssert.assertEquals(value1, value2, "Soft Assert2(): ");
	  System.out.println("Soft assert 2 executed");
	  softAssert.assertEquals(value1, value2, "Soft Assert3(): ");
	  System.out.println("Soft assert 3 executed");
	  softAssert.assertEquals(value1, value2, "Soft Assert4(): ");
	  System.out.println("Soft assert 4 executed");
	  
	  softAssert.assertAll(); //Only include this if you want to check soft assert results
  }
}
