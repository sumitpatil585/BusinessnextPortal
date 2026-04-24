package com.dap.qa.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.dap.qa.utils.ConfigReader;
import com.dap.qa.utils.ExcelUtils;

public class BaseTest 
{

	
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
	public Logger logger=LogManager.getLogger(BaseTest.class);
	
@BeforeMethod
	public void setUp() 
	{
	
	logger.info("========== Test Started ==========");
    logger.info("Launching browser");
		
		String browser = ConfigReader.get("browser");

		if (browser.equalsIgnoreCase("chrome")) 
		{
			
			String chromemode = ConfigReader.get("chromemode");
			if(chromemode.isBlank())
			{
				driverThread.set(new ChromeDriver());
			}
			else
			{
				ChromeOptions options;
				options = new ChromeOptions();
				options.addArguments(ConfigReader.get("chromemode"));
				driverThread.set(new ChromeDriver(options));
			}
			logger.info("Chrome browser Launched Successfully");
			
		} 
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			String firefoxmode = ConfigReader.get("firefoxmode");
			if(firefoxmode.isBlank())
			{
				driverThread.set(new FirefoxDriver());
			}
			else
			{
				FirefoxOptions options;
				options = new FirefoxOptions();
				options.addArguments(ConfigReader.get("firefoxmode"));
				driverThread.set(new FirefoxDriver(options));
			}
			logger.info("FireFox browser Launched Successfully");
			
		} 
		else if (browser.equalsIgnoreCase("edge")) 
		{

		    

		    String edgeMode = ConfigReader.get("edgemode");
		    EdgeOptions options = new EdgeOptions();

		    if (edgeMode != null && !edgeMode.trim().isEmpty()) 
		    {
		        options.addArguments(edgeMode);
		    }

		    driverThread.set(new EdgeDriver(options));
			logger.info("Microsoft Edge browser Launched Successfully");

		}
		else 
		{
			throw new RuntimeException("Browser not supported: " + browser);
		}
		getDriver().manage().window().maximize();
		getDriver().get(ConfigReader.get("url"));
	}
	
	
	@AfterMethod
	public void teardown() 
	{
		
		logger.info("Closing browser");
		WebDriver driver = getDriver();
		if (driver != null) 
		{
			driver.quit();
			driverThread.remove();
		}
		logger.info("browser Closed Successfully");
	}


	public WebDriver getDriver() 
	{
		return driverThread.get();
	}
	
	@AfterMethod
    public void updateResult(ITestResult result) {

        String testName = result.getName();
        String status = "Fail";

        if (result.getStatus() == ITestResult.SUCCESS) {
            status = "Pass";
        }

        ExcelUtils.updateTestStatus(testName, status);
    }
	 
}
