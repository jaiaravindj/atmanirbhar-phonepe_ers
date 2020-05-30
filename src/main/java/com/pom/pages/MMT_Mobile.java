package com.pom.pages;

import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class MMT_Mobile extends TestBase {
    private String testEmail = "atmanirbhar.phonep.ers@gmail.com";
    private String password = "Sumed@Jai123";
    private String cityName = "Delhi";
    TestBase testBase;


    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private MobileElement gLoginDismiss;
    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement mmtEditText;
    @AndroidFindBy(id = "com.makemytrip:id/btn_continue")
    private MobileElement mmtLoginContinueButton;
    @AndroidFindBy(id = "com.makemytrip:id/pwd_option")
    private MobileElement mmtLoginViaPasswordButton;
    @AndroidFindBy(id = "com.makemytrip:id/universal_search")
    private MobileElement mmtUniversalSearchLayout;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.makemytrip:id/title' and @text='Hotels']")
    private MobileElement mmtHotelsText;
    @AndroidFindBy(id = "com.makemytrip:id/city")
    private MobileElement mmtCityEditText;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.makemytrip:id/rv_autosearch_locus' and @index=0]")
    private MobileElement mmtCityList;
    @AndroidFindBy(id = "com.makemytrip:id/checkIn_layout")
    private MobileElement mmtCheckInLayout;
    @AndroidFindBy(id = "com.makemytrip:id/checkOut_layout")
    private MobileElement mmtCheckOutLayout;

    public MMT_Mobile() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        testBase = new TestBase();
        Logs.INFO("This is constructor - MMT");
    }

    public void MMT_Login() {
        if (!testbase.isDisplayed(mmtLoginContinueButton))
            return;
        testBase.waitForElement(gLoginDismiss, 3);
        testBase.click(gLoginDismiss);

        testBase.enterText(mmtEditText, testEmail);
        testBase.click(mmtLoginContinueButton);

        testBase.click(mmtLoginViaPasswordButton);
        testBase.enterText(mmtEditText, password);
        testBase.click(mmtLoginContinueButton);
        testbase.waitForElement(mmtUniversalSearchLayout, 3);
    }

    public void MMT_Hotels() {
        testbase.waitForElement(mmtHotelsText, 5);
        testbase.click(mmtHotelsText);
        testbase.waitForElement(mmtCityEditText, 5);
        testbase.click(mmtCityEditText);
        testbase.enterText(mmtEditText, cityName);
        testbase.click(mmtCityList);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
