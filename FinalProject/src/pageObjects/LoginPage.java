package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css = "#user-name")
	private WebElement Name;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBth;
	@FindBy(css = "[data-test='error']")
	private WebElement errorMsge;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String userName, String password) {
		fillText(Name, userName);
		fillText(passwordField, password);
		click(loginBth);
	}

	public String getErrorMsg() {
		return getText(errorMsge);
	}

}
