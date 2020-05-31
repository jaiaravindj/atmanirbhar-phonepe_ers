package com.pom.pages;

import com.pom.framework.TestBase;
import com.pom.utilities.Logs;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MMT_Mobile_Sumed extends TestBase {

    public MMT_Mobile_Sumed() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Logs.INFO("This is constructor - MMT");
    }



    @AndroidFindBy (id = "com.makemytrip:id/tv_title")
    MobileElement activityTitle;

    @AndroidFindBy (id = "com.makemytrip:id/tv_price_range")
    MobileElement priceRangeTxt;

    @AndroidFindBy (id = "com.makemytrip:id/price_seek_bar")
    MobileElement priceBar;

    @AndroidFindBy (id = "com.makemytrip:id/tv_apply")
    MobileElement applyDoneBtn;

    @AndroidFindBy (id = "com.makemytrip:id/tvHotelName")
    List<MobileElement> hotelNameListTxt;

    @AndroidFindBy (uiAutomator = "new UiScrollable(new UiSelector().resourceId('com.makemytrip:id/tvHotelName').index(4))")
    MobileElement hotelName_5Txt;

    @AndroidFindBy (id = "com.makemytrip:id/iv_lotte_anim")
    MobileElement gotItBtn;

    @AndroidFindBy (id = "com.makemytrip:id/item_price_l_h")
    MobileElement priceFilterBtn;

    @AndroidFindBy (id = "com.makemytrip:id/closeButton")
    MobileElement closeBtn;

    @AndroidFindBy (id = "com.makemytrip:id/sort_filter")
    MobileElement sortFilterBtn;

    @AndroidFindBy (uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\" & Above\"));")
    List<MobileElement> userRatingTxt;

    @AndroidFindAll ( {
            @AndroidBy (id = "com.makemytrip:id/filter_name"),
            @AndroidBy (id = "com.makemytrip:id/suggested_applied_filter_list")
    } )
    List<MobileElement> assertFilterNameTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tv_filter_count")
    MobileElement noOfResultsOnSortFilterTxt;

    @AndroidFindBy (id = "com.makemytrip:id/showing_results")
    MobileElement noOfResultsTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvCustmerRating")
    MobileElement ratingOfHotelTxt;

    @AndroidFindAll ( {
            @AndroidBy (id = "com.makemytrip:id/tv_hotel_name"),
            @AndroidBy (id = "com.makemytrip:id/tvHotelName")
    } )
    MobileElement hotelNameTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tv_rating")
    MobileElement ratingOfHotelOnPDPTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvCalCheckIn")
    MobileElement checkInDateOnPDPTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvCalCheckOut")
    MobileElement checkOutDateOnPDPTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvRoomCountListing")
    MobileElement noOfRoomsSelectedOnPDPTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvAdultCountListing")
    MobileElement noOfGuestsOnPDPTxt;

    @AndroidFindBy (id = "com.makemytrip:id/btnShowAllHotels")
    MobileElement selectRoomContinueBtn;

    @AndroidFindBy (id = "com.makemytrip:id/tv_select_room_text")
    MobileElement selectRoomTitle;

    @AndroidFindBy (id = "com.makemytrip:id/roomTypeName")
    MobileElement roomTypeNameTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvRoomName")
    MobileElement roomTypeOptionTxt;

    @AndroidFindBy (xpath = "//android.widget.LinearLayout[@resource-id='com.makemytrip:id/childAdultCount']/android.widget.TextView")
    List<MobileElement> guestCountOnRoomInfoTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvTariffPrice")
    MobileElement roomTariffTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvRoomPrice")
    MobileElement roomPriceInFooterTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tv_title_ReviewPage")
    MobileElement reviewPageTitle;

    @AndroidFindBy (id = "com.makemytrip:id/tvReviewRoomText")
    MobileElement roomCountOnReviewRoomTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvReviewGuestText")
    MobileElement guestCountOnReviewRoomTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvReviewCheckInDate")
    MobileElement checkInDateOnReviewRoomTxt;

    @AndroidFindBy (id = "com.makemytrip:id/tvReviewCheckoutDate")
    MobileElement checkOutDateOnReviewRoomTxt;

    @AndroidFindBy (id = "com.makemytrip:id/sp_title")
    MobileElement nameTitleSpinner;

    @AndroidFindBy (className = "android.widget.CheckedTextView")
    List<MobileElement> nameTitleListTxt;

    @AndroidFindBy (id = "com.makemytrip:id/etGuestInfoName")
    MobileElement firstNameTxtBx;

    @AndroidFindBy (id = "com.makemytrip:id/etGuestInfoNameLast")
    MobileElement lastNameTxtBx;

    @AndroidFindBy (id = "com.makemytrip:id/etGuestInfoEmail")
    MobileElement emailIdTxtBx;

    @AndroidFindBy (id = "com.makemytrip:id/etGuestInfoPhone")
    MobileElement phoneNoTxtBx;

    @AndroidFindBy (id = "com.makemytrip:id/special_request_container")
    MobileElement specialRequestBtn;

    @AndroidFindBy (id = "com.makemytrip:id/tv_htl_action_bar_review")
    MobileElement specialRequestTitle;

    @AndroidFindBy (id = "com.makemytrip:id/request_name")
    List<MobileElement> requestNameBtnList;

    @AndroidFindBy (id = "com.makemytrip:id/request_checkbox")
    List<MobileElement> requestCheckBxList;

    @AndroidFindBy (id = "com.makemytrip:id/done_btn")
    MobileElement doneOnSpecialRequestBtn;

    @AndroidFindBy (id = "com.makemytrip:id/reqCount")
    MobileElement specialRequestCountTxt;




    public void clickOnGotItBtn() {
        while (isDisplayed(gotItBtn)) {
            click(gotItBtn);
            Logs.INFO("Got It button clicked");
        }
    }

    public void clickOnSortFilterBtn() {
        waitForElement(sortFilterBtn, DEFAULT_TIME);
        click(sortFilterBtn);
        Logs.INFO("Sort & Filter button clicked");
        waitForElement(activityTitle, DEFAULT_TIME);
    }

    public String getActivityTitleText() {
        waitForElement(activityTitle, DEFAULT_TIME);
        String title = getText(activityTitle);
        Logs.INFO("Activity Title - " + title);
        return title;
    }

    public void setPriceRangeFilter(String minAmount) {

        String currentPriceRange = getText(priceRangeTxt);
        Logs.INFO("Initial Price Range is - " + currentPriceRange);
        Logs.INFO("Desired Minimum Price is - " + minAmount);

        int x1 = priceBar.getLocation().getX();
        int y1 = priceBar.getLocation().getY();
        int x2 = priceBar.getSize().width;
        int y2 = y1 + priceBar.getSize().height;
        int midY = (y1 + y2)/2;
        int distance = (4 * x2)/100;
        x1 = x1 + distance;

        while(!currentPriceRange.contains(minAmount)) {
            clickByXY(x1, midY);
            currentPriceRange = getText(priceRangeTxt);
            Logs.INFO("Selected Price Range - " + currentPriceRange);
            if(currentPriceRange.contains(minAmount)) {
                Logs.INFO("Desired Price Range selected");
                break;
            }
            x1 = x1 + distance;
        }
    }

    public void setUserRatingFilter(String userRating) {
        Logs.INFO("Desired User Rating - " + userRating);
        waitForElement(userRatingTxt.get(0), DEFAULT_TIME);
        selectInList(userRatingTxt, userRating);
    }

    public String noOfResultsFilteredOnSortFilter() {
        String noOfResultsFiltered = getText(noOfResultsOnSortFilterTxt);
        Logs.INFO("No. of results filtered on Sort & Filter page - " + noOfResultsFiltered);
        return noOfResultsFiltered;
    }

    public void clickOnApplyBtn() {
        waitForElement(applyDoneBtn, DEFAULT_TIME);
        String button = getText(applyDoneBtn);
        click(applyDoneBtn);
        Logs.INFO( button + " button clicked");
    }

    public boolean assertFilterApplied(String filterName) {
        waitForElement(hotelNameListTxt.get(0), DEFAULT_TIME);
        waitForElement(assertFilterNameTxt.get(0), DEFAULT_TIME);
        return containsInList(assertFilterNameTxt, filterName);
    }

    public String noOfResultsFiltered() {
        String noOfResultsFiltered = getText(noOfResultsTxt);
        Logs.INFO("No. of results filtered - " + noOfResultsFiltered);
        return noOfResultsFiltered;
    }

    public String selectNthHotelInList(int n) throws Exception {

        boolean flag = false;
        int count = 0;
        String hotelName1="1", hotelName2="2";
        waitForElement(hotelNameListTxt.get(0), DEFAULT_TIME);

        while(!flag) {
            Logs.INFO("Hotel Name List Size on current screen - " + hotelNameListTxt.size());
            for(MobileElement element: hotelNameListTxt) {
                hotelName2 = getText(element);
                if(!hotelName1.equals(hotelName2)) {
                    count++;
                    hotelName1 = hotelName2;
                }
                if(count == n) {
                    Logs.INFO(n + "th Hotel in the list is - " + hotelName1);
                    click(element);
                    Logs.INFO(hotelName1 + " is clicked & selected");
                    return hotelName1;
                }
                scrolling();
            }
        }
        return hotelName1;
    }

    public String getHotelName() {
        waitForElement(hotelNameTxt, DEFAULT_TIME);
        String hotelName = getText(hotelNameTxt);
        Logs.INFO("Selected Hotel Name - " + hotelName);
        return hotelName;
    }

    public Double getUserRatingOnPDP() {
        String userRating = getText(ratingOfHotelOnPDPTxt);
        Logs.INFO("User Rating on selected Hotel page - " + userRating);
        return Double.parseDouble(userRating);
    }

    public String getRoomCountOnPDP() {
        String roomCount = getText(noOfRoomsSelectedOnPDPTxt);
        Logs.INFO("No. of Rooms on selected Hotel page - " + roomCount);
        return roomCount;
    }

    public String getGuestCountOnPDP() {
        String guestCount = getText(noOfGuestsOnPDPTxt);
        Logs.INFO("No. of Guests on selected Hotel page - " + guestCount);
        return guestCount;
    }

    public String[] getCheckInCheckOutDateOnPDP() {
        String date[] = new String[2];
        date[0] = getText(checkInDateOnPDPTxt);
        date[1] = getText(checkOutDateOnPDPTxt);
        Logs.INFO("CheckIn Date on selected Hotel page - " + date[0]);
        Logs.INFO("CheckOut Date on selected Hotel page - " + date[1]);
        return date;
    }

    public void clickOnSelectContinueBtn() {
        click(selectRoomContinueBtn);
        Logs.INFO(getText(selectRoomContinueBtn) + " button clicked");
    }

    public String getRoomTypeName() {
        waitForElement(roomTypeNameTxt, DEFAULT_TIME);
        String roomType = getText(roomTypeNameTxt);
        Logs.INFO("Selected Room Type - " + roomType);
        return roomType;
    }

    public String getRoomOptionName() {
        String roomOption = getText(roomTypeOptionTxt);
        Logs.INFO("Selected Room Option - " + roomOption);
        return roomOption;
    }

    public String getRoomPriceOnRoomDetails() {
        String roomPrice = getText(roomTariffTxt);
        Logs.INFO("Room Price on Room Details page - " + roomPrice);
        return roomPrice;
    }

    public String[] getGuestCountOnRoomDetails() {
        String guestCount[] = new String[2];
        guestCount[0] = getText(guestCountOnRoomInfoTxt.get(0));
        guestCount[1] = getText(guestCountOnRoomInfoTxt.get(1));
        Logs.INFO("Guest Count on Room Details page - \t Adult:" + guestCount[0] + "  Children:" + guestCount[1]);
        return guestCount;
    }

    public String getRoomPriceOnFooter() {
        String roomPrice = getText(roomPriceInFooterTxt);
        Logs.INFO("Room Price on Room Details page - " + roomPrice);
        return roomPrice;
    }

    public boolean isSelectRoomTitlePresent() {
        waitForElement(selectRoomTitle, DEFAULT_TIME);
        boolean flag = isDisplayed(selectRoomTitle);
        Logs.INFO("Select Room title present - " + flag);
        return flag;
    }

    public boolean isReviewBookingTitlePresent() {
        waitForElement(reviewPageTitle, DEFAULT_TIME);
        boolean flag = isDisplayed(reviewPageTitle);
        Logs.INFO("Review Booking title present - " + flag);
        return flag;
    }

    public String getRoomCountOnReviewRoom() {
        String roomCount = getText(roomCountOnReviewRoomTxt);
        Logs.INFO("No. of Rooms on Review Booking page - " + roomCount);
        return roomCount;
    }

    public String getGuestCountOnReviewRoom() {
        String guestCount = getText(guestCountOnReviewRoomTxt);
        Logs.INFO("No. of Guests on Review Booking page - " + guestCount);
        return guestCount;
    }

    public String[] getCheckInCheckOutDateOnReviewRoom() {
        String date[] = new String[2];
        date[0] = getText(checkInDateOnReviewRoomTxt);
        date[1] = getText(checkOutDateOnReviewRoomTxt);
        Logs.INFO("CheckIn Date on selected Hotel page - " + date[0]);
        Logs.INFO("CheckOut Date on selected Hotel page - " + date[1]);
        return date;
    }

    public void selectNameTitle(String title) {
        click(nameTitleSpinner);
        waitForElement(nameTitleListTxt.get(1), DEFAULT_TIME);
        selectInList(nameTitleListTxt, title);
        waitForElement(nameTitleSpinner, DEFAULT_TIME);
    }

    public void enterFirstAndLastName(String firstName, String lastName) {
        enterText(firstNameTxtBx, firstName);
        enterText(lastNameTxtBx, lastName);
        Logs.INFO("Entered First Name: " + firstName + " and Last Name:" + lastName);
    }

    public void enterEmailId(String emailId) {
        enterText(emailIdTxtBx, emailId);
        Logs.INFO("Entered Email Id: " + emailId);
    }

    public void enterPhoneNo(String phoneNo) {
        enterText(phoneNoTxtBx, phoneNo);
        Logs.INFO("Entered Phone No.: " + phoneNo);
    }

    public int selectSpecialRequests(String[] specialRequests) {
        int count = 0;
        click(specialRequestBtn);
        Logs.INFO("Special Request button clicked");
        waitForElement(specialRequestTitle, DEFAULT_TIME);
        for(String request: specialRequests) {
            if(selectInList(requestNameBtnList, request)) {
                selectInList(requestNameBtnList, request);
                count++;
            }
        }

        Logs.INFO("No. of Special Requests selected - " + count);
        count = 0;
        for(MobileElement element: requestCheckBxList) {
            Logs.INFO("isChecked - " + Boolean.getBoolean(element.getAttribute("checked")));
            if(Boolean.getBoolean(element.getAttribute("checked")))
                count++;
        }
        Logs.INFO("No. of Special Requests CheckBoxes selected - " + count);

        click(doneOnSpecialRequestBtn);
        Logs.INFO("Done button on Special Requests page clicked");
        isReviewBookingTitlePresent();
        return count;
    }

    public String getSpecialRequestCount() {
        String reqCount = getText(specialRequestCountTxt);
        Logs.INFO("Special Request Count on Review Booking page after selecting - " + reqCount);
        return reqCount;
    }




























}
