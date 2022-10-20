package TestNGBasics;

import org.testng.annotations.Test;

public class TestNGEnabledSkipTest {
    @Test (enabled = false)
	public void b_method() {
		System.out.println("This is B method");
	}
		
	@Test
	public void a_method() {
		System.out.println("This is A method");
	}
		
	@Test (enabled = false)
	public void d_method() {
		System.out.println("This is D Method");
	}
		
	@Test
	public void c_method() {
		System.out.println("This is C Method");
	}
}
