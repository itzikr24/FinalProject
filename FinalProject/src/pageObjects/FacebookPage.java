package pageObjects;

import org.openqa.selenium.WebDriver;

public class FacebookPage extends BasePage {

	public FacebookPage(WebDriver driver) {
		super(driver);

	}

	public boolean isItFacebookPase() {
		if (getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/saucelabs")) {
			return true;

		} else
			return false;

	}

}
