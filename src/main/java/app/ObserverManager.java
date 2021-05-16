package app;

import alert_button.AlertButtonObserver;
import app.observers.*;
import blood_pressure.BloodPressureObserver;
import heart_rate.HeartRateObserver;
import smart_tracker.SmartTrackerObserver;
import temperature_monitor.TemperatureObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObserverManager {

    private static ObserverManager instance;

    private List<AlertButtonObserverImpl> alertButtonObservers;
    private List<BloodPressureObserverImpl> bloodPressureObservers;
    private List<SmartTrackerObserverImpl> smartTrackerObservers;
    private List<TemperatureObserverImpl> temperatureObservers;
    private List<HeartRateObserverImpl> heartRateObservers;

    public ObserverManager() {
        this.alertButtonObservers = new ArrayList<>();
        this.bloodPressureObservers = new ArrayList<>();
        this.smartTrackerObservers = new ArrayList<>();
        this.temperatureObservers = new ArrayList<>();
        this.heartRateObservers = new ArrayList<>();
    }

    public static ObserverManager getInstance() {
        if (instance == null) {
            instance = new ObserverManager();
        }

        return instance;
    }

    public void add(AlertButtonObserverImpl alertButtonObserver) throws AlreadyHaveMonitorAttachedException {
        if (getAlertButtonObserversByPatientId(alertButtonObserver.getPatientId()).isEmpty()){
            alertButtonObservers.add(alertButtonObserver);
        } else {
            throw new AlreadyHaveMonitorAttachedException();
        }
    }

    public void add(BloodPressureObserverImpl bloodPressureObserver) throws AlreadyHaveMonitorAttachedException {
        if (getBloodPressureObserversByPatientId(bloodPressureObserver.getPatientId()).isEmpty()){
            bloodPressureObservers.add(bloodPressureObserver);
        }
        else {
            throw new AlreadyHaveMonitorAttachedException();
        }
    }

    public void add(SmartTrackerObserverImpl smartTrackerObserver) throws AlreadyHaveMonitorAttachedException {
        if (getSmartTrackerObserversByPatientId(smartTrackerObserver.getPatientId()).isEmpty()){
            smartTrackerObservers.add(smartTrackerObserver);
        }
        else {
            throw new AlreadyHaveMonitorAttachedException();
        }
    }

    public void add(TemperatureObserverImpl temperatureObserver) throws AlreadyHaveMonitorAttachedException {
        if (getTemperatureObserversByPatientId(temperatureObserver.getPatientId()).isEmpty()){
            temperatureObservers.add(temperatureObserver);
        }
        else {
            throw new AlreadyHaveMonitorAttachedException();
        }
    }

    public void add(HeartRateObserverImpl heartRateObserver) throws AlreadyHaveMonitorAttachedException {
        if (getHeartRateObserversByPatientId(heartRateObserver.getPatientId()).isEmpty()){
            heartRateObservers.add(heartRateObserver);
        }
        else {
            throw new AlreadyHaveMonitorAttachedException();
        }
    }

    public List<ObserverImpl> getObserversByPatientId(Long patientId) {
        List<ObserverImpl> patientObserverImpls = new ArrayList<>();

        alertButtonObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst()
                    .ifPresent(patientObserverImpls::add);

        bloodPressureObservers.stream().
                filter(bloodPressureObserver -> bloodPressureObserver.getPatientId().equals(patientId)).findFirst()
                    .ifPresent(patientObserverImpls::add);

        smartTrackerObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst()
                    .ifPresent(patientObserverImpls::add);

        temperatureObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst()
                    .ifPresent(patientObserverImpls::add);

        heartRateObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst()
                    .ifPresent(patientObserverImpls::add);

        return patientObserverImpls;
    }

     public Optional<AlertButtonObserverImpl> getAlertButtonObserversByPatientId(Long patientId) {
        return alertButtonObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst();
    }

     public Optional<BloodPressureObserverImpl> getBloodPressureObserversByPatientId(Long patientId) {
        return bloodPressureObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst();
    }

     public Optional<SmartTrackerObserverImpl> getSmartTrackerObserversByPatientId(Long patientId) {
        return smartTrackerObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst();
    }

    public Optional<TemperatureObserverImpl> getTemperatureObserversByPatientId(Long patientId) {
        return temperatureObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst();
    }

    public Optional<HeartRateObserverImpl> getHeartRateObserversByPatientId(Long patientId) {
        return heartRateObservers.stream().
                filter(observer -> observer.getPatientId().equals(patientId)).findFirst();
    }



    public void remove(AlertButtonObserver alertButtonObserver) {
        alertButtonObservers.remove(alertButtonObserver);
    }

    public void remove(BloodPressureObserver bloodPressureObserver) {
        bloodPressureObservers.remove(bloodPressureObserver);
    }

    public void remove(SmartTrackerObserver smartTrackerObserver) {
        smartTrackerObservers.remove(smartTrackerObserver);
    }

    public void remove(TemperatureObserver temperatureObserver) {
        temperatureObservers.remove(temperatureObserver);
    }

    public void remove(HeartRateObserver heartRateObserver) {
        heartRateObservers.remove(heartRateObserver);
    }

    public List<AlertButtonObserverImpl> getAlertButtonObservers() {
        return alertButtonObservers;
    }

    public List<BloodPressureObserverImpl> getBloodPressureObservers() {
        return bloodPressureObservers;
    }

    public List<SmartTrackerObserverImpl> getSmartTrackerObservers() {
        return smartTrackerObservers;
    }

    public List<TemperatureObserverImpl> getTemperatureObservers() {
        return temperatureObservers;
    }

    public List<HeartRateObserverImpl> getHeartRateObservers() {
        return heartRateObservers;
    }
}
