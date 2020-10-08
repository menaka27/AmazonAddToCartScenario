package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;
import pagefactory.CartPage;
import pagefactory.EnterPasswordPage;
import pagefactory.EnterUserNamePage;
import pagefactory.HomePage;
import pagefactory.LandingPage;
import pagefactory.ProductPage;
import pagefactory.SearchResultsPage;

public class AddItemToCart {
		
		WebDriver driver = null;
		LandingPage landing;
		EnterUserNamePage enterusername;
		EnterPasswordPage enterpassword;
		HomePage homepage;
		SearchResultsPage searchresultspage;
		ProductPage productpage;
		CartPage cartpage;
	
		@Given("browser is open")
		public void browser_is_open() {
		    System.out.println("Inside - browser_is_open");
		    String projectPath = System.getProperty("user.dir");
		    
		    System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/Drivers/geckodriver.exe");
		    driver = new FirefoxDriver();
		    
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		    
		    driver.manage().window().maximize();
		    
		}

		@And("navigate to amazon.com")
		public void navigate_to_amazon_com() {
			System.out.println("Inside - navigate_to_amazon_com");
			driver.navigate().to("https://www.amazon.com/");
		}

		@And("clicks on Hello Sign In")
		public void clicks_on_Hello_Sign_In() {
			System.out.println("Inside - clicks_on_Hello_Sign_In");
			landing = new LandingPage(driver);
			landing.clickHelloSignIn();
		}

		@And("verify enter username textbox is visible")
		public void verify_enter_username_textbox_is_visible() {
			System.out.println("Inside - verify_enter_username_textbox_is_visible");
			enterusername = new EnterUserNamePage(driver);
			enterusername.checkEmailTextBoxIsDisplayed();
		}
		
		@And("^user enters (.*)$")
		public void user_enters_(String username) throws InterruptedException {
			System.out.println("Inside - user_enters_username");
			enterusername.enterUserName(username);
			Thread.sleep(2000);
		}

		@And("user clicks Continue")
		public void user_clicks_Continue() throws InterruptedException {
			System.out.println("Inside - user_clicks_Continue");
			enterusername.clickOnContinue();
			Thread.sleep(2000);
		}
		
		@And("verify enter password textbox is visible")
		public void verify_enter_password_textbox_is_visible() {
			System.out.println("Inside - verify_enter_username_textbox_is_visible");
			enterpassword = new EnterPasswordPage(driver);
			enterpassword.checkPasswordTextBoxIsDisplayed();
		}
		
		@And("^user enter (.*)$")
		public void user_enter_(String password) throws InterruptedException {
			System.out.println("Inside - user_enter_password");
			enterpassword.enterPassword(password);
			Thread.sleep(2000);
		}

		@When("clicks on Sign-In button")
		public void clicks_on_Sign_In_button() throws InterruptedException {
			System.out.println("Inside - clicks_on_Sign_In_button");
			enterpassword.clickSignInBtn();
			Thread.sleep(5000);
		}

		@And("^user is navigated to the home page and verify (.*)$")
		public void user_is_navigated_to_the_home_page_and_verify_(String loggedinuser) {
			System.out.println("Inside - user_is_navigated_to_the_home_page");
			homepage = new HomePage(driver);
			homepage.checkLoggedInUserName(loggedinuser);
		}
		
		@And("^enter the product name in search box (.*)$")
		public void enter_the_product_name_in_search_box_(String searchitem) throws InterruptedException {
			System.out.println("Inside - enter_the_product_name_in_search_box_");
			homepage.enterSearchText(searchitem);
		    Thread.sleep(2000);
		}
		
		@And("clicks on search icon")
		public void clicks_on_search_icon() throws InterruptedException {
			System.out.println("Inside - clicks_on_search_icon");
			homepage.clickOnSearchIcon();
			Thread.sleep(3000);
		}
		
		@And("clicks on items linktext")
		public void clicks_on_items_linktext() throws InterruptedException {
			searchresultspage = new SearchResultsPage(driver);
			searchresultspage.clickOnItem();
			Thread.sleep(5000);
		}
		
		@And("clicks on addToCart button")
		public void clicks_on_addToCart_button() throws InterruptedException {
			System.out.println("Inside - clicks_on_addToCart_button");
			productpage = new ProductPage(driver);
			productpage.clickOnAddToCartButton();
			Thread.sleep(5000);
		}
		
		@And("clicks on cart button")
		public void clicks_on_cart_button() throws InterruptedException {
			productpage.clickOnCart();
			Thread.sleep(5000);
		}
		
		@And("^verify the item in cart page (.*)$")
		public void verify_the_item_in_cart_page(String product) throws InterruptedException {
			System.out.println("Inside = verify_the_item_in_cart_page");
			cartpage = new CartPage(driver);
			cartpage.verifyTheItem(product);
			Thread.sleep(5000);
		}
		
		@And("mousehover on loggedin username")
		public void mousehover_on_loggedin_username() throws InterruptedException {
			System.out.println("Inside - mousehover_on_loggedin_username");
			cartpage.mouseHoverOnLoggedinUsername();
			Thread.sleep(3000);
		}
		
		@And("clicks on Sign Out button")
		public void clicks_on_Sign_Out_button() throws InterruptedException {
			System.out.println("Inside - clicks_on_Sign_Out_button");
			cartpage.clickOnSignOutButton();
			Thread.sleep(2000);
		}
		
		@And("user should navigate to enter username page")
		public void user_should_navigate_to_enter_username_page() throws InterruptedException {
			System.out.println("Inside - user_should_navigate_to_enter_username_page");
			enterusername.checkEmailTextBoxIsDisplayed();
			Thread.sleep(2000);
		}
		
		@Then("close the browser")
		public void close_the_browser() {
			System.out.println("Inside - close_the_browser");
			driver.close();
		}
}