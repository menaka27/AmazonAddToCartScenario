package pagefactory;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/div/span")
	WebElement usernametext;
	
	//@FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")
	//WebElement loggedinusername;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement txt_searchbox;
	
	@FindBy(id = "nav-search-submit-text")
	WebElement btn_searchicon;
	
	//@FindBy(id = "nav-item-signout")
	//WebElement btn_signout;
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkLoggedInUserName(String loggedinuser) {
		String usernamevalue = usernametext.getText();
		System.out.println("username value is " +usernamevalue);
		String loggedinusername = "Hello, "+loggedinuser;
		System.out.println("logged in username is " +loggedinusername);
		if (usernamevalue.equals(loggedinusername)) {
			System.out.println("Verified Loggedin Username");
		}
		else {
			System.out.println("logged in username not matched");
			System.out.println("Logged In Username is "+ usernamevalue);
		}
			
	}
	
	/*public void mouseHoverOnLoggedinUsername() throws InterruptedException {
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(loggedinusername).build().perform();
	}*/
	
	public void enterSearchText(String searchitem) throws InterruptedException {
		Thread.sleep(5000);
		txt_searchbox.sendKeys(searchitem);
		Thread.sleep(2000);
	}
	
	public void clickOnSearchIcon() {
		btn_searchicon.click();
	}

	/*public void clickOnSignOutButton() {
		btn_signout.click();
	}*/
}
