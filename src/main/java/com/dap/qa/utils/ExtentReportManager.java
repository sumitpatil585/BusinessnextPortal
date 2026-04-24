package com.dap.qa.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.dap.qa.base.BaseTest;

public class ExtentReportManager
{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	
	
	String repName;
	public void onStart(ITestContext context)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		repName = "Test-Report-" + timestamp + ".html";
		sparkreporter = new ExtentSparkReporter(".\\Reports\\" + repName);
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Computer Name", "SUMITPC");
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Os", "Windows 10");
		extent.setSystemInfo("Browser Name", "Chrome");
	}
	public void onTestStart(ITestResult result) 
	{
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		ExtentTestManager.setTest(test);
		
	}
	public void onTestSuccess(ITestResult result)
	{
		//test=extent.createTest(result.getMethod().getMethodName(), "Login Test").info("Sumit");
		//test = extent.createTest(result.getMethod().getMethodName());
		//test.log(Status.PASS, result.getName() + "got Successfully executed");
		//WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
		ExtentTestManager.getTest().log(Status.PASS, result.getMethod().getMethodName() + "Test Passed");
		/*
		 * String screenshot = ScreenShotUtils.captureFullPageScreenshot(driver,
		 * result.getName(),"Passed"); //ExtentTestManager.setTest(null); try {
		 * ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		
	}
	public void onTestFailure(ITestResult result) 
	{
	    WebDriver driver = null;
	    ExtentTest test = ExtentTestManager.getTest();

	    if (test != null) {
	        test.log(Status.FAIL, result.getMethod().getMethodName() + " Test Failed");
	        test.log(Status.FAIL, result.getThrowable());
	    }

	    try {
	        driver = ((BaseTest) result.getInstance()).getDriver();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }

		String screenshot = ScreenShotUtils.captureFullPageScreenshot(driver,result.getMethod().getMethodName(), "Failure_Screenshot", "Failed");
		  
		  if (screenshot != null && !screenshot.isEmpty() && test != null) 
		  { 
			  try 
			  {
				  test.addScreenCaptureFromPath(screenshot); 
			  } catch (Exception e) 
			  {
				  e.printStackTrace(); 
			  } 
		  }
		 
	}
	public void onTestSkipped(ITestResult result) 
	{
		WebDriver driver = null; // define driver
		ExtentTestManager.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "Test Skiped");
		ExtentTestManager.getTest().log(Status.SKIP, result.getThrowable());
		  try {
		        Object currentClass = result.getInstance();
		        driver = ((BaseTest) currentClass).getDriver();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 if (driver != null)
		 {
			 String screenshot = ScreenShotUtils.captureFullPageScreenshot(driver, result.getMethod().getMethodName(),"Skipped_Screenshot","Skipped");
		
			 try
			 {
				 ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
	
}
