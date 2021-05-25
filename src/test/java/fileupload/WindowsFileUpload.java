package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsFileUpload {

	public static void main(String[] args) throws InterruptedException, IOException   {
	
		String downloadPath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HIMANSHU\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver webDriver=new ChromeDriver(options);
		webDriver.get("https://smallpdf.com/pdf-converter");
		webDriver.findElement(By.cssSelector("[class='l3tlg0-0 hrcxSS']")).click();
		Thread.sleep(3000L);
		
		Runtime.getRuntime().exec("C:\\\\Users\\\\HIMANSHU\\\\Documents\\\\fileupload.exe");
		
		Thread.sleep(8000L);
		
		
		  WebDriverWait wait = new WebDriverWait(webDriver, 20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		  cssSelector("[class='wnolmd-2 etrSPs']")));
		 
		webDriver.findElement(By.cssSelector("[class='wnolmd-2 etrSPs']")).click();
		
		
		File fs = new File(downloadPath+"/Capture-converted.pdf");
		
		Thread.sleep(8000L);
		
		if(fs.exists()) {
			
			System.out.println("file is present there");
			
			
			  if(fs.delete()) {
			  
			  System.out.println("file deleted"); }
			 	
			
		}else {
			
			System.out.println("No file downloaded");
		}


	}

}
