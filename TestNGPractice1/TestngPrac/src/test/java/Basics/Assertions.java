package Basics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

	@Parameters("url")
	@Test
	public void TrueAssertion(String para1) {

		String s1 = "Shiv";
		String s2 = "Shiv";

		AssertJUnit.assertTrue(s1.equals(s2));
		System.out.println(para1);
	}

	@Test
	public void falseAssertion() {

		String s1 = "Shiv";
		String s2 = "sfgdfgh";

		AssertJUnit.assertFalse(s1.equals(s2));
	}
	
	@Test
	public void equalsAssertion() {
//use hard assert where priority is high and should not pass exucution if there is error
		
		String s1 = "Shiv";
		String s2 = "Shiv";

		//hard assert class method are static so no need to create obj of that class
		AssertJUnit.assertEquals(s1,s2);
		//if assertion fails it will not execute any line after hard assert
		
	}
	
	@Test
	public void softAssertion() {

		//To continue execution after failure use soft assert where priority is low like spelling not imp text
		String s1 = "Shiv";
		String s2 = "Shiv";

		SoftAssert sf = new SoftAssert();
		
		AssertJUnit.assertEquals(s1, s2);
		System.out.println("Soft Assert");
		
	sf.assertAll();//to get what test fails 
	}
}