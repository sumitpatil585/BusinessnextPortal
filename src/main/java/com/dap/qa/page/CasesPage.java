package com.dap.qa.page;
import java.awt.RenderingHints.Key;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dap.qa.base.BaseTest;
import com.dap.qa.utils.ActionUtilities;
import com.dap.qa.utils.ConfigReader;
import com.dap.qa.utils.ExtentTestManager;
import com.dap.qa.utils.ScreenShotUtils;

public class CasesPage extends BaseTest
{
	public Logger logger = LogManager.getLogger(CasesPage.class);
	ActionUtilities actionUtil;

	public CasesPage() 
	{
		PageFactory.initElements(getDriver(), this);
		actionUtil = new ActionUtilities(getDriver());
	} 
	@FindBy(xpath = "//i[@class='icon-obj9']")
	WebElement cases;
	@FindBy (xpath= "//div[contains(@class,'page-title__link')]") 
	WebElement New;
	@FindBy (xpath = "//span[normalize-space()='Incident']")
	WebElement incident;
    @FindBy(xpath = "//a[@data-autoid=\"cust_1955_srch\"]")
    WebElement projectnamebutton;
    @FindBy(xpath = "//input[@name='Grid_SearchTextBox']")
    WebElement searchtext;
    @FindBy(xpath = "//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")
    WebElement searchbutton;
    @FindBy(xpath = "//div[@class='pv-8 pl-16 flex items-center wt--100 flex-1 min-ht--100 css-0']")
    WebElement searchedprojectname;
    @FindBy(xpath = "//a[@data-autoid='cust_5042_srch']")
    WebElement projectmodulesearchbutton;
    @FindBy(xpath = "//input[@data-autoid='Grid_SearchTextBox_ctrl']")
    WebElement projectmoduletextfield;
    @FindBy(xpath = "//a[@data-autoid='gridHF_cust_5042']")
    WebElement searchbutton2;
    @FindBy(xpath = "//div[@title='Track 2.3']")
    WebElement searchedprojectmodule;
    WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
    @FindBy(xpath = "//select[@data-autoid='cust_7321_ctrl']")
    WebElement ProductTypeCase;
    @FindBy(xpath = "//a[@data-autoid='CASE_ACCOUNTNAME_srch']")
    WebElement Account_Name_Serach_Button;
    @FindBy(xpath = "//input[@data-autoid='Grid_SearchTextBox_ctrl']")
    WebElement Account_Name_Text_Field;
    @FindBy(xpath = "//a[@data-autoid='gridHF_CASE_ACCOUNTNAME']")
    WebElement searchbutton3;
    @FindBy(xpath = "//div[@data-autoid='Name_0']")
    WebElement searched_account_name;
    @FindBy(xpath = "//a[@data-autoid='CASE_CURRENTOWNER_srch']")
    WebElement assigned_to_button;
    @FindBy(xpath = "//input[@data-autoid='Grid_SearchTextBox_ctrl']")
    WebElement assigned_to_text_field;
    @FindBy(xpath = "//a[@data-autoid='gridHF_CASE_CURRENTOWNER']")
    WebElement searchbutton4;
    @FindBy(xpath = "//div[@data-autoid='ShortName_0']")
    WebElement searched_assigned_to;
    @FindBy(xpath = "//select[@data-autoid='cust_235_ctrl']")
    WebElement CaseAnalysis;
    @FindBy(xpath = "//select[@data-autoid='cust_236_ctrl']")
    WebElement Applies_To;
    @FindBy(xpath = "//select[@data-autoid='CASE_STATUSCODE_ctrl']")
    WebElement Status_Code;
    @FindBy(xpath = "//input[@data-autoid='cust_23_ctrl']")
    WebElement Build_Version;
    @FindBy(xpath = "//select[@data-autoid='CASE_PRIORITY_ctrl']")
    WebElement Priority;
    @FindBy(xpath = "//select[@data-autoid='CASE_SEVERITY_ctrl']")
    WebElement Severity;
    @FindBy(xpath = "//input[@data-autoid='CASE_SUBJECT_ctrl']")
    WebElement Subject;
    @FindBy(xpath = "//textarea[@data-autoid='CASE_DETAIL_ctrl']")
    WebElement Details;
    @FindBy(xpath = "//select[@data-autoid='cust_3592_ctrl']")
    WebElement Dependency;
    @FindBy(xpath = "//select[@data-autoid='cust_3163_ctrl']")
    WebElement Module;
    @FindBy(xpath = "//select[@data-autoid='cust_2829_ctrl']")
    WebElement Issue_Type;
    @FindBy(xpath = "//select[@data-autoid='cust_7197_ctrl']")
    WebElement Module2;
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
 
   

    public void summarypage() 
    {
        actionUtil.mouseOverAndClick(cases, cases);
        ExtentTestManager.getTest().pass("Successfully clicked on Cases");
    }
    

