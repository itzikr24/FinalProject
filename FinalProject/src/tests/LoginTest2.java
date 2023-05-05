package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FacebookPage;

import pageObjects.LinkedinPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.TwiterPage;

public class LoginTest2 extends BaseTest {
	LoginPage lp;
	MainPage mp;

	@Test(description = "Login to the system")
	public void tc_01login() {
		lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.saucedemo.com/inventory.html");

	}

	@Test(description = "Clicking on the Facebook button and close")
	public void tc_02chackFacebook() {
		mp = new MainPage(driver);
		mp.clickFacebook();
		mp.moveToNewWindow();
		FacebookPage fp = new FacebookPage(driver);
		Assert.assertTrue(fp.isItFacebookPase());
		fp.moveBackToMainWindow();

	}

	@Test(description = "Clicking on the Twiter button and close")
	public void tc_03chackTwiter() {
		mp.clickTwiter();
		mp.moveToNewWindow();
		TwiterPage tp = new TwiterPage(driver);
		Assert.assertTrue(tp.isItTwiterPage());
		tp.moveBackToMainWindow();

	}

	@Test(description = "Clicking on the Linkedin button and close")
	public void tc_04chackLinkedin() {
		mp.clickLinkedin();
		mp.moveToNewWindow();
		LinkedinPage lip = new LinkedinPage(driver);
		Assert.assertTrue(lip.isItLinkedinPage());
		lip.moveBackToMainWindow();
	}

	@Test(description = "Click on the menu and exit the system")
	public void tc_05logout() {
		mp = new MainPage(driver);
		mp.menu("Logout");
	}
}
