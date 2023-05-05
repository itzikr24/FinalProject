package pageObjects;

import org.openqa.selenium.WebDriver;

public class LinkedinPage extends BasePage {

	public LinkedinPage(WebDriver driver) {
		super(driver);
	}

	public boolean isItLinkedinPage() {
		if (getCurrentUrl().equalsIgnoreCase("https://www.linkedin.com/company/sauce-labs/?original_referer=")) {
			return true;

		} else
			return false;
	}
}
