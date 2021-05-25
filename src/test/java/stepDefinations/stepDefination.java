package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class stepDefination extends Base {

	WebDriver webDriver;
	LoginPage loginPage;

	@Given("Initilize the browser with chrome")
	public void initilize_the_browser_with_chrome() throws IOException {

		webDriver = initializerDriver();
	}

	@Given("Navigate to {string} Site")
	public void navigate_to_site(String string) {

		webDriver.get(string);
	}

	@Given("Click on Login likn in home page to land on Secure sing in page")
	public void click_on_login_likn_in_home_page_to_land_on_secure_sing_in_page() {

		LandingPage lp = new LandingPage(webDriver);
		loginPage = lp.login();

	}
	
	// For single user test
	/*
	 * @When("User enters {string} and {string} and logs in") public void
	 * user_enters_and_and_logs_in(String string, String string2) {
	 * 
	 * loginPage.loginId().sendKeys(string); loginPage.password().sendKeys(string2);
	 * loginPage.login().click(); }
	 */

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password){
		
		loginPage.loginId().sendKeys(username);
		loginPage.password().sendKeys(password);
		loginPage.login().click();
		
	}

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {

	}

}
