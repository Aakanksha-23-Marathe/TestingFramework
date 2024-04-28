
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;

	@Test
	public void TestThree() throws InterruptedException {
		System.out.println("Inside TestThree of ThreeTest Class");
		System.out.println("Krish update");

		driver = intializeDriver();

		driver.get("https://mvnrepository.com/");

		Thread.sleep(3000);

		Assert.assertTrue(false);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
