package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Base {

	public WebDriver webDriver;
	public Properties prop;

	public WebDriver initializerDriver() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HIMANSHU\\Downloads\\chromedriver_win32\\chromedriver.exe");

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properites");
		prop.load(fis);

		//String driverName = System.getProperty("browser");
		//System.out.println("taking the value form maven = " + driverName);

		// If we want to get the value form property file
		String driverName = prop.getProperty("driver");

		if (driverName.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();
			
			if (driverName.contains("headless")) {

				options.addArguments("headless");
				
				System.out.println("The chrome browser is inside headless");

			}

			webDriver = new ChromeDriver(options);

		} else if (driverName.equals("firefox")) {

			System.out.println("In Mozilla firefox");

		} else if (driverName.equals("chrome")) {

			System.out.println("In Internet explorer");
		}

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return webDriver;
	}

	public String getScreenshotOfError(String testcase, WebDriver driver) throws IOException {

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File Source = screenShot.getScreenshotAs(OutputType.FILE);
		String location = System.getProperty("user.dir") + "\\reports\\" + testcase + ".PNG";
		FileUtils.copyFile(Source, new File(location));

		return location;
	}

}
