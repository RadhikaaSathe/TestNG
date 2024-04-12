package Basics;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Annotations {
	
	@Test(priority=1, groups= {"smoke", "reg"})
	public void Login() {
		
		System.out.println("I am login");
	}
	
	//default priority will be "0"
	@Test
	public void Homepage() {
		
		System.out.println("I am Homepage");
	}
	
	// We can also give "-VE" priority
	@Test(priority=3)
	public void Products() {
		
		System.out.println("I am Products");
		//we are failing this method 
		//Assert.assertFalse(true);
	}
	
	@Test(dependsOnMethods= "Products" )
	public void AddToCart() {
		
		System.out.println("I am AddToCart");
	}

}