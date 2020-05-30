package com.pom.framework;



import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.pom.utilities.Logs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;




public class TestBase extends ReadProperties implements IBaseInterface {


	public TestBase testbase;
	public static AppiumDriver<MobileElement> driver;
	public static WebDriver webDriver;
	public static String driverFlag;
	InitDriver initDriver;
	ReadProperties prop;


	public TestBase() {
		testbase = this;
		prop = new ReadProperties();
	}

	
	public AppiumDriver<MobileElement> invokeDriver(String osType) {

		if (driver == null || driver.getSessionId() == null) {

			Logs.INFO("Appium Driver is null.. Initialising the Web Driver");
			initDriver = new InitDriver();

			if (osType.equalsIgnoreCase("iOS")) {
				driver = initDriver.initiOS();
			} else {
				driver = initDriver.initAndroid();
			}
		}

		driverFlag = "android";
		Logs.INFO("Session Returned by Driver: " + driver.getSessionId());
		return driver;
	}
	
	public WebDriver invokeWebDriver(String browserName, String webURL) throws IOException, InterruptedException {
		
		Logs.INFO("Inside Web Driver Class");
		
		if ((webDriver == null) || (webDriver.toString().contains("null"))) {
			
			Logs.INFO("Web Driver is null.. Initialising the Web Driver");
			initDriver = new InitDriver();
			webDriver = initDriver.invokeWebDriver(browserName, webURL);
		}
		
		driverFlag = "chrome";
		Logs.INFO("Session Returned by Driver - " + webDriver.toString());
		return webDriver;
	}

