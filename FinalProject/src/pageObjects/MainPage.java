package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	@FindBy(css = "#item_3_img_link")
	private WebElement clickBth;
	@FindBy(css = "#shopping_cart_container")
	private WebElement shoppingCartBth;
	@FindBy(css = ".product_sort_container option")
	private WebElement sortBth;
	@FindBy(css = ".product_sort_container")
	private WebElement optionBth;
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(css = ".bm-item.menu-item")
	private WebElement MenuOption;
	@FindBy(css = ".social_facebook")
	private WebElement facebookBth;
	@FindBy(css = ".social_twitter")
	private WebElement twiterBth;
	@FindBy(css = ".social_linkedin")
	private WebElement linkedinBth;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void chooseProduct(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_container"));
		for (WebElement el : list) {
			if (getText(el).contains(name)) {
				click(clickBth);

			}
		}

	}

	public void clickShopping() {
		click(shoppingCartBth);
	}

	public void sort(String value) {
		click(sortBth);
		selectByValue(optionBth, value);
	}

	public void addToCartOnMain(String name) {
		List<WebElement> listArea = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement elArea : listArea) {
			WebElement elTitel = elArea.findElement(By.cssSelector(".inventory_item_name"));
			if (elTitel.getText().equalsIgnoreCase(name)) {
				WebElement elBth = elArea.findElement(By.cssSelector(".btn_small.btn_inventory"));
				click(elBth);
				break;
			}
		}
	}

	public void menu(String name) {
		click(menuBtn);
		List<WebElement> list = driver.findElements(By.cssSelector(".bm-item.menu-item"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
			}
		}

	}

	public void clickFacebook() {
		click(facebookBth);
	}

	public void clickTwiter() {
		click(twiterBth);
	}

	public void clickLinkedin() {
		click(linkedinBth);
	}

}
