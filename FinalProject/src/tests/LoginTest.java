package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.checkoutPage;
import pageObjects.ProductPage;

public class LoginTest extends BaseTest {
	LoginPage lp;
	MainPage mp;
	ProductPage pp;
	CartPage cp;
	checkoutPage np;

	@Test(description = "Login to the system with an incorrect code and password")
	public void tc_01loginFile() {
		lp = new LoginPage(driver);
		lp.login("fvfv", "vdv");
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test(description = "Login to the system")
	public void tc_02login() {
		lp.login("standard_user", "secret_sauce");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.saucedemo.com/inventory.html");
	}

	@Test(description = "Choose a product and add it to cart")
	public void tc_03clickOnProduct() {
		mp = new MainPage(driver);
		mp.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		pp = new ProductPage(driver);
		pp.clickAddToCart();
		pp.goBackToMain();
	}

	@Test(description = "Open the product page and add to cart")
	public void tc_04opanCart() {
		mp.clickShopping();
		cp = new CartPage(driver);
		cp.shoppingBactToMain();

	}

	@Test(description = "Sorting the page from expensive to cheap and adding a product to cart")
	public void tc_05sortList() {
		mp.sort("hilo");
		mp.addToCartOnMain("Sauce Labs Onesie");
		mp.clickShopping();
		cp.shoppingBactToMain();
	}

	@Test(description = "Adding a product and arrangement from z to a ")
	public void chooseProductAndSort() {
		mp.addToCartOnMain("Test.allTheThings() T-Shirt (Red)");
		mp.sort("za");
		mp.clickShopping();

	}

	@Test(description = "Filling in details and exiting the system")
	public void tc_07LogOff() {
		cp.checkout();
		np = new checkoutPage(driver);
		np.fiilDetails("Itzik", "Rata", "123456");
		np.finish();
		mp.menu("logout");
	}

}
