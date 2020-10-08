package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterPasswordPage {
	
	@FindBy(id = "ap_password")
	WebElement txt_password;
	
	@FindBy(id = "signInSubmit")
	WebElement btn_SignIn;
	
	WebDriver driver;
	
	public EnterPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkPasswordTextBoxIsDisplayed() {
		txt_password.isDisplayed();
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickSignInBtn() {
		btn_SignIn.click();
	}

}
