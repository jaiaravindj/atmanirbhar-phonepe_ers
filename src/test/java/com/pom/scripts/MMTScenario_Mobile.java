package com.pom.scripts;


import com.pom.pages.MMT_Mobile;
import com.pom.pages.MMT_Mobile_Sumed;
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
	
	
	SoftAssert softAssert;
	MMT_Mobile mmt;
	MMT_Mobile_Sumed mmt2;
	
	@Parameters({"osType"})
	@BeforeMethod
	public void setUp(@Optional ("android") String osType) throws Exception {
		
		invokeDriver(osType);
		softAssert = new SoftAssert();
		mmt = new MMT_Mobile();
		mmt2 = new MMT_Mobile_Sumed();
	}
	

	@Test
	public void mmtScriptAppium() throws Exception {

		// start script
		Logs.INFO("Login into the App");
		mmt.dismissGLoginPopup();

//		mmt.enterLoginEmail("atmanirbhar.phonep.ers@gmail.com");
//		mmt.clickContinueButton();
//		mmt.enterPassword("Sumed@Jai123");
//		mmt.clickContinueButton();
		mmt.checkIfOnHomeScreen();

		mmt.goToHotelsSectino();
		mmt.selectCity("Delhi");
		softAssert.assertTrue(mmt.getSelectedCityName().contains(readProp("cityNameFull")), "User selected city Delhi, India");

		mmt.goToGuestPage();
		mmt.removeExistingGuest();

		mmt.setAduldGuest(2);
		mmt.setChildGuest(2);

		mmt.addRoom();

		mmt.setAduldGuest(2);
		mmt.setChildGuest(2);

		mmt.clickDoneButton();
		softAssert.assertTrue(mmt.getGuestCount().contains(readProp("totalGuests")), "Number Of Guests - 08");
		softAssert.assertTrue(mmt.getRoomCount().contains(readProp("totalGuests")), "Number Of Guests - 08");
		mmt.clickSearchButton();

		mmt2.clickOnGotItBtn();

		Logs.INFO("SORT & FILTER ...");
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
		softAssert.assertTrue(mmt2.getGuestCountOnPDP().contains(readProp("totalGuests")), "No. of Guests omismatch on hotel details page");
		// ASSERT DATE

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
		// assert date

		Logs.INFO("ENTER PRIMARY GUEST DETAILS");
		mmt2.selectNameTitle(readProp("title"));
		mmt2.enterFirstAndLastName(readProp("firstName"), readProp("lastName"));
		mmt2.enterEmailId(readProp("emailId"));
		mmt2.enterPhoneNo(readProp("phoneNo"));

		Logs.INFO("SELECT 2 SPECIAL REQUESTS");
		String[] specialRequests = { readProp("smokingRoom"), readProp("largeBed") };
		int noOfRequests = mmt2.selectSpecialRequests(specialRequests);	// count returned incorrectly
		softAssert.assertEquals(noOfRequests, specialRequests.length, "No. of Special Requests selected mismatch");
		softAssert.assertTrue(mmt2.getSpecialRequestCount().contains(String.valueOf(specialRequests.length)),
				"No. of Special Requests selected mismatch on Review Booking page");

		mmt.MMT_Payment();

		softAssert.assertAll();
		endOfScript();
	}
	
	
	@AfterMethod
	public void tearDown() {

		Logs.INFO("***** Quitting Driver *****");
		driver.quit();
	}




}
