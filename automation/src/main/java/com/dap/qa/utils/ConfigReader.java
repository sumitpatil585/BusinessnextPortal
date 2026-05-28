package com.dap.qa.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	private static Properties prop;

	
	static 
	{
		try 
		{
			FileInputStream fis = new FileInputStream(
					"D:\\Automation\\BusinessnextPortal\\src\\test\\resources\\Properties_File\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) 
		{
			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}
	 
	
	/*
	 * public void configreader() throws Exception { FileInputStream fis = new
	 * FileInputStream(
	 * "D:/Selenium Course/MySeleniumSessions/FrameWorkPractice27012026/selenium-framework/src/test/resources/Properties_File/config.properties"
	 * ); prop = new Properties(); prop.load(fis);
	 * 
	 * }
	 */

    public static String get(String key) 
    {
        return prop.getProperty(key);
    }
}
