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
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInDate")
    private MobileElement mmtCheckinDate;
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInMonth")
    private MobileElement mmtCheckinMonth;
    @AndroidFindBy(id = "com.makemytrip:id/search_button")
    private MobileElement mmtSearchButton;
    @AndroidFindBy(id = "com.makemytrip:id/guest_layout")
    private MobileElement mmtGuestLayout;
    @AndroidFindBy(id = "com.makemytrip:id/tvadultcount")
    private MobileElement mmtAdultCount;
    @AndroidFindBy(id = "com.makemytrip:id/ivadultadd")
    private MobileElement mmtAdultCountAdd;
    @AndroidFindBy(id = "com.makemytrip:id/ivadultsubtract")
    private MobileElement mmtAdultCountSubtract;
    @AndroidFindBy(id = "com.makemytrip:id/tvchildcount")
    private MobileElement mmtChildCount;
    @AndroidFindBy(id = "com.makemytrip:id/ivchildadd")
    private MobileElement mmtChildCountAdd;
    @AndroidFindBy(id = "com.makemytrip:id/ivchildsubtract")
    private MobileElement mmtChildCountSubtract;
    @AndroidFindBy(id = "com.makemytrip:id/btn_add_room")
    private MobileElement mmtAddRoom;
    @AndroidFindBy(id = "com.makemytrip:id/btn_done")
    private MobileElement mmtDoneButton;


    public MMT_Mobile() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Logs.INFO("This is constructor - MMT");
    }

    public void MMT_Login() {
        if (!testbase.isDisplayed(mmtLoginContinueButton))
            return;
        waitForElement(gLoginDismiss, 3);
        click(gLoginDismiss);

        enterText(mmtEditText, testEmail);
        click(mmtLoginContinueButton);

        click(mmtLoginViaPasswordButton);
        enterText(mmtEditText, password);
        click(mmtLoginContinueButton);
        waitForElement(mmtUniversalSearchLayout, 3);
    }

    public void MMT_Hotels_Select_City(String cityName) {
        waitForElement(mmtHotelsText, 5);
        click(mmtHotelsText);
        waitForElement(mmtCityEditText, 5);
        click(mmtCityEditText);
        enterText(mmtEditText, cityName);
        click(mmtCityList);
        waitForElement(mmtGuestLayout, 5);

    }

    public void MMT_Add_Guests(int noAdultGuests, int childGuests){
        click(mmtGuestLayout);

        waitForElement(mmtAdultCount, 5);
        setPassengerCount(mmtAdultCount,mmtAdultCountAdd,mmtAdultCountSubtract,noAdultGuests);
        setPassengerCount(mmtChildCount,mmtChildCountAdd,mmtChildCountSubtract,childGuests);

        click(mmtAddRoom);
        waitForElement(mmtAdultCount, 5);
        setPassengerCount(mmtAdultCount,mmtAdultCountAdd,mmtAdultCountSubtract,noAdultGuests);
        setPassengerCount(mmtChildCount,mmtChildCountAdd,mmtChildCountSubtract,childGuests);
        click(mmtDoneButton);

        waitForElement(mmtSearchButton, 5);
        click(mmtSearchButton);
    }


    // Will Add or Subtract guests count according to required number.
    private void setPassengerCount(MobileElement locatorCount,MobileElement locatorAdd,MobileElement locatorSubtract,int totalPassenger) {
        int adultCount = Integer.parseInt(getText(locatorCount));
        if (adultCount > totalPassenger) {
            for (int i = 0; i < adultCount - totalPassenger; i++) {
                click(locatorSubtract);
                adultCount = Integer.parseInt(getText(locatorCount));
            }
        } else if(adultCount < totalPassenger) {
            for (; adultCount < totalPassenger; adultCount++) {
                click(locatorAdd);
                adultCount = Integer.parseInt(getText(locatorCount));
            }
        }
    }
}
