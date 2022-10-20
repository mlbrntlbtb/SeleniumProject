package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGDependentTest extends TestNGDependentTestInheritExtends
{
	//Test that is dependent on a method
	
//  @Test (dependsOnMethods= {"DependentTest"})
//  public void TestDependent() 
//  {
//	  System.out.println("This test is dependent on a method.");
//  }
//  
//  @Test
//  public void DependentTest() 
//  {
//	  System.out.println("Dependent method.");
//  }
	
	
  
	//Test that is dependent on a group
	
//  @Test(dependsOnGroups= {"dependentGroup"})
//  public void TestGroup() 
//  {
//	  System.out.println("This test is dependent on a group.");
//  }
//  
//  @Test(groups= {"dependentGroup"})
//  public void DependentGroup() 
//  {
//	  System.out.println("Dependent group.");
//  }
	
	
	
	//Single dependent tests
	
//	@Test
//	public void Test1() 
//	{
//		System.out.println("This is Test 1");
//	}
//	
//	@Test (dependsOnMethods= {"Test1"})
//  	public void Test2() 
//	{
//	  System.out.println("This test is dependent to Test 1");
//	}
//  
//	@Test (dependsOnMethods= {"Test2"})
//  	public void Test3() 
//	{
//	  System.out.println("This test is dependent to Test 2");
//	}
	
	
	
	//Multiple dependent tests
//	@Test
//	public void Test4() 
//	{
//		System.out.println("This is Test 4");
//	}
//	
//	@Test
//  	public void Test5() 
//	{
//		System.out.println("This is Test 5");
//	}
//  
//	@Test (dependsOnMethods= {"Test4","Test5"})
//  	public void Test6() 
//	{
//		System.out.println("This test is dependent to Test 4 and Test 5");
//	}
	
	
	
	//Inherited dependent tests
	@Test (dependsOnMethods= {"InheritedTest"})
  	public void Test7() 
	{
		System.out.println("This test is dependent to an inherited test from other class 'TestNGDependentTestInheritExtends'.");
	}
}
