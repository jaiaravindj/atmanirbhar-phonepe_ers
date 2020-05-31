package com.pom.framework;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.pom.utilities.HeadSpinHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.pom.utilities.Logs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class InitDriver {

	
	ReadProperties readProperties;
	DesiredCapabilities capabilities;
	AppiumDriver<MobileElement> driver;
	WebDriver webDriver;
	String serverUrl = null;

	
	AppiumDriver<MobileElement> initiOS() {

		try {
			
			Logs.INFO("Creating iOS Driver !!!");
			
			readProperties = new ReadProperties();
			capabilities = new DesiredCapabilities();
			
			capabilities.setCapability("deviceName", readProperties.getProperties("iOSDeviceName_6"));
			capabilities.setCapability("sendKeyStrategy", "setValue");
			capabilities.setCapability("newCommandTimeout", 60 * 60);
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("usePrebuiltWDA", true);
			capabilities.setCapability("nativeWebTap", true);
			capabilities.setCapability("newCommandTimeout", 10000);
			capabilities.setCapability("app", readProperties.getProperties("ipa"));
			capabilities.setCapability("udid", readProperties.getProperties("udid_iPhone6"));
			
			capabilities.setCapability("useJSONSource", true);
			capabilities.setCapability("simpleIsVisibleCheck", true);
			
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("fullReset", false);
			
			serverUrl = readProperties.getProperties("serverUrl");
			driver = new IOSDriver<MobileElement>(new URL(serverUrl), capabilities);
			Logs.INFO("Driver in initiOS() - " + driver.getSessionId());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logs.ERROR("Please check if Appium is started or not ------ " + e.getMessage());
		}

		return driver;
	}
	
	
	AppiumDriver<MobileElement> initAndroid() throws IOException {
		readProperties = new ReadProperties();
//		HeadSpinHelper headSpinHelper = new HeadSpinHelper();
//		Map headSpinCaps = headSpinHelper.getHeadSpinDevices(readProperties.getProperties("headSpinAuthToken"));

		try {
			
			Logs.INFO("Creating Android Driver !!!");

			capabilities = new DesiredCapabilities();
			
			capabilities.setCapability("appPackage", readProperties.getProperties("appPackage"));
			capabilities.setCapability("appActivity", readProperties.getProperties("appActivity"));
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", readProperties.getProperties("PlatformVersion"));
//			capabilities.setCapability("deviceName", headSpinCaps.get("deviceId"));
//			capabilities.setCapability("udid", headSpinCaps.get("deviceId"));
 			capabilities.setCapability("deviceName", readProperties.getProperties("androidDeviceName"));
			capabilities.setCapability("udid", readProperties.getProperties("androidDeviceName"));
			capabilities.setCapability("app", IBaseInterface.PROJECT_PATH + File.separator + "Resources" + File.separator + "mmt.apk");
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("unicodekeyboard", true);
			capabilities.setCapability("resetkeyboard", true);
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("newCommandTimeout", 600);
			capabilities.setCapability("headspin:capture.video", true);

			serverUrl = readProperties.getProperties("serverUrl");
//			serverUrl = headSpinCaps.get("driverUrl").toString();
			driver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);
			Logs.INFO("Driver in initAndroid() - " + driver.getSessionId());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logs.ERROR("Please check if Appium is started or not ------ " + e.getMessage());
		}

		return driver;
	}
	
	public WebDriver invokeWebDriver(String browserName, String Url) throws MalformedURLException {
		
		try {
			readProperties = new ReadProperties();
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", IBaseInterface.PROJECT_PATH + File.separator + "Resources" + File.separator + "chromedriver");
				webDriver = new ChromeDriver();
			}
			webDriver.get(Url);
			return webDriver;

		} catch (Exception e) {
			Logs.ERROR(e.getMessage());
		}
		return driver;
	}
	
	

}
