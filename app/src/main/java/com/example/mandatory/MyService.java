package com.example.mandatory;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private final IBinder binder = new LocalBinder();
    private MainActivity.MyServiceCallback callback;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setCallback(MainActivity.MyServiceCallback callback) {
        this.callback = callback;
    }

    public void sendMessage(String message) {
        if (callback != null) {
            callback.onMessageReceived(message);
        }
    }

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
