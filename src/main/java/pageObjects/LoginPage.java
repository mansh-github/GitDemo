package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By loginId = By.id("user_email");
	By password = By.id("user_password");
	By Login = By.xpath("//input[@value='Log In']");
	By forgotPassword = By.cssSelector("a[class='link-below-button']");

	@FindBy(name = "By.xpath(\"//input[@value='Log In']\")")
	By LoginButton;

	public WebElement loginId() {

		return driver.findElement(loginId);
	}

	public WebElement password() {

		return driver.findElement(password);
	}

	public WebElement login() {

		return driver.findElement(Login);
	}

	public ForgotPassword forgotPassword() {

		driver.findElement(forgotPassword).click();
		
		return new ForgotPassword(driver);
	}
}
