package practiceTestt;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardassertTC {

	@Test
	public void createCatagoryTest() {
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("home","hoem");
		System.out.println("step-3");
	}
	@Test
	public void createCatagory() {
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertTrue(false); //expected true
		System.out.println("step-3");
		
	}
	@Test
	public void createSubCatagory() {
		SoftAssert sa=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		sa.assertEquals("home","homme");
		System.out.println("step-3");
		sa.assertAll();
	}
}
