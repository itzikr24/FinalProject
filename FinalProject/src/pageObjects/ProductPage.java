package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	@FindBy(css = ".btn_small.btn_inventory")
	private WebElement addToCartBth;
	@FindBy(css = ".btn_large.inventory_details_back_button")
	private WebElement goBackToMainBth;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void clickAddToCart() {
		click(addToCartBth);

	}

	public void goBackToMain() {
		click(goBackToMainBth);
	}
}
