package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTest3 extends BaseTest {

	LoginPage lp;
	MainPage mp;

	@Test(description = "Login to the system with a correct username and incorrect password")
	public void tc_01FailsLogin1() {
		lp = new LoginPage(driver);
		lp.login("standard_user", "Password ");
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, "Epic sadface: Username and password do not match any user in this service");

	}

	@Test(description = "Login to the system with a correct password and incorrect username")
	public void tc_02FailsLogin2() {
		lp.login("usernames", "secret_sauce ");
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, "Epic sadface: Username and password do not match any user in this service");

	}

	@Test(description = "Login to the system with an incorrect password and username")
	public void tc_03FailsLogin3() {
		lp.login("usernames", "Password  ");
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test(description = "Login to the system")
	public void tc_04login() {
		lp.login("standard_user", "secret_sauce");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.saucedemo.com/inventory.html");

	}

	@Test(description = "Click on the menu and exit the system")
	public void tc_05logout() {
		mp = new MainPage(driver);
		mp.menu("Logout");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/");

	}
}
