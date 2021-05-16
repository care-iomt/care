package com.care.data_center;

import com.care.data_center.controller.*;

/**
 * Guarda as classes de conexão com o banco de dados
 */
public class DataCenterConnection {
    private static DataCenterConnection instance;

    private final PatientLogController patientLogController;
    private final ButtonLogController buttonLogController;
    private final PatientController patientController;
    private final PatientAlertButtonController patientAlertButtonController;

    private DataCenterConnection() {
        patientLogController = new PatientLogControllerImpl();
        buttonLogController = new ButtonLogControllerImpl();
        patientController = new PatientControllerImpl();
        patientAlertButtonController = new PatientAlertButtonControllerImpl();
    }

    public static DataCenterConnection getInstance() {
        if (instance == null) {
            instance = new DataCenterConnection();
        }
        return instance;
    }

    public PatientLogController getPatientLogController() {
        return patientLogController;
    }

    public ButtonLogController getButtonLogController() {
        return buttonLogController;
    }

    public PatientController getPatientController() {
        return patientController;
    }

    public PatientAlertButtonController getPatientAlertButtonController() {
        return patientAlertButtonController;
    }
}
