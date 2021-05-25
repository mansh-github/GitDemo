/**
 * 
 */
package ManvenProjects.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class LandingValidation extends Base {

	WebDriver webDriver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void beforeTest() throws IOException {
		
		webDriver = initializerDriver();
		log.info("LandingPage driver is initialized");

	}

	@Test
	public void baseNavigation() throws IOException {

		webDriver.get(prop.getProperty("url"));

		log.info("Navigated Landing to home page");

		LandingPage lp = new LandingPage(webDriver);
		lp.txt().getText();

		System.out.println("text printing = " + lp.txt().getText());

		Assert.assertEquals(lp.txt().getText(), "FEATURED COURSES");

		log.info("Successfully validated FEATURED COURSES");

	}

	@AfterTest
	public void afterTest() {

		webDriver.close();
		
		log.info("LandingPage driver is closed");
	}

}
