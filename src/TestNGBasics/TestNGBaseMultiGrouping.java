package TestNGBasics;

import org.testng.annotations.Test;

@Test (groups = {"TestNGDefaultGroup"}) // For default grouping
public class TestNGBaseMultiGrouping 
{
	@Test (groups= {"TestNGGroup1"})
	 public void Test1() {
	   System.out.println("This is the A Normal Test Case 1"); 
	 }

	@Test (groups= {"TestNGGroup1", "TestNGGroup2"}) //Multi groups
	 public void Test2() {
	   System.out.println("This is the A Normal Test Case 2"); 
	 }
	 
	@Test (groups= {"TestNGGroup2"})
	 public void Test3() {
	   System.out.println("This is the A Normal Test Case 3"); 
	 }
	
	@Test (groups= {"TestNGGroup2"})
	 public void Test4() {
	   System.out.println("This is the A Normal Test Case 4"); 
	 }
	
	@Test (groups= {"TestNGExcludeGroup"}) //Exclude this group
	 public void Test5() {
	   System.out.println("This is the A Normal Test Case 5"); 
	 }
	
	@Test (groups= {"TestNGIncludeRegEx"}) //Identify group name with Regular Expression
	 public void Test6() {
	   System.out.println("This is the A Normal Test Case 6"); 
	 }
	
}
