package com.care.smart_tracker;

import com.care.data_center.DataCenterConnection;

import java.util.List;
import java.util.function.Function;

public class SmartTrackerDriver implements Runnable {
    private final Function<SmartTrackerAlertType, Void> handleAlert;
    private boolean isRunning;

    public SmartTrackerDriver(Function<SmartTrackerAlertType, Void> handleAlert) {
        this.handleAlert = handleAlert;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                final SmartTrackerAlertType alertType = readCurrentValue();
                if (alertType != null) {
                    handleAlert.apply(alertType);
                }
                Thread.sleep(60000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private SmartTrackerAlertType readCurrentValue() {
        final double rand = Math.random();
        if (rand < 0.925) {
            return null;
        } else if (rand < 0.95) {
            return SmartTrackerAlertType.FEVER;
        } else if (rand < 0.975) {
            return SmartTrackerAlertType.TACHYCARDIA;
        } else {
            return SmartTrackerAlertType.BRADYCARDIA;
        }
    }
}
