package ManvenProjects.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	WebDriver webDriver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void beforeTest() throws IOException {
		
		
		webDriver = initializerDriver();
		log.info("HomePage driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void baseNavigation(String username, String password) throws IOException {

		log.info("clicked on url");
		webDriver.get(prop.getProperty("url"));

		log.info("this is Landing page");
		LandingPage lp = new LandingPage(webDriver);
		LoginPage loginPage = lp.login();
		log.info("clicked on login link");

		loginPage.loginId().sendKeys(username);
		loginPage.password().sendKeys(password);
		loginPage.login().click();
		
		ForgotPassword fp = loginPage.forgotPassword();
		log.info("clicked on forgotpassword link");
		   fp.emailId().sendKeys("xyz@gmail.com");
		   fp.sendInstruction().click();
		log.info("successfull done");
		
	}

	@Test
	@DataProvider
	public Object[][] getData() {
		
		log.info("Validating dataprovider test data");

		Object[][] obj = new Object[1][2];

		obj[0][0] = "firstuser";
		obj[0][1] = "firstp";

		
		/*
		 * obj[1][0] = "Second user"; obj[1][1] = "Second password";
		 */
		 

		return obj;

	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
		 log.info("HomePage driver is closed");
	}
}
