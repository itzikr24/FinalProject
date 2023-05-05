package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutPage extends BasePage {
	@FindBy(css = "#first-name")
	private WebElement nameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement codeField;
	@FindBy(css = "#continue")
	private WebElement continueBth;
	@FindBy(css = "#finish")
	private WebElement finishBth;

	public checkoutPage(WebDriver driver) {
		super(driver);
	}

	public void fiilDetails(String name, String lastName, String code) {
		fillText(nameField, name);
		fillText(lastNameField, lastName);
		fillText(codeField, code);
		click(continueBth);
	}

	public void finish() {
		click(finishBth);
	}
}
