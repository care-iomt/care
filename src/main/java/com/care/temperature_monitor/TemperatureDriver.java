package com.care.temperature_monitor;

import java.util.function.Function;

public class TemperatureDriver implements Runnable {
    private final Function<Integer, Void> handleTemperatureRead;
    private boolean isRunning;

    public TemperatureDriver(Function<Integer, Void> handleTemperatureRead) {
        this.handleTemperatureRead = handleTemperatureRead;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                final int temperature = (int) readTemperature();
                handleTemperatureRead.apply(temperature);
                Thread.sleep(120000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private double readTemperature() {
        final double rand = Math.random();
        if (rand < 0.9) {
            return (Math.random() * 2) + 35;
        } else if (rand < 0.98) {
            return (Math.random() * 3) + 32;
        } else {
            return (Math.random() * 5) + 37;
        }
    }
}
