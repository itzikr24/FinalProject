package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

	@FindBy(css = "#cancel")
	private WebElement cancelBth;

	public OverviewPage(WebDriver driver) {
		super(driver);
	}

	public void cancelBth() {
		click(cancelBth);
	}

}
