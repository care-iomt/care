package app;

import heart_rate.HeartRateAlertType;
import heart_rate.HeartRateObserver;

public class HeartRateObserverImpl implements HeartRateObserver {
    @Override
    public void alert(HeartRateAlertType alertType) {
        System.out.println("Heart Rate Alert: " + alertType.getValue());
    }
}
