package pageObjects;

import org.openqa.selenium.WebDriver;

public class TwiterPage extends BasePage {

	public TwiterPage(WebDriver driver) {
		super(driver);
	}

	public boolean isItTwiterPage() {
		if (getCurrentUrl().equalsIgnoreCase("https://twitter.com/saucelabs")) {
			return true;

		} else
			return false;

	}
}
