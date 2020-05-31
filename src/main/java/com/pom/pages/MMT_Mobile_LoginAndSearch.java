package com.pom.pages;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileElement;
import java.util.List;


public class MMT_Mobile_LoginAndSearch extends TestBase {


    public MMT_Mobile_LoginAndSearch() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Logs.INFO("This is constructor - MMT");
    }



    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    MobileElement gLoginDismiss;

    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement mmtEditText;

    @AndroidFindBy(id = "com.makemytrip:id/drawer")
    MobileElement menuDrawerBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.makemytrip:id/tv_title\").text(\"Login/Sign-up now\")")
    MobileElement loginDrawerBtn;

    @AndroidFindAll ( {
            @AndroidBy(id = "com.makemytrip:id/btn_continue"),
            @AndroidBy(id = "com.makemytrip:id/btn_submit")
    } )
    MobileElement mmtLoginContinueButton;

    @AndroidFindBy(id = "com.makemytrip:id/pwd_option")
    MobileElement mmtLoginViaPasswordButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.makemytrip:id/title' and @text='Hotels']")
    MobileElement mmtHotelsText;

    @AndroidFindBy(id = "com.makemytrip:id/city")
    MobileElement mmtCityEditText;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[@index=0]/android.widget.TextView")
    MobileElement mmtCityListItem;

    @AndroidFindBy(id = "com.makemytrip:id/checkInWeek")
    MobileElement mmtCheckInWeek;

    @AndroidFindBy(id = "com.makemytrip:id/checkInDate")
    MobileElement mmtCheckInDate;

    @AndroidFindBy(id = "com.makemytrip:id/checkInMonthYear")
    MobileElement mmtCheckInMonth;

    @AndroidFindBy(id = "com.makemytrip:id/checkOutWeek")
    MobileElement mmtCheckOutWeek;

    @AndroidFindBy(id = "com.makemytrip:id/checkOutDate")
    MobileElement mmtCheckOutDate;

    @AndroidFindBy(id = "com.makemytrip:id/checkOutMonthYear")
    MobileElement mmtCheckOutMonth;

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

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"ROOM 1\"));")
    MobileElement room1Txt;

    @AndroidFindBy(id = "com.makemytrip:id/removeRoom_collapsed")
    List<MobileElement> mmtRoomRemoveList;

    @AndroidFindBy(id = "com.makemytrip:id/rb_travel_type_family")
    MobileElement familyTripTypeCheckBx;

    @AndroidFindBy(id = "com.makemytrip:id/rb_travel_type_business")
    MobileElement businessTripTypeCheckBx;

    @AndroidFindBy(id = "com.makemytrip:id/rb_travel_type_leisure")
    MobileElement romanticTripType;

    @AndroidFindBy(id = "com.makemytrip:id/room_count")
    MobileElement hotelsRoomCount;

    @AndroidFindBy(id = "com.makemytrip:id/guest_count")
    MobileElement hotelsGuestCount;

    @AndroidFindBy(id = "com.makemytrip:id/rv_bottom_bar")
    MobileElement homePageBottomBar;



    public void dismissGLoginPopup() {
        if (!isDisplayed(mmtLoginContinueButton))
            return;
        waitForElement(gLoginDismiss, DEFAULT_TIME);
        click(gLoginDismiss);
    }

    public void clickMenuDrawer() {
        waitForElement(menuDrawerBtn, DEFAULT_TIME);
        click(menuDrawerBtn);
        Logs.INFO("Menu buttn clicked");
    }

    public void clickLoginSignUpBtn() {
        waitForElement(loginDrawerBtn, DEFAULT_TIME);
        click(loginDrawerBtn);
        Logs.INFO("Login/Sign-up now button clicked");
    }

    public void enterLoginEmail(String testEmail) {
        waitForElement(mmtEditText, DEFAULT_TIME);
        enterText(mmtEditText, testEmail);
        Logs.INFO("Email entered for Login - " + testEmail);
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

    public void goToHotelsSection() {
        waitForElement(mmtHotelsText, DEFAULT_TIME);
        click(mmtHotelsText);
        Logs.INFO("Hotels button clicked");
    }

    public void selectCity(String cityName) {
        waitForElement(mmtCityEditText, DEFAULT_TIME);
        click(mmtCityEditText);
        enterText(mmtEditText, cityName);
        waitForElement(mmtCityListItem, DEFAULT_TIME);
        click(mmtCityListItem);
        waitForElement(mmtGuestLayout, DEFAULT_TIME);
        Logs.INFO("Selected City - " + cityName);
    }

    public String getSelectedCityName() {
        waitForElement(mmtCityEditText, DEFAULT_TIME);
        Logs.INFO("City is selected" + mmtCityEditText.getText());
        return getText(mmtCityEditText);
    }

    public void goToGuestPage() {
        waitForElement(mmtGuestLayout, DEFAULT_TIME);
        click(mmtGuestLayout);
        Logs.INFO("User in Guest Page");
    }

    public void removeExistingGuest() {

        scrollingUp();
        waitForElement(room1Txt, DEFAULT_TIME);
        Logs.INFO("No of Rooms pre-selected - " + mmtRoomRemoveList.size());
        if (mmtRoomRemoveList.size() > 0)
            for (MobileElement removeBtn : mmtRoomRemoveList)
                if (isDisplayed(removeBtn)) {
                    click(removeBtn);
                    Logs.INFO("Removed pre-selected guest details");
                    waitForElement(room1Txt, DEFAULT_TIME);
                }

    }

    public void setAdultGuest(int noAdultGuests) {
        waitForElement(mmtAdultCount, DEFAULT_TIME);
        setPassengerCount(mmtAdultCount, mmtAdultCountAdd, mmtAdultCountSubtract, noAdultGuests);
        Logs.INFO("Added Adult Guests - " + noAdultGuests);
    }

    public void setChildGuest(int childGuests){
        waitForElement(mmtChildCount, DEFAULT_TIME);
        setPassengerCount(mmtChildCount, mmtChildCountAdd, mmtChildCountSubtract, childGuests);
        Logs.INFO("Added Child Guests - " + childGuests);
    }

    public void addRoom() {
        waitForElement(mmtAddRoom, DEFAULT_TIME);
        click(mmtAddRoom);
        Logs.INFO("Add Another Room button clicked");
    }

    public String[] getCheckInCheckOutDate() {
        String[] date = new String[2];
        date[0] = getText(mmtCheckInDate) + " " + getText(mmtCheckInMonth) + " " + getText(mmtCheckInWeek);
        Logs.INFO("Check In Date on Guest Layout - " + date[0]);
        date[1] = getText(mmtCheckOutDate) + " " + getText(mmtCheckOutMonth) + " " + getText(mmtCheckOutWeek);
        Logs.INFO("Check Out Date on Guest Layout - " + date[1]);
        return date;
    }

    public void clickDoneButton(){
        waitForElement(mmtDoneButton, DEFAULT_TIME);
        click(mmtDoneButton);
        Logs.INFO("Done button clicked");
    }

    public void selectTripType(String tripType) {
        waitForElement(mmtSearchButton, DEFAULT_TIME);
        switch (tripType) {
            case "Business": click(businessTripTypeCheckBx);    break;
            case "Family": click(familyTripTypeCheckBx);    break;
            case "Romantic": click(romanticTripType);   break;
            default: Logs.ERROR("Invalid Trip Type");
        }
        Logs.INFO(tripType + " Trip Type selected");
    }

    public void clickSearchButton() {
        waitForElement(mmtSearchButton, 5);
        click(mmtSearchButton);
        Logs.INFO("Search button clicked");
    }

    public String getGuestCount() {
        waitForElement(hotelsGuestCount, DEFAULT_TIME);
        String guestCount = getText(hotelsGuestCount);
        Logs.INFO("Guest Count on Guest Layout - " + guestCount);
        return guestCount;
    }

    public String getRoomCount() {
        waitForElement(hotelsRoomCount, DEFAULT_TIME);
        String roomCount = getText(hotelsRoomCount);
        Logs.INFO("Room Count on Guest Layout - " + roomCount);
        return roomCount;
    }

    /* Will Add or Subtract guests count according to required number */
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

    public void checkIfOnHomeScreen() {
        waitForElement(homePageBottomBar, DEFAULT_TIME);
        Logs.INFO("User in Home Page");
    }


}
