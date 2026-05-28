package com.dap.qa.testcase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.dap.qa.base.BaseTest;
import com.dap.qa.page.CasesPage;

import com.dap.qa.utils.ExcelUtils;
import com.dap.qa.utils.ExtentTestManager;
public class CaseCreationTest extends BaseTest
{
	public Logger logger=LogManager.getLogger(CaseCreationTest.class);
	//LoginPage lp = new LoginPage();
	
	
	/*
	 * @Test public void loginpagetest() throws InterruptedException {
	 * ExtentTestManager.getTest().info("Opening login page");
	 * lp.mybusinessnextloginpage(); String Title = getDriver().getTitle();
	 * Thread.sleep(7000); System.out.println(Title);
	 * ExtentTestManager.getTest().info("Verifying title");
	 * //Assert.assertEquals(Title, "Summary - BUSINESSNEXT - Up for Tomorrow");
	 * //Assert.assertEquals(Title, "BUSINESSNEXT - Up for Tomorrow");
	 * ExtentTestManager.getTest().pass("Login test completed successfully");
	 * logger.info("Login test passed successfully"); }
	 */
	 
	/*
	 * @Test(dependsOnMethods = "loginpagetest",enabled = true) public void
	 * summarypagetest() throws Exception { lp.mybusinessnextloginpage();
	 * Thread.sleep(3000); SummaryPage sp = new SummaryPage(); sp.summarypage();
	 * String Title = getDriver().getTitle(); System.out.println(Title);
	 * Assert.assertEquals(Title, "Cases - BUSINESSNEXT - Up for Tomorrow");
	 * ExtentTestManager.getTest().info("summarypagetest passed successfully");
	 * logger.info("summarypagetest passed successfully"); }
	 */
	 
	//@Test(dataProvider = "CaseData",dataProviderClass = ExcelUtils.class, enabled = true)
	
	
	@Test(dataProvider = "CaseData",dataProviderClass = ExcelUtils.class)
	public void casestest(String TC_ID, String Projectname,String projectmodule, String ProductTypeCaseValue, String Account_Name, String Assigned_To, String CaseAnalysisValue, String Applies_To_value, String Status) throws Exception 
	{
		
		CasesPage cp = new CasesPage();
		cp.mybusinessnextloginpage();
		Thread.sleep(3000);
		cp.summarypage();
		Thread.sleep(10000);
		cp.casespage(Projectname,projectmodule,ProductTypeCaseValue,Account_Name,Assigned_To, CaseAnalysisValue,Applies_To_value);
		Thread.sleep(10000);
		String Title = getDriver().getTitle();
		
		/*
		 * for (int i = 0; i <= data.length; i++) { String columnName =
		 * data[i][0].toString(); String value = data[i][1].toString();
		 * 
		 * System.out.println("Column: " + columnName + " | Value: " + value);
		 * 
		 * // Example: Use Selenium to fill the form //
		 * driver.findElement(By.id(columnName)).sendKeys(value); }
		 */
		 
		Assert.assertEquals(Title, "Incident - BUSINESSNEXT - Up for Tomorrow");
		ExtentTestManager.getTest().pass("summarypagetest passed successfully");
		logger.info("casestest passed successfully");
		
		
		
	
	}
}
