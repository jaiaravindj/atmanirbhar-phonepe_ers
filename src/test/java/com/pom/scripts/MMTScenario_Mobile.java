package com.pom.scripts;

import com.pom.utilities.HeadSpinHelper;
import com.pom.pages.MMT_Mobile_LoginAndSearch;
import com.pom.pages.MMT_Mobile_BookingFlow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pom.framework.TestBase;
import com.pom.utilities.Logs;

@Listeners(com.pom.utilities.TestListener.class)
public class MMTScenario_Mobile extends TestBase {
	HeadSpinHelper headSpinHelper;
	
	SoftAssert softAssert;
	MMT_Mobile_LoginAndSearch mmt1;
	MMT_Mobile_BookingFlow mmt2;
	
	@Parameters({"osType"})
	@BeforeMethod
	public void setUp(@Optional ("android") String osType) throws Exception {
		headSpinHelper = new HeadSpinHelper();
		invokeDriver(osType);
		softAssert = new SoftAssert();
		mmt1 = new MMT_Mobile_LoginAndSearch();
		mmt2 = new MMT_Mobile_BookingFlow();
	}
	

	@Test
	public void mmtScriptAppium() throws Exception {

		Logs.INFO("LOGIN TO THE APP");
		mmt1.dismissGLoginPopup();
		mmt1.clickLoginSkipButtonp();
//		mmt1.clickMenuDrawer();
//		mmt1.clickLoginSignUpBtn();

//		mmt1.enterLoginEmail(readProp("username"));
//		mmt1.clickContinueButton();
//		mmt1.enterPassword(readProp("password"));
//		mmt1.clickContinueButton();
		mmt1.checkIfOnHomeScreen();

		Logs.INFO("SEARCH HOTEL FOR GIVEN PARAMETERS");
		mmt1.goToHotelsSection();
		mmt1.selectCity(readProp("cityName"));
		softAssert.assertTrue(mmt1.getSelectedCityName().contains(readProp("cityNameFull")),
				"User selected city "+readProp("cityNameFull"));

		mmt1.goToGuestPage();
		mmt1.removeExistingGuest();

		Logs.INFO("SELECT 2 ROOMS WITH 2 ADULTS & 2 CHILDREN EACH");
		mmt1.setAdultGuest(2);
		mmt1.setChildGuest(2);
		mmt1.addRoom();
		mmt1.setAdultGuest(2);
		mmt1.setChildGuest(2);

		mmt1.clickDoneButton();
		softAssert.assertTrue(mmt1.getGuestCount().contains(readProp("totalGuests")),
				"Number Of Guests on Guest Layout - "+readProp("totalGuests"));
		softAssert.assertTrue(mmt1.getRoomCount().contains(readProp("noOfRooms")),
				"Number Of Rooms on Guest Layout - "+readProp("noOfRooms"));
		String[] checkInOutDate = mmt1.getCheckInCheckOutDate();

		mmt1.selectTripType(readProp("tripType"));
		mmt1.clickSearchButton();

		mmt2.clickOnGotItBtn();

		Logs.INFO("SORT & FILTER");
		mmt2.clickOnSortFilterBtn();
		softAssert.assertTrue(mmt2.getActivityTitleText().contains(readProp("sortAndFilter")), "User on Sort & Filter page");
		mmt2.setPriceRangeFilter(readProp("minPriceRange"));
		mmt2.setUserRatingFilter(readProp("userRating"));
		String noOfResults = mmt2.noOfResultsFilteredOnSortFilter()
				.replaceAll(" of.*", "").replaceAll("Showing", "").trim();
		mmt2.clickOnApplyBtn();
		softAssert.assertTrue(mmt2.assertFilterApplied(readProp("minPriceRange").replace(",", "")),
				"Minimum Price Range is "+readProp("minPriceRange"));
		softAssert.assertTrue(mmt2.assertFilterApplied(readProp("userRating")),
				"User Rating bracket selected is "+readProp("userRating"));

		Logs.INFO("SELECT 5TH HOTEL IN FILTERED LIST");
		softAssert.assertTrue(Integer.parseInt(noOfResults) > Integer.parseInt(readProp("nthHotel")),
				"The filtered hotel list count is less than 5");
		String selectedHotelName = mmt2.selectNthHotelInList(Integer.parseInt(readProp("nthHotel")));

		Logs.INFO("ON HOTEL DETAILS PAGE");
		softAssert.assertEquals(mmt2.getHotelName(), selectedHotelName, "Hotel Name mismatch on hotel details page");
		softAssert.assertTrue(mmt2.getUserRatingOnPDP() >= Double.parseDouble(readProp("userRating")),
				"User Rating of selected Hotel is below "+readProp("userRating"));
		softAssert.assertTrue(mmt2.getRoomCountOnPDP().contains(readProp("noOfRooms")), "No. of Rooms mismatch on hotel details page");
		softAssert.assertTrue(mmt2.getGuestCountOnPDP().contains(readProp("totalGuests")), "No. of Guests mismatch on hotel details page");
		String[] dateonPDP = mmt2.getCheckInCheckOutDateOnPDP();
		softAssert.assertTrue(checkInOutDate[0].contains(dateonPDP[0]) && checkInOutDate[1].contains(dateonPDP[1]),
				"Check In - Check Out Date mismatch on hotel details page");

		mmt2.clickOnSelectContinueBtn();
		softAssert.assertTrue(mmt2.isSelectRoomTitlePresent(), "Select Room page title not visible");
		softAssert.assertEquals(selectedHotelName, mmt2.getHotelName(), "Hotel Name mismatch on Select Room page");

		Logs.INFO("ON SELECT ROOM PAGE");
		String roomType = mmt2.getRoomTypeName();
		String roomOptionName = mmt2.getRoomOptionName();
		String[] guestCount = mmt2.getGuestCountOnRoomDetails();
		String roomPrice = mmt2.getRoomPriceOnRoomDetails();
		softAssert.assertEquals(roomPrice, mmt2.getRoomPriceOnFooter(), "Room Price mismatch on room details page");
		mmt2.clickOnSelectContinueBtn();
		softAssert.assertTrue(mmt2.isReviewBookingTitlePresent(), "Review Booking title not visible");

		Logs.INFO("ON REVIEW BOOKING PAGE");
		softAssert.assertEquals(selectedHotelName, mmt2.getHotelName(), "Hotel Name mismatch on Review Booking page");
		softAssert.assertTrue(mmt2.getRoomCountOnReviewRoom().contains(readProp("noOfRooms")),
				"No. of Rooms mismatch on Review Booking page");
		softAssert.assertTrue(mmt2.getGuestCountOnReviewRoom().contains(readProp("totalGuests")),
				"No. of Guests omismatch on Review Booking page");
		String[] dateOnReviewRoom = mmt2.getCheckInCheckOutDateOnReviewRoom();
		softAssert.assertTrue(dateOnReviewRoom[0].contains(dateonPDP[0]) && dateOnReviewRoom[1].contains(dateonPDP[1]),
				"Check In - Check Out Date mismatch on Review Booking page");

		Logs.INFO("ENTER PRIMARY GUEST DETAILS");
		mmt2.selectNameTitle(readProp("title"));
		mmt2.enterFirstAndLastName(readProp("firstName"), readProp("lastName"));
		mmt2.enterEmailId(readProp("emailId"));
		mmt2.enterPhoneNo(readProp("phoneNo"));

		Logs.INFO("SELECT 2 SPECIAL REQUESTS");
		String[] specialRequests = { readProp("smokingRoom"), readProp("largeBed") };
		int noOfRequests = mmt2.selectSpecialRequests(specialRequests);
		softAssert.assertEquals(noOfRequests, specialRequests.length, "No. of Special Requests selected mismatch");
		softAssert.assertTrue(mmt2.getSpecialRequestCount().contains(String.valueOf(specialRequests.length)),
				"No. of Special Requests selected mismatch on Review Booking page");

		Logs.INFO("ON SELECT PAYMENT MODE PAGE");
		mmt2.MMT_Payment();
		softAssert.assertTrue(mmt2.getHotelNameOnThankYouPage().contains(selectedHotelName), "Hotel Name mismatch on ThankYou Page");
		softAssert.assertTrue(mmt2.getHotelAddressOnThankYouPage().contains(readProp("cityName")), "City Name mismatch on ThankYou Page");
		softAssert.assertTrue(mmt2.getGuestCountOnThankYouPage().contains(String.valueOf(Integer.parseInt(guestCount[0]) + Integer.parseInt(guestCount[1]))),
				"Guest Count mismatch on ThankYou Page");
		softAssert.assertTrue(mmt2.getRoomCountOnThanksYouPage().contains(readProp("noOfRooms")), "Room Count mismatch on ThankYou Page");
		String[] dateOnThankYou = mmt2.getCheckInCheckOutDateOnThankYouPage();
		softAssert.assertTrue(dateOnReviewRoom[0].contains(dateOnThankYou[0]) && dateOnReviewRoom[1].contains(dateOnThankYou[1]),
				"Check In - Check Out Date mismatch on ThankYou page");

		softAssert.assertAll();
		endOfScript();
	}
	
	
	@AfterMethod
	public void tearDown() {

		Logs.INFO("***** Quitting Driver *****");
		driver.quit();
	}

}
