package com.pom.scripts;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pom.framework.TestBase;
import com.pom.pages.MMT_Mobile;
import com.pom.utilities.Logs;





@Listeners(com.pom.utilities.TestListener.class)
public class MMTScenario_Mobile extends TestBase {
	
	
	SoftAssert softAssert;
	MMT_Mobile mmt;
	
	@Parameters({"osType"})
	@BeforeMethod
	public void setUp(@Optional ("android") String osType) throws Exception {
		
		invokeDriver(osType);
		softAssert = new SoftAssert();
		mmt = new MMT_Mobile();
	}
	

	@Test
	public void mmtScriptAppium() throws Exception {

		// start script
//		mmt.MMT_Login();
		mmt.MMT_Hotels_Select_City("Delhi");
		mmt.MMT_Add_Guests(2,2);
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
