package com.pom.utilities;



import org.testng.ISuite;
import org.testng.ISuiteListener;
import com.pom.framework.TestBase;




public class SuiteListener extends TestBase implements ISuiteListener {


	public void onStart(ISuite suite) {

		Logs.INFO("#######  Suite Execution Started  #######");
	}

	public void onFinish(ISuite suite) {

		Logs.INFO("#######  Suite Execution Completed  #######");	
	}

}
