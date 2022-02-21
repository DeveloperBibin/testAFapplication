package com.example.aftestapplication;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFInAppEventParameterName;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationLifecycleHandler handler = new ApplicationLifecycleHandler();
        registerComponentCallbacks(handler);
    }

    public void nweClick(View view) {
        Intent intent= new  Intent(MainActivity.this,NewActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Not AppsFlyer","OnPauseCalled");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Not AppsFlyer","onResumeCalled");
    }

    public void sendEvent(View view) {

        Map<String, Object> eventValues = new HashMap<String, Object>();
        eventValues.put(AFInAppEventParameterName.PRICE, 1234.56);
        eventValues.put(AFInAppEventParameterName.CONTENT_ID,"1234567");

        AppsFlyerLib.getInstance().logEvent(getApplicationContext(),
                AFInAppEventType.PURCHASE , eventValues);

    }


}
