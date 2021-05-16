package com.care.app.ui;

public class Notifier {
    private static NotificationReceiver notificationReceiver = MainUI.getInstance().getNotificationReceiver();

    public static void alertDoctor(String TAG, String message) {
        notificationReceiver.alert(TAG, message);
    }

    public static void alertDoctor(String message) {
        notificationReceiver.alert(message);
    }
}
