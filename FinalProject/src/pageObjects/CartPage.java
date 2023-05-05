package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CartPage extends BasePage {
	@FindBy(css="#continue-shopping")
	private WebElement shoppingBackBth ;
	@FindBy(css="#checkout")
	private WebElement checkoutBth ;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	public void shoppingBactToMain() {
		click(shoppingBackBth);
	}
	public void checkout() {
		click(checkoutBth);
	}
	
}
