package com.dap.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dap.qa.base.BaseTest;
import com.dap.qa.utils.ActionUtilities;
import com.dap.qa.utils.ExtentTestManager;

public class SummaryPage extends BaseTest {

    ActionUtilities actionUtil;

    public SummaryPage() 
    {
        this.actionUtil = new ActionUtilities(getDriver());
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//i[@class='icon-obj9']")
    WebElement cases;

    public void summarypage() 
    {
        actionUtil.mouseOverAndClick(cases, cases);
        ExtentTestManager.getTest().pass("Successfully clicked on Cases");
    }
    
}
 
