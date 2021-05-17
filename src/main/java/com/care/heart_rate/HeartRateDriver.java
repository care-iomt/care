package com.care.heart_rate;

import java.util.function.Function;

public class HeartRateDriver implements Runnable {
    private final Function<Integer, Void> onRead;
    private boolean isRunning;

    public HeartRateDriver(Function<Integer, Void> onRead) {
        this.onRead = onRead;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                final int heartRate = readHeartRate();
                onRead.apply(heartRate);
                Thread.sleep(120000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private int readHeartRate() {
        final double rand = Math.random();
        if (rand < 0.65) {
            return (int) (Math.random() * 20) + 50;
        } else if (rand < 0.90) {
            return (int) (Math.random() * 10) + 70;
        } else if (rand < 0.95) {
            return (int) (Math.random() * 20) + 30;
        } else {
            return (int) (Math.random() * 50) + 80;
        }
    }
}
