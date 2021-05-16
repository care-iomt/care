package com.care.app.ui;

public interface NotificationReceiver {

    void alert(String TAG, String message);

    void alert(String message);

}
