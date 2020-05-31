package com.pom.pages;

import java.security.PrivateKey;
import java.util.*;

import com.oracle.tools.packager.Log;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import java.util.List;


public class MMT_Mobile extends TestBase {

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    MobileElement gLoginDismiss;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement mmtEditText;

    @AndroidFindBy(id = "com.makemytrip:id/btn_continue")
    MobileElement mmtLoginContinueButton;

    @AndroidFindBy(id = "com.makemytrip:id/pwd_option")
    MobileElement mmtLoginViaPasswordButton;

    @AndroidFindBy(id = "com.makemytrip:id/universal_search")
    MobileElement mmtUniversalSearchLayout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.makemytrip:id/title' and @text='Hotels']")
    MobileElement mmtHotelsText;

    @AndroidFindBy(id = "com.makemytrip:id/city")
    MobileElement mmtCityEditText;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[@index=0]/android.widget.TextView")
    MobileElement mmtCityListItem;

    @AndroidFindBy(id = "com.makemytrip:id/checkIn_layout")
    MobileElement mmtCheckInLayout;

    @AndroidFindBy(id = "com.makemytrip:id/checkOut_layout")
    MobileElement mmtCheckOutLayout;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInDate")
    MobileElement mmtCheckinDate;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInMonth")
    MobileElement mmtCheckinMonth;

    @AndroidFindBy(id = "com.makemytrip:id/search_button")
    MobileElement mmtSearchButton;

    @AndroidFindBy(id = "com.makemytrip:id/guest_layout")
    MobileElement mmtGuestLayout;

    @AndroidFindBy(id = "com.makemytrip:id/tvadultcount")
    MobileElement mmtAdultCount;

    @AndroidFindBy(id = "com.makemytrip:id/ivadultadd")
    MobileElement mmtAdultCountAdd;

    @AndroidFindBy(id = "com.makemytrip:id/ivadultsubtract")
    MobileElement mmtAdultCountSubtract;

    @AndroidFindBy(id = "com.makemytrip:id/tvchildcount")
    MobileElement mmtChildCount;

    @AndroidFindBy(id = "com.makemytrip:id/ivchildadd")
    MobileElement mmtChildCountAdd;

    @AndroidFindBy(id = "com.makemytrip:id/ivchildsubtract")
    MobileElement mmtChildCountSubtract;

    @AndroidFindBy(id = "com.makemytrip:id/btn_add_room")
    MobileElement mmtAddRoom;

    @AndroidFindBy(id = "com.makemytrip:id/btn_done")
    MobileElement mmtDoneButton;

    @AndroidFindBy(id = "com.makemytrip:id/removeRoom_expanded")
    MobileElement mmtRoomRemove;

    @AndroidFindBy(id = "com.makemytrip:id/removeRoom_collapsed")
    List<MobileElement> mmtRoomRemoveList;

    @AndroidFindBy(id = "com.makemytrip:id/cbAddOn")
    MobileElement mmtDonationCheckBox;

    @AndroidFindBy(id = "com.makemytrip:id/btnShowAllHotels")
    MobileElement mmtHotelsContinueButton;

    @AndroidFindBy(id = "com.makemytrip:id/rl_bnpl_option")
    MobileElement mmtHotelsBnplPaymentOption;

    @AndroidFindBy(id = "com.makemytrip:id/rb_pay_in_full")
    MobileElement mmtHotelsFullPaymentOption;

    @AndroidFindBy(id = "com.makemytrip:id/tv_proceed_payment")
    MobileElement mmtHotelsProceedPayment;

    @AndroidFindBy(id = "com.makemytrip:id/ivDetailExpandOnThankYouPage")
    MobileElement mmtHotelsThankYouPageDetailsExpand;

    @AndroidFindBy(id = "com.makemytrip:id/tvHotelNameOnThankYouPage")
    MobileElement mmtHotelsThankYouPageHotelName;

    @AndroidFindBy(id = "com.makemytrip:id/tvHotelAddressOnThankYouPage")
    MobileElement mmtHotelsThankYouPageLocation;

    @AndroidFindBy(id = "com.makemytrip:id/tvReviewCheckInOnThankYouPage")
    MobileElement mmtHotelsThankYouPageCheckIn;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckOutOnThankYouPage")
    MobileElement mmtHotelsThankYouPageCheckOut;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInDateOnThankYouPage")
    MobileElement mmtHotelsThankYouPageCheckInDate;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckOutDateOnThankYouPage")
    MobileElement mmtHotelsThankYouPageCheckOutDate;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInTimeOnThankYouPage")
    MobileElement mmtHotelsThankYouPageCheckInTime;

    @AndroidFindBy(id = "com.makemytrip:id/tvCheckOutTimeOnThankYouPage")
    MobileElement mmtHotelsThankYouPageCheckOutTime;

    @AndroidFindBy(id = "com.makemytrip:id/tvTotalRoomsBookedOnThankYouPage")
    MobileElement mmtHotelsThankYouPageRoomcount;

    @AndroidFindBy(id = "com.makemytrip:id/tvNumOfGuestOnThankYouPage")
    MobileElement mmtHotelsThankYouPageGuestcount;

    @AndroidFindBy(id = "com.makemytrip:id/rv_bottom_bar")
    MobileElement homePageBottomBar;

    @AndroidFindBy(id = "com.makemytrip:id/room_count")
    MobileElement hotelsRoomCount;


