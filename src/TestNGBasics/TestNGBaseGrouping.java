package TestNGBasics;

import org.testng.annotations.*;

public class TestNGBaseGrouping 
{
	@Test (groups= {"TestNGGroup"})
	 public void Test1() {
	   System.out.println("This is the A Normal Test Case 1"); 
	 }

	@Test
	 public void Test2() {
	   System.out.println("This is the A Normal Test Case 2"); 
	 }
	 
	@Test (groups= {"TestNGGroup"})
	 public void Test3() {
	   System.out.println("This is the A Normal Test Case 3"); 
	 }
}
