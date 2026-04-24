package com.dap.qa.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.dap.qa.base.BaseTest;
import com.dap.qa.utils.ConfigReader;
import com.dap.qa.utils.ExtentTestManager;

public class LoginPage extends BaseTest
{

	public Logger logger=LogManager.getLogger(LoginPage.class);
	
	public void mybusinessnextloginpage()
	{
		ExtentTestManager.getTest().info("Entering username");
		logger.info("Entering username");
		getDriver().findElement(By.id(ConfigReader.get("usernameid"))).sendKeys(ConfigReader.get("username"));
		ExtentTestManager.getTest().info("UserName has been entered successfully");
		logger.info("UserName has been entered successfully");
		ExtentTestManager.getTest().info("Entering password");
		logger.info("Entering password");
		getDriver().findElement(By.id(ConfigReader.get("passwordid"))).sendKeys(ConfigReader.get("password"));
		ExtentTestManager.getTest().info("Password has been entered successfully");
		logger.info("Password has been entered successfully");
		ExtentTestManager.getTest().info("Clicking login button");
		logger.info("Clicking login button");
		getDriver().findElement(By.id(ConfigReader.get("loginbutton"))).click();
		ExtentTestManager.getTest().info("Login Successfull");
		logger.info("Login Successfull");
		
	}
}
