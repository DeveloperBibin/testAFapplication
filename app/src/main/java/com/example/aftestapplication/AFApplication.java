package com.example.aftestapplication;

import android.app.Application;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;
import java.util.Objects;

public class AFApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppsFlyerLib.getInstance().init("AZzpeoG2fEZDaYh2E64jDi", new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionDataMap) {
                Log.d("AppsFlyer", "Launch sent successfully, got 200 response code from server");
                for (String attrName : conversionDataMap.keySet())
                    Log.d("LOG_TAG", "Conversion attribute: " + attrName + " = " + conversionDataMap.get(attrName));
                String status = Objects.requireNonNull(conversionDataMap.get("af_status")).toString();
                if(status.equals("Organic")){
                    // Business logic for Organic conversion goes here.
                }
                else {
                    // Business logic for Non-organic conversion goes here.
                }
            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        }, this);
        AppsFlyerLib.getInstance().setDebugLog(true);
        AppsFlyerLib.getInstance().start(this);
    }

}
