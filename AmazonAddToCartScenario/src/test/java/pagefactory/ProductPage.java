package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(id = "add-to-cart-button")
	WebElement btn_AddToCart;
	
	@FindBy(id = "attachSiNoCoverage-announce")
	WebElement btn_noThanks;
	
	@FindBy(className = "a-button-input")
	WebElement btn_cart;
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButton() throws InterruptedException {
		btn_AddToCart.click();
		Thread.sleep(5000);
		btn_noThanks.click();
		Thread.sleep(5000);
	}

	public void clickOnCart() {
		btn_cart.click();
	}
}
