package com.bixlabs.amazonsns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bixlabs.amazonsns.api.Api;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.res.StringRes;

import java.io.IOException;

@EActivity
public class MainActivity extends AppCompatActivity {

    @StringRes(R.string.project_number)
    String projectNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Background
    void registerDevice() {
        try {
            InstanceID instanceID = InstanceID.getInstance(getApplicationContext());
            String token = instanceID.getToken(projectNumber, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            Api.registerDevice(token);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Click(R.id.registerDeviceBtn)
    void registerClick() {
        registerDevice();
    }
}
