package ManvenProjects.Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNg;

public class Listeners extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNg.getExtentReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
	
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS,"Test is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
	
	String name = result.getMethod().getMethodName();
	
	   try {
		   driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("webDriver").get(result.getInstance());
	} catch (Exception e1) {
		e1.printStackTrace();
	} 
	try {
		
		extentTest.get().addScreenCaptureFromPath(getScreenshotOfError(name,driver), result.getMethod().getMethodName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
	 

}
