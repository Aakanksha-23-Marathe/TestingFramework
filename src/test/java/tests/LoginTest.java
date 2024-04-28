package tests;

import resources.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class LoginTest extends Base {

	WebDriver driver;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String pwd, String result) throws InterruptedException {


		LandingPage landingpage = new LandingPage(driver);

		landingpage.myAccoundDropdown().click();
		Thread.sleep(2000);
		landingpage.loginText().click();

		LoginPage loginpage = new LoginPage(driver);

		loginpage.emailInputField().sendKeys(email);
		loginpage.pwdInputField().sendKeys(pwd);
		loginpage.loginBtn().click();

		AccountPage accountpage = new AccountPage(driver);

		String actualResult = null;
		try {

			if (accountpage.editYourAccountLink().isDisplayed()) {
				actualResult = "Successfull";
			}

		} catch (Exception e) {
			actualResult = "Failure";
		}

		Assert.assertEquals(actualResult, result);
	}

	@BeforeMethod
	public void openApp() {

		driver = intializeDriver();

		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "aaku@gmail.com", "abc@123", "Failure" },
				{ "aakanksha@yopmail.com", "Abc@123", "Successfull" } };

		return data;

	}

}
