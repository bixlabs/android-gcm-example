package com.bixlabs.amazonsns.gcm;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.bixlabs.amazonsns.R;
import com.google.android.gms.gcm.GcmListenerService;

import org.androidannotations.annotations.EService;

import java.util.Random;

@EService
public class GcmIntentService extends GcmListenerService {

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Random r = new Random();
        int i1 = r.nextInt(101);
        String message = bundle.getString("message");
        String title = bundle.getString("title", "SNS Notification");
        String summary = bundle.getString("summary", "Example summary");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(
                        new NotificationCompat.BigTextStyle().bigText(message)
                        .setSummaryText(summary)
                )
                .setContentTitle(title)
                .setContentText(message);
        notificationManager.notify(i1, mBuilder.build());
    }
}
