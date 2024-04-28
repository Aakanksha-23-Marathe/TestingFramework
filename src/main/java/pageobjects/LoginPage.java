package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInputField;

	@FindBy(id = "input-password")
	WebElement pwdInputField;

	@FindBy(css = "#content > div > div:nth-child(2) > div > form > input")
	WebElement loginBtn;

	public WebElement emailInputField() {
		return emailInputField;
	}

	public WebElement pwdInputField() {
		return pwdInputField;
	}

	public WebElement loginBtn() {
		return loginBtn;
	}
}
