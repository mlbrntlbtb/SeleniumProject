package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGBaseGrouping2 
{
	@Test (groups= {"TestNGGroup"})
	 public void Test4() {
	   System.out.println("This is the A Normal Test Case 4"); 
	 }

	@Test
	 public void Test5() {
	   System.out.println("This is the A Normal Test Case 5"); 
	 }
	 
	@Test (groups= {"TestNGGroup"})
	 public void Test6() {
	   System.out.println("This is the A Normal Test Case 6"); 
	 }
}
