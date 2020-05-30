package com.pom.pages;

import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MMT_Mobile_Sumed extends TestBase {

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

    @AndroidFindBy (id = "com.makemytrip:id/iv_lotte_anim")
    MobileElement gotItBtn;

    @AndroidFindBy (id = "com.makemytrip:id/price_filter")
    MobileElement priceFilterBtn;




    public MMT_Mobile_Sumed() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        testBase = new TestBase();
        Logs.INFO("This is constructor - MMT");
    }















}
