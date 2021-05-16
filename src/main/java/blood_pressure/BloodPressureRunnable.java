package blood_pressure;

import data_center.DataCenterConnection;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class BloodPressureRunnable implements Runnable {
    private final List<BloodPressureObserver> observerList;
    private final DataCenterConnection dataCenterConnection;
    private final Long patientId;
    private final BloodPressureConfig config;
    private final BloodPressureState state;
    private boolean isRunning;

    public BloodPressureRunnable(List<BloodPressureObserver> observerList, Long patientId,
                                 BloodPressureConfig config, BloodPressureState state) {
        this.observerList = observerList;
        this.dataCenterConnection = DataCenterConnection.getInstance();
        this.patientId = patientId;
        this.config = config;
        this.state = state;
        isRunning = true;
    }

    public void kill() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                final BloodPressureAlertType alertType = getAlertType();
                if (alertType != null) {
                    saveLog("Alerta "+alertType.getValue());
                    observerList.forEach(observer -> observer.alert(alertType, patientId));
                }
                Thread.sleep(120000);
            } catch (InterruptedException ignored) { }
        }
    }

    private BloodPressureAlertType getAlertType() {
        final Pair<Integer, Integer> bloodPressure = getBloodPressure();

        final int systolic = bloodPressure.getLeft();
        final int diastolic = bloodPressure.getRight();

        saveLog("Sistólica: " + systolic + " - Diastólica: " + diastolic);

        state.setDiastolic(diastolic);
        state.setSystolic(systolic);

        if (diastolic < config.getMinState().getDiastolic()) {
            return BloodPressureAlertType.MIN_DIASTOLIC;
        } else if (diastolic > config.getMaxState().getDiastolic()) {
            return BloodPressureAlertType.MAX_DIASTOLIC;
        } else if (systolic < config.getMinState().getSystolic()) {
            return BloodPressureAlertType.MIN_SYSTOLIC;
        } else if (systolic > config.getMaxState().getSystolic()) {
            return BloodPressureAlertType.MAX_SYSTOLIC;
        }

        return null;
    }

    private Pair<Integer, Integer> getBloodPressure() {
        final int bloodPressureS;
        final int bloodPressureD;
        final double rand = Math.random();

        if (rand < 0.9) {
            bloodPressureS = (int)(Math.random() * 30) + 90;
            bloodPressureD = (int)(Math.random() * 25) + 60;
        }  else if (rand < 0.975) {
            bloodPressureS = (int)(Math.random() * 20) + 120;
            bloodPressureD = (int)(Math.random() * 20) + 85;
        } else {
            bloodPressureS = (int)(Math.random() * 15) + 65;
            bloodPressureD = (int)(Math.random() * 10) + 50;
        }

        return new MutablePair<>(bloodPressureS, bloodPressureD);
    }

    private void saveLog(String info) {
        dataCenterConnection.getPatientLogController().saveLog(patientId, "Monitor de Pressão", info);
    }
}
