package com.example.forcegroundservices10052022;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyServices extends Service {

    String CHANNEL_ID="My Channel";
    NotificationManager mNotificationManager;
    Notification mNotification;
    //chi su dung khi dung bound service
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BBB", "onCreate");
        mNotification=createNotification();
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        startForeground(1,mNotification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        Log.d("BBB",Thread.currentThread().getName());
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                stopSelf();
//            }
//        },5000);
        //return super.onStartCommand(intent, flags, startId);
        if(intent!=null)
        {
            String text=intent.getStringExtra("myIntent");
            Log.d("BBB","Data recived: "+text);
        }
        Log.d("BBB","OnStartCommand");
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BBB", "onDetroy");
    }


    private Notification createNotification()
    {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MyServices.this,CHANNEL_ID);
        builder.setSmallIcon(android.R.drawable.ic_menu_add);
        builder.setShowWhen(true);
        builder.setContentTitle("Ung dung co phien ban moi");
        builder.setContentText("Ban co muon cap nhat khong");
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        return builder.build();
    }
}
