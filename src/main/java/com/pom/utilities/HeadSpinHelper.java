package com.pom.utilities;

import okhttp3.*;

import java.io.IOException;
import java.rmi.server.RemoteRef;

public class HeadSpinHelper {
    OkHttpClient client = new OkHttpClient();

    public void getDevices() throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api-dev.headspin.io/v0/devices/automation-config").newBuilder();
        urlBuilder.addPathSegment("77ae52fb70d443a195f1d0a8e7b370cc");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
    }
}
