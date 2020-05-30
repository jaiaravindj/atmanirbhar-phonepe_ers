package com.pom.pages;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
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
    private String testEmail = "atmanirbhar.phonep.ers@gmail.com";
    private String password = "Sumed@Jai123";
    TestBase testBase = new TestBase();

    private MobileElement gLoginDismiss() {
        return driver.findElementById("com.google.android.gms:id/cancel");
    }

    private MobileElement loginEmailText() {
        return driver.findElementByClassName("android.widget.EditText");
    }

    private MobileElement loginContinueButton() {
        return driver.findElementById("com.makemytrip:id/btn_continue");
    }

    private MobileElement loginViaPasswordButton() {
        return driver.findElementById("com.makemytrip:id/pwd_option");
    }

    private MobileElement mmtUniversalSearchLayout(){
        return driver.findElementById("com.makemytrip:id/universal_search");
    }


    public MMT_Mobile() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Logs.INFO("This is constructor - MMT");
    }

    public void MMT_Login() {

        testBase.waitForElement(gLoginDismiss(),3);
        testBase.click(gLoginDismiss());

        testBase.enterText(loginEmailText(), testEmail);
        testBase.click(loginContinueButton());

        testBase.click(loginViaPasswordButton());
        testBase.enterText(loginEmailText(), password);
        testBase.click(loginContinueButton());
        testbase.waitForElement(mmtUniversalSearchLayout(),3);
    }

    public void MMT_Hotels() {
        testbase.click(mmtUniversalSearchLayout());
    }


}
