package com.pom.utilities;



import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.pom.framework.IBaseInterface;
import com.pom.framework.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class TestListener extends TestBase implements ITestListener {
	
	
	String message;
	String filepath;
	ExtentReportListener extReport = new ExtentReportListener();

	
	public void onStart(ITestContext context) {
		
		ExtentReportListener.setReportDirectory((IBaseInterface.PROJECT_PATH + File.separator + "ExtentReports"), (context.getSuite().getName()));
		ExtentReportListener.setSystemInfo();
		Logs.INFO("Set Output Report Directory and System Info");
	}

	public void onTestStart(ITestResult result) {

		ExtentReportListener.getStartTestName(result);
		ExtentReportListener.status(LogStatus.INFO, "Execution of Test is started");
		Logs.INFO("******** Test Execution Started : " + result.getTestClass().getRealClass().getSimpleName() + " ********");
		ExtentReportListener.flush();
	}

	public void onTestSuccess(ITestResult result) {

		Logs.INFO("******** Test Execution Successfully Completed : " + result.getTestClass().getRealClass().getSimpleName() + " ********");
		
		ExtentReportListener.status(LogStatus.INFO, "TestCase execution is Completed");
		ExtentReportListener.endTest();
		ExtentReportListener.flush();
	}

	public void onTestFailure(ITestResult result) {

		Logs.INFO("!!!!!!!!!  Test Execution Failed : " + result.getTestClass().getRealClass().getSimpleName() + "  !!!!!!!!!");
		ExtentReportListener.status(LogStatus.FAIL, "Test Case is failed");
		
		try {	
			filepath = extReport.CaptureScreenshot(result.getTestClass().getRealClass().getSimpleName().substring(0, 6));
		} catch (Exception ex) {
			Logs.ERROR("Exception in capturing screenshot - " + ex.getMessage());
		}

		if (result.getThrowable() != null) {
			message = result.getThrowable().getMessage();
			try {

			} catch (Exception ex) {
				Logs.ERROR(ex.getMessage());
			}
			
			ExtentReportListener.status(LogStatus.FAIL, "Test Case is failed due to: " + message);
		}
		ExtentReportListener.endTest();
		ExtentReportListener.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
		Logs.INFO("Test Skipped : " + result.getTestClass().getRealClass().getSimpleName());
		ExtentReportListener.status(LogStatus.SKIP, "TestCase is Skipped");
		
		try {
			filepath = extReport.CaptureScreenshot(result.getTestClass().getRealClass().getSimpleName().substring(0, 6));
		} catch (Exception ex) {
			Logs.INFO("Exception in capturing screenshot - " + ex.getMessage());
		}

		if (result.getThrowable() != null) {
			message = result.getThrowable().getMessage();
			try {

			} catch (Exception ex) {
				Logs.INFO(ex.getMessage());
			}

			ExtentReportListener.status(LogStatus.SKIP, "Test Case is Skipped due to: " + message);
		}
		ExtentReportListener.endTest();
		ExtentReportListener.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {		

		ExtentReportListener.flush();
		ExtentReportListener.finishReport();
		Logs.INFO("Report is finished");
	}

}
