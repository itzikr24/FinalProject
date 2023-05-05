package pageObjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	WebDriver driver;
	static String mainWindo;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void fillText(WebElement el, String text) {
		sleep(200);
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		sleep(700);
		highlightElement(el, "yellow");
		el.click();
	}

	public String getText(WebElement el) {
		highlightElement(el, "yellow");
		return el.getText();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void moveToNewWindow() {
		mainWindo = driver.getWindowHandle();
		Set<String> window = driver.getWindowHandles();
		for (String win : window) {
			driver.switchTo().window(win);
		}
	}

	public void moveBackToMainWindow() {
		sleep(2500);
		driver.close();
		driver.switchTo().window(mainWindo);
	}

	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectByValue(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	protected void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:cyan; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

}
