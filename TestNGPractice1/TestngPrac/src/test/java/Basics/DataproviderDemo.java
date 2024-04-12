package Basics;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderDemo {
	
	WebDriver driver;
	// if we want to execute same script with multiple data then we will use data provider
	@BeforeMethod
	//@Test(priority=1)
	public void invokeDriver() {
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=2)
	public void positiveLoginTest() throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		
//		driver= new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//System.out.println("Username : "+ username +". Password : "+password);
		
		WebElement user= driver.findElement(By.xpath("//input[@name='username']"));
		
		user.sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.xpath("//*[@placeholder='Password']"));
		
		pass.sendKeys("admin123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
		
		loginBtn.click();
		
		Thread.sleep(3000);
		
		//driver.close();
	
	}
	
	@Test(dataProvider="dataSet", priority=3)
	public void negativeLoginTest(String username, String password) throws InterruptedException {
		
//		WebDriverManager.chromedriver().setup();
//		
//		driver= new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
		System.out.println("Username : "+ username +". Password : "+password);
		
		WebElement user= driver.findElement(By.xpath("//input[@name='username']"));
		
		user.sendKeys(username);
		
		WebElement pass = driver.findElement(By.xpath("//*[@placeholder='Password']"));
		
		pass.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
		
		loginBtn.click();
		
		Thread.sleep(3000);
		
		//driver.close();
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider()
	public Object[][] dataSet() {
		
		// first bracket is pointing to the number of sets of data, 2nd one is pointing towards number of parameters
		Object[][] data = new Object[4][2];
		
		data[0][0]= " ";
		data[0][1]= "admin123";
		
		data[1][0]= "sljfdk";
		data[1][1]= "admin123";
		
		data[2][0]= "Admin";
		data[2][1]= "sdkjfls";
		
		data[3][0]= "afaffag";
		data[3][1]= "sfgksfdg";
		
		return data;
	}

}