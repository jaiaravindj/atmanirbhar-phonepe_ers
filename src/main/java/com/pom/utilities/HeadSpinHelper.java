package com.pom.utilities;

import com.oracle.tools.packager.Log;
import com.pom.framework.IBaseInterface;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadSpinHelper {

    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;
    private Response response;

    public Map getHotSpinDevices() {
        Map<String,String> capabilities = new HashMap<>();

        requestSpec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();

        response = given().spec(requestSpec)
                .get("https://77ae52fb70d443a195f1d0a8e7b370cc@api-dev.headspin.io/v0/devices/automation-config")
                .then()
                .spec(responseSpec)
                .extract()
                .response();

        Map<String, Map> responseMap = response.getBody().jsonPath().get();
        Map<String,String> caps = new HashMap();
        String firstDevice = responseMap.entrySet().iterator().next().getKey();
        String driver_url = "https://in-bng.headspin.io:7012/v0/77ae52fb70d443a195f1d0a8e7b370cc/wd/hub";
        driver_url = driver_url.replace("{api_token}","77ae52fb70d443a195f1d0a8e7b370cc");

        caps = (Map<String, String>) responseMap.get(firstDevice).get("capabilities");
        capabilities.put("device-id", "S84H5LKNH6AQ6PEA");
        capabilities.put("driverUrl", driver_url);

        return capabilities;
    }

    private Response installApk(String apkPath,String deviceId, boolean isUninstall) {
        String baseUri = "https://77ae52fb70d443a195f1d0a8e7b370cc@api-dev.headspin.io/v0/adb/S84H5LKNH6AQ6PEA/uninstall?package=com.makemytrip";
        File apkFilePath = new File(apkPath);
        requestSpec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .build();

        if(!isUninstall) {
            baseUri = "https://77ae52fb70d443a195f1d0a8e7b370cc@api-dev.headspin.io/v0/adb/S84H5LKNH6AQ6PEA/install";
            requestSpec.multiPart(apkFilePath);
        }

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
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