	public void casespage(String ProjectName, String projectmodule, String ProductTypeCaseValue, String Account_Name, String Assigned_To, String CaseAnalysisValue, String Applies_To_value) throws InterruptedException
	{
		actionUtil.mouseHover(New);
		ExtentTestManager.getTest().info("Mousehover successfully on New");
		logger.info("Mousehover successfully on New");
		String screenshotPath = ScreenShotUtils.captureVisibleScreenshot(getDriver(),"CaseCreationTest", "CasesPage_MouseHover", "Passed");
	    ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
	    actionUtil.mouseclick(incident);
		ExtentTestManager.getTest().info("Mousehover successfully on New");
		logger.info("Successfully clicked on incident");
		String screenshotPath2 = ScreenShotUtils.captureVisibleScreenshot(getDriver(),"CaseCreationTest", "CasesPage_Incident","Passed");
	    ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath2);
	    actionUtil.mouseclick(projectnamebutton);
	    ExtentTestManager.getTest().info("Successfully clicked on Project Name Button");
		logger.info("Successfully clicked on Project Name Button");
    	actionUtil.mouseclick(searchtext);
    	ExtentTestManager.getTest().info("Successfully clicked on Project Name searchtext field");
		logger.info("Successfully clicked on Project Name searchtext field");
    	searchtext.sendKeys(ProjectName);
    	ExtentTestManager.getTest().info("Successfully Entered Project Name searchtext field");
		logger.info("Successfully Entered Project Name searchtext field");
    	searchbutton.click();
    	ExtentTestManager.getTest().info("Successfully clicked on Project Name Search Button");
		logger.info("Successfully clicked on Project Name Search Button");
		
		wait.until(ExpectedConditions.elementToBeClickable(searchedprojectname)).click();
		ExtentTestManager.getTest().info("Successfully clicked on Searched Project Name");
		logger.info("Successfully clicked on Searched Project Name");
    	//String abcd = searchedprojectname.getText();
    	//Assert.assertEquals(abcd, ProjectName);
    	wait.until(ExpectedConditions.elementToBeClickable(projectmodulesearchbutton)).click();
    	ExtentTestManager.getTest().info("Successfully clicked on Project Module Search Button");
		logger.info("Successfully clicked on Project Module Search Button");
    	//Thread.sleep(5000);
    	//actionUtil.mouseclick(projectmoduletextfield);
    	wait.until(ExpectedConditions.visibilityOf(projectmoduletextfield));
    	projectmoduletextfield.sendKeys(projectmodule);
    	ExtentTestManager.getTest().info("Project Module Name successfully entered in field");
		logger.info("Project Module Name successfully entered in field");
    	searchbutton2.click();
    	ExtentTestManager.getTest().info("Successfully clicked on Search Button");
		logger.info("Successfully clicked on Search Button");
    	wait.until(ExpectedConditions.visibilityOf(searchedprojectmodule)).click();
    	ExtentTestManager.getTest().info("Successfully clicked on Searched Project Module Name");
		logger.info("Successfully clicked on Searched Project Module Name");
    	//Thread.sleep(2000);
    	//actionUtil.mouseclick(searchedprojectmodule);
    	//CasesPage_MouseHover
    	//CasesPage_Incident
		wait.until(ExpectedConditions.visibilityOf(ProductTypeCase));
		
		actionUtil.dropdownselect(ProductTypeCase,ProductTypeCaseValue);
		ExtentTestManager.getTest().info("ProductTypeCase dropdown value selected");
		logger.info("ProductTypeCase dropdown value selected");
		wait.until(ExpectedConditions.elementToBeClickable(Account_Name_Serach_Button)).click();
		ExtentTestManager.getTest().info("Clicked on Account Name Search Button");
		logger.info("Clicked on Account Name Search Button");
		wait.until(ExpectedConditions.elementToBeClickable(Account_Name_Text_Field)).click();
		ExtentTestManager.getTest().info("Clicked on Account Name Text Field");
		logger.info("CClicked on Account Name Text Field");
		
		Account_Name_Text_Field.sendKeys(Account_Name);
		ExtentTestManager.getTest().info("Account Name entered in Account Name Text Field ");
		logger.info("Account Name entered in Account Name Text Field ");
		searchbutton3.click();
		ExtentTestManager.getTest().info("Clicked on search button ");
		logger.info("Clicked on search button ");
		wait.until(ExpectedConditions.elementToBeClickable(searched_account_name)).click();
		ExtentTestManager.getTest().info("Clicked on searched account name ");
		logger.info("Clicked on searched account name");
		actionUtil.scrolldown(assigned_to_button);
		ExtentTestManager.getTest().info("Scroll down till assigned to button");
		logger.info("Scroll down till assigned to button");
		wait.until(ExpectedConditions.elementToBeClickable(assigned_to_button)).click();
		ExtentTestManager.getTest().info("Clicked on assigned to button");
		logger.info("Clicked on assigned to button");
		wait.until(ExpectedConditions.visibilityOf(assigned_to_text_field));
	
		assigned_to_text_field.sendKeys(Assigned_To);
		ExtentTestManager.getTest().info("Assigned To value in entered assigned to text field");
		logger.info("Assigned To value in entered assigned to text field");
		searchbutton4.click();
		ExtentTestManager.getTest().info("Clicked on search button ");
		logger.info("Clicked on search button ");
		wait.until(ExpectedConditions.elementToBeClickable(searched_assigned_to)).click();
		ExtentTestManager.getTest().info("Clicked on searched assigned to");
		logger.info("Clicked on searched assigned to");
		System.out.println();
		actionUtil.dropdownselect(CaseAnalysis, CaseAnalysisValue);
		//wait.until(ExpectedConditions.elementToBeClickable(Applies_To));
		//CaseAnalysis.sendKeys(Keys.TAB);
		//wait.until(ExpectedConditions.visibilityOf(Applies_To));
		//Thread.sleep(10000); 
		System.out.println(Applies_To_value + "     " + Applies_To_value );
		actionUtil.dropdownselect(Applies_To, Applies_To_value);
		
		
	}
}
