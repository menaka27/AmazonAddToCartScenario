package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[5]/div/div[2]/div[4]/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span[1]")
	WebElement productname;
	
	//@FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")
	@FindBy(xpath = "/html/body/div[1]/div[1]/header/div/div[1]/div[3]/div/a[2]/div/span")
	WebElement loggedinusername;
	
	@FindBy(id = "nav-item-signout")
	WebElement btn_signout;
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTheItem(String product) {
		String AddedProduct = productname.getText();
		if(AddedProduct.equals(product)) {
			System.out.println("Product Verified");
		}
		else {
			System.out.println("Product not Verified");
			System.out.println("Product Name "+AddedProduct);
		}
	}

	public void mouseHoverOnLoggedinUsername() throws InterruptedException {
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(loggedinusername).build().perform();
	}
	
	public void clickOnSignOutButton() {
		btn_signout.click();
	}
}