	public void click(MobileElement element) {

		try {

			element.click();

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElement(element, 10);
			element.click();

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}
	
	public void click(WebElement element) {

		try {

			element.click();

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElementToBeClickable(element, 10);
			element.click();

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	public boolean isDisplayed(MobileElement element) {

		try {
			
			return element.isDisplayed();
			
		} catch (NoSuchElementException e) {
			
			return false;
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
			return false;
		}
	}
	
	public boolean isDisplayed(WebElement element) {

		try {
			
			return element.isDisplayed();
			
		} catch (NoSuchElementException e) {
			
			return false;
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
			return false;
		}
	}

	public boolean isChecked(MobileElement element) {

		try {

			return Boolean.parseBoolean(element.getAttribute("checked"));

		} catch (NoSuchElementException e) {

			return false;

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
			return false;
		}
	}

	public MobileElement waitForElement(MobileElement element, int timeout) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element;
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
			return null;
		}
	}
	
	public static WebElement waitForElementToBeClickable(WebElement element, int defaultTimeoutinSeconds) {

		try {

			FluentWait<WebDriver> fluentWait = new WebDriverWait(webDriver, defaultTimeoutinSeconds);
			element = fluentWait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
			
		} catch(Exception e) {
			
			Logs.ERROR(e.getMessage());
			Assert.fail();
			return null;
		}
	}	
	
	public static WebElement waitForElementToBePresent(WebElement element, int defaultTimeoutinSeconds) {
		
		try {

			FluentWait<WebDriver> fluentWait = new WebDriverWait(webDriver, defaultTimeoutinSeconds).pollingEvery(Duration.ofSeconds(5)).ignoring((NoSuchElementException.class));
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			return element;

		} catch (Exception e) {

			Logs.ERROR(e.getMessage());
			Thread.currentThread().interrupt();
			Assert.fail();
			return null;
		}
	}
	
	public static List<WebElement> WaitForElementToBePresent(List<WebElement> element, int defaultTimeoutinSeconds){

		FluentWait<WebDriver> fluentWait = new WebDriverWait(webDriver, defaultTimeoutinSeconds);
		element = fluentWait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}

	public String getText(MobileElement element) {

		try {

			return element.getText();

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElement(element, 10);
			return element.getText();

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
		return null;
	}
	
	public String getText_web(WebElement element) {

		try {

			return element.getText();

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElementToBePresent(element, 10);
			return element.getText();

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
		return null;
	}

	public void enterText(MobileElement element, String text) {

		try {

			clearText(element);
			element.sendKeys(text);

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElement(element, 10);
			element.sendKeys(text);

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}
	
	public void enterText(WebElement element, String text) {

		try {

			clearText(element);
			element.sendKeys(text);

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElementToBePresent(element, 10);
			element.sendKeys(text);

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {

			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	public String snapshot(String className) {

		try {
			
			File srcFile = null;
			Logs.INFO("Taking Snapshot of Screen");
			if(driverFlag.equals("android")) {
				srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			} else {
				srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			}
			
			String failureImageFolderName = new SimpleDateFormat("MMM-yyyy").format(Calendar.getInstance().getTime());
			String failureImageSubFolderName = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime());
			String failureImageFileName = "ScreenShot_" + new SimpleDateFormat("dd.MMM.yyyy_hh:mm").format(Calendar.getInstance().getTime()) + "_" + className + ".png"; 
	
			String failureImageFilePath = IBaseInterface.PROJECT_PATH + File.separator + "TC_Failure_ScreenShots" + File.separator + 
											failureImageFolderName + File.separator + failureImageSubFolderName + File.separator + failureImageFileName;

			FileUtils.copyFile(srcFile, new File(failureImageFilePath));
			return failureImageFilePath;

		} catch (Exception ex) {
			
			Logs.ERROR(ex.getMessage());
			return null;
		}
	}

	public String readProp(String propertyName) throws IOException {

		return prop.getProperties(propertyName);
	}

	public void clearText(MobileElement element) {

		try {
			
			element.clear();

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElement(element, 10);
			element.clear();

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}
	
	public void clearText(WebElement element) {

		try {
			
			element.clear();

		} catch (NoSuchElementException noSuchElementException) {

			Logs.ERROR(element + " is not found hence retrying one more time");
			waitForElementToBePresent(element, 10);
			element.clear();

		} catch (StaleElementReferenceException staleElementReferenceException) {

			Logs.ERROR(element + " is stale element");
			Assert.fail();

		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	public void scrolling() throws Exception {

		if(driver.toString().contains("android")) {
			scrolling_Android();
		} else {
			scrolling_iOS();
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	public void scrolling_Android() throws Exception {

		try {
			
			if(driver.toString().contains("android")) {
	
				org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();
	
				double screenHeightStart = dimensions.getHeight() * 0.5;
				int scrollStart = (int) screenHeightStart;
				double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = (int) screenHeightEnd;
	
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(0, scrollStart)).waitAction().moveTo(PointOption.point(0, scrollEnd)).release().perform();
			}
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public void scrolling_iOS() {

		try {
			
			if(!(driver.toString().contains("android"))) {
				
				org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();

				double screenHeightStart = dimensions.getHeight() * 0.8;
				int scrollStart = (int) screenHeightStart;
				double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = (int) screenHeightEnd;
				double screenWidthMid = dimensions.getWidth() * 0.5;
				int scrollX = (int) screenWidthMid;
				
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(scrollX, scrollStart)).waitAction(waitOptions(ofSeconds(4))).moveTo(PointOption.point(scrollX, scrollEnd)).release().perform();
			}
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
		
	}

	@SuppressWarnings({ "rawtypes" })
	public void swipe(double x1, double y1, double x2, double y2) {
		
		try {
				
				org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();
				
				double screenWidth = dimensions.getWidth();
				double screenHeight = dimensions.getHeight();
				
				int startX = (int) ((x1 * screenWidth)/100);
				int startY = (int) ((y1 * screenHeight)/100);
				int endX = (int) ((x2 * screenWidth)/100);
				int endY = (int) ((y2 * screenHeight)/100);
				
				
				if(driver.toString().contains("android")) {
					(new TouchAction(driver)).press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY)).release().perform();
				} else {
					(new TouchAction(driver)).press(PointOption.point(startX, startY)).waitAction(waitOptions(ofSeconds(6))).moveTo(PointOption.point(endX, endY)).release().perform();
				}

		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void swipe(int x1, int y1, int x2, int y2) {
		
		try {				
				if(driver.toString().contains("android")) {
					(new TouchAction(driver)).press(PointOption.point(x1, y1)).waitAction().moveTo(PointOption.point(x2, y2)).release().perform();
				} else {
					(new TouchAction(driver)).press(PointOption.point(x1, y1)).waitAction(waitOptions(ofSeconds(6))).moveTo(PointOption.point(x2, y2)).release().perform();
				}

		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public void clickByXY(double x, double y) {

		try {
			
			org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();
			
			double screenWidth = dimensions.getWidth();
			double screenHeight = dimensions.getHeight();
			
			int getX = (int) ((x * screenWidth)/100);
			int getY = (int) ((y * screenHeight)/100);
			
			(new TouchAction(driver)).press(PointOption.point(getX, getY)).release().perform();
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	public void scrollingUp() {

		if(driver.toString().contains("android")) {
			scrollingUp_Android();
		} else {
			scrollingUp_iOS();
		}
	}
	
	@SuppressWarnings({ "rawtypes" })
	public void scrollingUp_iOS() {
		
		try {
			
			if(!driver.toString().contains("android")) {
				
				org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();

				double screenHeightStart = dimensions.getHeight() * 0.2;
				int scrollStart = (int) screenHeightStart;
				double screenHeightEnd = dimensions.getHeight() * 0.8;
				int scrollEnd = (int) screenHeightEnd;
				double screenWidthMid = dimensions.getWidth() * 0.5;
				int scrollX = (int) screenWidthMid;

				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(scrollX, scrollStart)).waitAction(waitOptions(ofSeconds(4))).moveTo(PointOption.point(scrollX, scrollEnd)).release().perform();
			}
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public void scrollingUp_Android() {

		try {
			
			if(driver.toString().contains("android")) {
				
				org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();

				double screenHeightStart = dimensions.getHeight() * 0.4;
				int scrollStart = (int) screenHeightStart;
				double screenHeightEnd = dimensions.getHeight() * 0.7;
				int scrollEnd = (int) screenHeightEnd;
				double screenWidthMid = dimensions.getWidth() * 0.5;
				int scrollX = (int) screenWidthMid;

				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(scrollX, scrollStart)).waitAction().moveTo(PointOption.point(scrollX, scrollEnd)).release().perform();
			}
			
		} catch (Exception unknownExc) {
			
			Logs.ERROR(unknownExc.getMessage());
			Assert.fail();
		}
	}
	
	public static boolean containsInList(List<WebElement> element, String comparator) {

		for(WebElement iterator : element) {
			if( iterator.getText().contains(comparator) || iterator.getText().equalsIgnoreCase(comparator) ) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean selectInList(List<WebElement> element, String comparator) {
		
		for(WebElement iterator : element) {
			if(iterator.getText().contains(comparator) || iterator.getText().equalsIgnoreCase(comparator)) {
				iterator.click();
				return true;
			}
		}
		return false;
	}

	
	
	public void endOfScript() {

		Logs.INFO("###### End of " + this.getClass().getSimpleName() + " ######");
	}

	


}
