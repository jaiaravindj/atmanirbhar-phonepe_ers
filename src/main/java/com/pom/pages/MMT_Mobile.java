package com.pom.pages;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    TestBase testBase;


    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private MobileElement gLoginDismiss;
    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement loginEmailText;

    @AndroidFindBy(id = "com.makemytrip:id/btn_continue")
    private MobileElement loginContinueButton;

    @AndroidFindBy(id = "com.makemytrip:id/pwd_option")
    private MobileElement loginViaPasswordButton;

    @AndroidFindBy(id = "com.makemytrip:id/universal_search")
    private MobileElement mmtUniversalSearchLayout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.makemytrip:id/title' and @text='Hotels']")
    private AndroidElement mmtHotelsText;

    public MMT_Mobile() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        testBase = new TestBase();
        Logs.INFO("This is constructor - MMT");
    }

    public void MMT_Login() {
        if (!testbase.isDisplayed(loginEmailText))
            return;
        testBase.waitForElement(gLoginDismiss, 3);
        testBase.click(gLoginDismiss);

        testBase.enterText(loginEmailText, testEmail);
        testBase.click(loginContinueButton);

        testBase.click(loginViaPasswordButton);
        testBase.enterText(loginEmailText, password);
        testBase.click(loginContinueButton);
        testbase.waitForElement(mmtUniversalSearchLayout, 3);
    }
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		Logs.INFO("This is constructor - MMT");
	}


	@AndroidFindBy (id = "com.makemytrip:id/iv_lotte_anim")
	MobileElement gotItBtn;

	@AndroidFindBy (id = "com.makemytrip:id/price_filter")
	MobileElement priceFilterBtn;

    public void MMT_Hotels() {
        testbase.waitForElement(mmtHotelsText,5);
        testbase.click(mmtHotelsText);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@AndroidFindBy (id = "com.makemytrip:id/tv_title")
	MobileElement activityTitle;

	@AndroidFindBy (id = "com.makemytrip:id/tv_price_range")
	MobileElement priceRangeTxt;

	@AndroidFindBy (id = "com.makemytrip:id/price_seek_bar")
	MobileElement priceBar;

	@AndroidFindBy (id = "com.makemytrip:id/tv_apply")
	MobileElement doneBtn;

	@AndroidFindBy (id = "com.makemytrip:id/tvHotelName")
	List<MobileElement> hotelNameTxt;










}
