package TestNGBasics;

import org.testng.annotations.*;

public class TestNGPriority {
	//priority - lowest to highest
	//No "priority" is first to run in alphabetical order
    @Test (priority = 1)
	public void b_method() {
		System.out.println("This is B method");
	}
		
	@Test (priority = 1)
	public void a_method() {
		System.out.println("This is A method");
	}
		
	@Test
	public void d_method() {
		System.out.println("This is D Method");
	}
		
	@Test
	public void c_method() {
		System.out.println("This is C Method");
	}
}
