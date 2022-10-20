package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGDependentTestInheritExtends 
{
	@Test
	public void InheritedTest() 
	{
		System.out.println("This test is inherited from other class.");
	}
}
