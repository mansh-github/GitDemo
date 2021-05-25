package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import resources.Base;

public class ForgotPassword {

	
	WebDriver driver;

	public ForgotPassword(WebDriver driver) {

		this.driver = driver;
	}

	By emailId = By.id("user_email");
	By sendInstruction = By.cssSelector("[type='submit']");

	@FindBy(name = "By.xpath(\"//input[@value='Log In']\")")
	By LoginButton;

	public WebElement emailId() {

		return driver.findElement(emailId);
	}

	public WebElement sendInstruction() {

		return driver.findElement(sendInstruction);
	}
}
