package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ProductPage;
import pageObjects.checkoutPage;
import pageObjects.OverviewPage;

public class LoginTest4 extends BaseTest {
	LoginPage lp;
	MainPage mp;
	CartPage cp;
	ProductPage pp;
	checkoutPage chp;
	OverviewPage op;

	@Test(description = "Login to the system")
	public void tc_01login() {
		lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.saucedemo.com/inventory.html");
	}

	@Test(description = "Sorting from the cheapest to the most expensive and assigning a product to cart")
	public void tc_02sort() {
		mp = new MainPage(driver);
		mp.sort("lohi");
		mp.addToCartOnMain("Sauce Labs Bolt T-Shirt");
		mp.clickShopping();
		cp = new CartPage(driver);
		cp.shoppingBactToMain();

	}

	@Test(description = "selected a product and add to cart and entry and exit from cart")
	public void tc_03chooseProduct() {
		mp.chooseProduct("Sauce Labs Bike Light");
		pp = new ProductPage(driver);
		pp.clickAddToCart();
		pp.goBackToMain();
		mp.clickShopping();
		cp.shoppingBactToMain();

	}

	@Test(description = "entry to the checkout page and filling in details")
	public void tc_04fillingDetails() {
		mp.clickShopping();
		cp.checkout();
		chp = new checkoutPage(driver);
		chp.fiilDetails("dan", "gal", "987456321");
		chp.finish();
		op = new OverviewPage(driver);
		op.cancelBth();

	}

}
