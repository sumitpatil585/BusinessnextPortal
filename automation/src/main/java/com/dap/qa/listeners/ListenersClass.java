package com.dap.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dap.qa.utils.ExcelUtils;
import com.dap.qa.utils.ExtentReportManager;

public class ListenersClass implements ITestListener {

    ExtentReportManager erm = new ExtentReportManager();

    @Override
    public void onStart(ITestContext context) {
        erm.onStart(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        erm.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        erm.onTestSuccess(result);
        updateExcel(result, "Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        erm.onTestFailure(result);
        updateExcel(result, "Fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        erm.onTestSkipped(result);
        updateExcel(result, "Skip");
    }

    @Override
    public void onFinish(ITestContext context) {
        erm.onFinish(context);
    }

    private void updateExcel(ITestResult result, String status) {
        try {
            Object[] data = result.getParameters();

            if (data != null && data.length > 0) {
                String tcId = data[0].toString(); // TC_ID is FIRST column
                ExcelUtils.updateTestStatus(tcId, status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}