package com.bixlabs.amazonsns.gcm;
import com.bixlabs.amazonsns.R;
import com.bixlabs.amazonsns.api.Api;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;

import org.androidannotations.annotations.EService;
import org.androidannotations.annotations.res.StringRes;

import java.io.IOException;

@EService
public class GcmIDListenerService extends InstanceIDListenerService {

    @StringRes(R.string.project_number)
    String projectNumber;

    @Override
    public void onTokenRefresh() {
        try {
            InstanceID instanceID = InstanceID.getInstance(getApplicationContext());
            String token = instanceID.getToken(projectNumber, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            Api.registerDevice(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
