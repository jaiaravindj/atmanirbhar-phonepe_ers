package com.pom.scripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pom.framework.TestBase;
import com.pom.pages.MMT_Web;
import com.pom.utilities.Logs;


@Listeners(com.pom.utilities.TestListener.class)
public class MMTScenario_Web extends TestBase {
	
	
	SoftAssert softAssert;
	MMT_Web mmt;
	
	@Parameters({"osType"})
	@BeforeMethod
	public void setUp(@Optional ("chrome") String osType) throws IOException, InterruptedException {
		
		invokeWebDriver(osType, readProp("webURL"));
		webDriver.manage().window().maximize();
		softAssert = new SoftAssert();
		mmt = new MMT_Web();
	}
	
	
	@Test
	void mmtScriptSelenium() throws IOException {

		// start tc
		
		softAssert.assertAll();
		endOfScript();
	}
	
	
	@AfterMethod
	public void tearDown() {

		Logs.INFO("***** Quitting Driver *****");
		webDriver.quit();
	}

}
