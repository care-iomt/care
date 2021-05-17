package com.care.alert_button;

import java.util.function.Function;

public class AlertButtonDriver implements Runnable {
    private final Function<Void, Void> onClick;

    public AlertButtonDriver(Function<Void, Void> onClick) {
        this.onClick = onClick;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (this.shouldReport()) {
                    onClick.apply(null);
                }
                Thread.sleep(60000);
            } catch (InterruptedException ignored) { }
        }
    }

    private boolean shouldReport() {
        return ((int) (Math.random() * 11)) == 3;
    }
}
