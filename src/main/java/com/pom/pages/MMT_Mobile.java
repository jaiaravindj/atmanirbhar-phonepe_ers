package com.pom.pages;

import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import java.util.List;


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
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[@index=0]/android.widget.TextView")
    private MobileElement mmtCityListItem;
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
    @AndroidFindBy(id = "com.makemytrip:id/removeRoom_expanded")
    private MobileElement mmtRoomRemove;
    @AndroidFindBy(id = "com.makemytrip:id/removeRoom_collapsed")
    private List<MobileElement> mmtRoomRemoveList;

    @AndroidFindBy(id = "com.makemytrip:id/cbAddOn")
    private MobileElement mmtDonationCheckBox;
    @AndroidFindBy(id = "com.makemytrip:id/btnShowAllHotels")
    private MobileElement mmtHotelsContinueButton;
    @AndroidFindBy(id = "com.makemytrip:id/rl_bnpl_option")
    private MobileElement mmtHotelsBnplPaymentOption;
    @AndroidFindBy(id = "com.makemytrip:id/rb_pay_in_full")
    private MobileElement mmtHotelsFullPaymentOption;
    @AndroidFindBy(id = "com.makemytrip:id/tv_proceed_payment")
    private MobileElement mmtHotelsProceedPayment;
    @AndroidFindBy(id = "com.makemytrip:id/ivDetailExpandOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageDetailsExpand;
    @AndroidFindBy(id = "com.makemytrip:id/tvHotelNameOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageHotelName;
    @AndroidFindBy(id = "com.makemytrip:id/tvHotelAddressOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageLocation;
    @AndroidFindBy(id = "com.makemytrip:id/tvReviewCheckInOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageCheckIn;
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckOutOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageCheckOut;
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInDateOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageCheckInDate;
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckOutDateOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageCheckOutDate;
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckInTimeOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageCheckInTime;
    @AndroidFindBy(id = "com.makemytrip:id/tvCheckOutTimeOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageCheckOutTime;
    @AndroidFindBy(id = "com.makemytrip:id/tvTotalRoomsBookedOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageRoomcount;
    @AndroidFindBy(id = "com.makemytrip:id/tvNumOfGuestOnThankYouPage")
    private MobileElement mmtHotelsThankYouPageGuestcount;


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
        waitForElement(mmtCityListItem,5);
        click(mmtCityListItem);
        waitForElement(mmtGuestLayout, 5);

    }

    public void MMT_Add_Guests(int noAdultGuests, int childGuests){
        click(mmtGuestLayout);
        waitForElement(mmtAdultCount, 5);

        if(mmtRoomRemoveList.size() > 1)
            for(MobileElement removeBtn :mmtRoomRemoveList)
                if(isDisplayed(removeBtn))
                    click(removeBtn);

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
            for (; adultCount <= totalPassenger; adultCount++) {
                click(locatorAdd);
                adultCount = Integer.parseInt(getText(locatorCount));
            }
        }
    }

    public void MMT_Payment() {
        waitForElement(mmtDonationCheckBox,5);
        if(isChecked(mmtDonationCheckBox))
            click(mmtDonationCheckBox);
        click(mmtHotelsContinueButton);
        if(isDisplayed(mmtHotelsBnplPaymentOption))
            click(mmtHotelsFullPaymentOption);
        click(mmtHotelsProceedPayment);
        click(mmtHotelsThankYouPageDetailsExpand);
    }

    public void MMT_ThankYouPage_Assertions(String hotelName,String location){
        Assertion asserts = new Assertion();
        asserts.assertEquals(hotelName,mmtHotelsThankYouPageHotelName.getText());
        asserts.assertEquals(location,mmtHotelsThankYouPageLocation.getText());
    }
}
