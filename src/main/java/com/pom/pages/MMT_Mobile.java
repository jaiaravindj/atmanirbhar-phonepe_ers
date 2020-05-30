package com.pom.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class MMT_Mobile extends TestBase {
	
	
	public MMT_Mobile() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		Logs.INFO("This is constructor - MMT");
	}
	
	
	

 	
	

}
