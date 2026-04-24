package com.dap.qa.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager 
{
	
		private static ThreadLocal<ExtentTest> tltest = new ThreadLocal<ExtentTest>();
		

		public static ExtentTest getTest() 
		{
			return tltest.get();
		}

		public static void setTest(ExtentTest test) 
		{
			tltest.set(test);
		}
	
}
