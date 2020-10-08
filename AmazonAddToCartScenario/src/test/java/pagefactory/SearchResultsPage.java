package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	@FindBy(linkText = "New Apple Watch SE (GPS, 44mm) - Space Gray Aluminum Case with Black Sport Band")
	WebElement item;
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnItem() {
		item.click();
	}

}
