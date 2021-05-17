package com.care.blood_pressure;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import java.util.function.Function;

public class BloodPressureDriver implements Runnable {
    private final Function<Pair<Integer, Integer>, Void> onRead;
    private boolean isRunning;

    public BloodPressureDriver(Function<Pair<Integer, Integer>, Void> onRead) {
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
                final Pair<Integer, Integer> bloodPressure = readBloodPressure();
                onRead.apply(bloodPressure);
                Thread.sleep(30000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private Pair<Integer, Integer> readBloodPressure() {
        final int bloodPressureS;
        final int bloodPressureD;
        final double rand = Math.random();

        if (rand < 0.9) {
            bloodPressureS = (int) (Math.random() * 30) + 90;
            bloodPressureD = (int) (Math.random() * 25) + 60;
        } else if (rand < 0.975) {
            bloodPressureS = (int) (Math.random() * 20) + 120;
            bloodPressureD = (int) (Math.random() * 20) + 85;
        } else {
            bloodPressureS = (int) (Math.random() * 15) + 65;
            bloodPressureD = (int) (Math.random() * 10) + 50;
        }

        return new MutablePair<>(bloodPressureS, bloodPressureD);
    }
}
