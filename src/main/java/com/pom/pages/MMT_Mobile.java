package com.pom.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	
	
	public MMT_Mobile() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		Logs.INFO("This is constructor - MMT");
	}
	

	@AndroidFindBy (id = "com.makemytrip:id/iv_lotte_anim")
	MobileElement gotItBtn;

	@AndroidFindBy (id = "com.makemytrip:id/price_filter")
	MobileElement priceFilterBtn;

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
