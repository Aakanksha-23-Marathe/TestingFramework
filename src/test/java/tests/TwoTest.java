package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {

	
	public WebDriver driver;
	@Test
	public void TestTwo() throws InterruptedException {
		System.out.println("Inside TestTwo of TwoTest Class");
		
		 driver = intializeDriver();
		
		driver.get("https://omayo.blogspot.com/");
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
