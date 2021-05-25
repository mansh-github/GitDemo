package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver wbdriver;
	
	public LandingPage(WebDriver wbdriver) {
		
		this.wbdriver = wbdriver;
	}
	
	By login = By.cssSelector("a[href*='sign_in']");
	By txt  = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	
	
	public LoginPage login() {
		
		 wbdriver.findElement(login).click();
		 return new LoginPage(wbdriver);
		
	}
	
	public WebElement txt() {
		
		 return wbdriver.findElement(txt);
		
	}
}