    public MMT_Mobile() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Logs.INFO("This is constructor - MMT");
    }


    public void dismissGLoginPopup() {
        if (!testbase.isDisplayed(mmtLoginContinueButton))
            return;
        waitForElement(gLoginDismiss, DEFAULT_TIME);
        click(gLoginDismiss);
    }

    public void enterLoginEmail(String testEmail) {
        waitForElement(mmtEditText, DEFAULT_TIME);
        enterText(mmtEditText, testEmail);
        Logs.INFO("Email entered for Login");
    }

    public void enterPassword(String password) {
        waitForElement(mmtLoginViaPasswordButton, DEFAULT_TIME);
        click(mmtLoginViaPasswordButton);
        waitForElement(mmtEditText, DEFAULT_TIME);
        enterText(mmtEditText, password);
        Logs.INFO("Password entered for Login");
    }

    public void clickContinueButton() {
        waitForElement(mmtLoginContinueButton, DEFAULT_TIME);
        click(mmtLoginContinueButton);
        Logs.INFO(getText(mmtLoginContinueButton) + " button clicked");
    }

    public void goToHotelsSectino() {
        waitForElement(mmtHotelsText, DEFAULT_TIME);
        click(mmtHotelsText);
        Logs.INFO("Password entered for Login");
    }

    public void selectCity(String cityName) {
        waitForElement(mmtCityEditText, DEFAULT_TIME);
        click(mmtCityEditText);
        enterText(mmtEditText, cityName);
        waitForElement(mmtCityListItem, DEFAULT_TIME);
        click(mmtCityListItem);
        waitForElement(mmtGuestLayout, DEFAULT_TIME);
    }

    public String getSelectedCityName() {
        waitForElement(mmtCityEditText, DEFAULT_TIME);
        Log.info("City is selected" + mmtCityEditText.getText());
        return getText(mmtCityEditText);
    }

    public void goToGuestPage() {
        waitForElement(mmtGuestLayout, DEFAULT_TIME);
        click(mmtGuestLayout);
        Log.info("User in Guest Page");
    }

    public void removeExistingGuest() {
        waitForElement(mmtAdultCount, DEFAULT_TIME);

        if (mmtRoomRemoveList.size() > 1)
            for (MobileElement removeBtn : mmtRoomRemoveList)
                if (isDisplayed(removeBtn)) {
                    click(removeBtn);
                    Log.info("Removed existing guest details");
                }

    }

    public void setAduldGuest(int noAdultGuests) {
        waitForElement(mmtAdultCount, DEFAULT_TIME);
        setPassengerCount(mmtAdultCount, mmtAdultCountAdd, mmtAdultCountSubtract, noAdultGuests);
        Log.info("Added Adult Guests");
    }

    public void setChildGuest(int childGuests){
        waitForElement(mmtChildCount, DEFAULT_TIME);
        setPassengerCount(mmtChildCount, mmtChildCountAdd, mmtChildCountSubtract, childGuests);
        Log.info("Added Child Guests");
    }

    public void addRoom() {
        waitForElement(mmtAddRoom,DEFAULT_TIME);
        click(mmtAddRoom);
        Log.info("Added Extra Rooms");
    }

    public void clickDoneButton(){
        waitForElement(mmtDoneButton,DEFAULT_TIME);
        click(mmtDoneButton);
        Log.info("Done button is clicked");
    }

    public void clickSearchButton() {
        waitForElement(mmtSearchButton, 5);
        click(mmtSearchButton);
        Log.info("Search button is clicked");
    }

    public String getGuestCount() {
        waitForElement(mmtGuestLayout,DEFAULT_TIME);
        return getText(mmtGuestLayout);
    }

    public String getRoomCount() {
        waitForElement(hotelsRoomCount,DEFAULT_TIME);
        return getText(hotelsRoomCount);
    }


    // Will Add or Subtract guests count according to required number.
    private void setPassengerCount(MobileElement locatorCount, MobileElement locatorAdd, MobileElement locatorSubtract, int totalPassenger) {
        int adultCount = Integer.parseInt(getText(locatorCount));
        if (adultCount > totalPassenger) {
            for (int i = 0; i < adultCount - totalPassenger; i++) {
                click(locatorSubtract);
                adultCount = Integer.parseInt(getText(locatorCount));
            }
        } else if (adultCount < totalPassenger) {
            for (; adultCount <= totalPassenger; adultCount++) {
                click(locatorAdd);
                adultCount = Integer.parseInt(getText(locatorCount));
            }
        }
    }

    public void MMT_Payment() {
        waitForElement(mmtDonationCheckBox, 5);
        if (isChecked(mmtDonationCheckBox))
            click(mmtDonationCheckBox);
        click(mmtHotelsContinueButton);
        if (isDisplayed(mmtHotelsBnplPaymentOption))
            click(mmtHotelsFullPaymentOption);
        click(mmtHotelsProceedPayment);
        click(mmtHotelsThankYouPageDetailsExpand);
    }

    public void MMT_ThankYouPage_Assertions(String hotelName, String location) {
        Assertion asserts = new Assertion();
        asserts.assertEquals(hotelName, mmtHotelsThankYouPageHotelName.getText());
        asserts.assertEquals(location, mmtHotelsThankYouPageLocation.getText());
    }

    public void checkIfOnHomeScreen() {
        waitForElement(homePageBottomBar, DEFAULT_TIME);
        Logs.INFO("User in Home Page");
    }
}
