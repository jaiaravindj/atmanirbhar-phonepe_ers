package com.pom.utilities;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.testng.ITestResult;
import com.pom.framework.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportListener extends TestBase {
	
	
	private static ExtentReports extent;
	public static ExtentTest test;
	static Map<String, String> device = new HashMap<String, String>();


	public static void setReportDirectory(String reportPath, String suiteName) {
		
		String extentReportFolderName = new SimpleDateFormat("MMM-yyyy").format(Calendar.getInstance().getTime());
		String extentReportSubFolderName = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime());
		String extentReportFileName = suiteName + "_" + new SimpleDateFormat("dd.MMM.yyyy_hh:mm").format(Calendar.getInstance().getTime()) + ".html"; 
		
		extent = new ExtentReports(reportPath + File.separator + extentReportFolderName + File.separator + extentReportSubFolderName + File.separator + extentReportFileName);
	}

	public static void setSystemInfo() {
		
		Map<String, String> info = new HashMap<String, String>();
		info.put("Tested by", "Sumed Khicha");

		try {
			extent.addSystemInfo(info);
			extent.addSystemInfo(device);
			
		} catch (Exception ex) {
			Logs.INFO(ex.getMessage());
		}
	}

	public static void flush() {
		
		try {
			extent.flush();
			Thread.sleep(1000);
		} catch (InterruptedException ex) {

		}
	}

	public static void finishReport() {

		try {
			Thread.sleep(2000);
			extent.close();
		} catch (InterruptedException ex) {

		}
	}

	public static void getStartTestName(ITestResult result) {

		test = extent.startTest(result.getTestClass().getRealClass().getName() + " : " + result.getMethod().getMethodName());
	}

	public static void setTestTime(ITestResult result) {
		
		test.getTest().setStartedTime(getTime(result.getStartMillis()));

		test.getTest().setEndedTime(getTime(result.getEndMillis()));
	}

	public static void assignCategory(String group) {
		
		test.assignCategory(group);
	}

	public static void status(LogStatus status, String message) {
		
		test.log(status, message);
	}

	public static void endTest() {
		
		try {
			extent.endTest(test);
			Thread.sleep(200);
		} catch (InterruptedException ex) {

		}
	}

	private static Date getTime(long millis) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public String CaptureScreenshot(String className) {
		
		String FilePath = snapshot(className);
		test.log(LogStatus.INFO, "Screenshot --> " + className + test.addScreenCapture(FilePath));
		return FilePath;
	}

}
