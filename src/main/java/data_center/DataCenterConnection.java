package data_center;

import data_center.controller.ButtonLogController;
import data_center.controller.ButtonLogControllerImpl;
import data_center.controller.PatientLogController;
import data_center.controller.PatientLogControllerImpl;

/**
 * Guarda as classes de conexão com o banco de dados
 */
public class DataCenterConnection {
    private final PatientLogController patientLogController;
    private final ButtonLogController buttonLogController;

    public DataCenterConnection() {
        this.patientLogController = new PatientLogControllerImpl();
        this.buttonLogController = new ButtonLogControllerImpl();
    }

    public PatientLogController getPatientLogController() {
        return patientLogController;
    }

    public ButtonLogController getButtonLogController() {
        return buttonLogController;
    }
}
