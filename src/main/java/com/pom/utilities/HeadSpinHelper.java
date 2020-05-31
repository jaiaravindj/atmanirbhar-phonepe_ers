package com.pom.utilities;

import com.pom.framework.ReadProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadSpinHelper {

    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;
    private Response response;
    ReadProperties readProperties;

    public HeadSpinHelper() {
        readProperties = new ReadProperties();
    }

    public Map getHeadSpinDevices(String authToken) throws IOException {

        String baseUri = "https://"+authToken+"@api-dev.headspin.io/v0/devices/automation-config";
        Map<String,String> capabilities = new HashMap<>();

        requestSpec = new RequestSpecBuilder()
                .setAccept(io.restassured.http.ContentType.JSON)
                .setContentType(io.restassured.http.ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(io.restassured.http.ContentType.JSON)
                .build();

        response = given().spec(requestSpec)
                .get(baseUri)
                .then()
                .spec(responseSpec)
                .extract()
                .response();

        Map<String, Map> responseMap = response.getBody().jsonPath().get();
        Map<String,String> caps;
        String keyName = checkIfCountryReadable(responseMap);

        String driver_url = responseMap.get(keyName).get("driver_url").toString();
        driver_url = driver_url.replace("{api_token}",authToken);

        caps = (Map<String, String>) responseMap.get(keyName).get("capabilities");
        capabilities.put("deviceId", caps.get("deviceName"));
        capabilities.put("driverUrl", driver_url);
//        String apkPath = IBaseInterface.PROJECT_PATH + File.separator + "Resources" + File.separator + "mmt.apk";
//        installUninstallApk(apkPath,caps.get("deviceName"),false);
        return capabilities;
    }

    private String checkIfCountryReadable(Map<String, Map> responseMap) throws IOException {
        String keyName = null, countryName = "";
        Iterator it = responseMap.entrySet().iterator();
        for(String key : responseMap.keySet()) {
            Map device_location = (Map) responseMap.get(key).get("device_location");
            countryName = device_location.get("country_readable").toString();
            if(countryName.equalsIgnoreCase(readProperties.getProperties("deviceLocation"))) {
                keyName = key;
                break;
            }
        }
        return keyName;
    }

    private Response installUninstallApk(String apkPath,String deviceId, boolean isUninstall) throws IOException {
        String baseUri = "https://api-dev.headspin.io/v0/adb/"+deviceId+"/uninstall?package="+readProperties.getProperties("appPackage");
        File apkFilePath = new File(apkPath);
        requestSpec = new RequestSpecBuilder()
                .setAccept(io.restassured.http.ContentType.JSON)
                .build();

        if(!isUninstall) {
            baseUri = "https://api-dev.headspin.io/v0/adb/"+deviceId+"/install";
            requestSpec.multiPart(apkFilePath);
        }

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(io.restassured.http.ContentType.JSON)
                .build();

        response = given().spec(requestSpec)
                .post(baseUri)
                .then()
                .spec(responseSpec)
                .extract()
                .response();

        return response;
    }
}
