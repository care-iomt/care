/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui;

import app.connector.BloodPressureConnector;
import app.connector.HeartRateConnector;
import app.connector.TemperatureConnector;
import blood_pressure.BloodPressureMonitor;
import blood_pressure.BloodPressureState;
import data_center.DataCenterConnection;
import data_center.controller.PatientController;
import data_center.controller.PatientLogController;
import data_center.entities.Patient;
import data_center.entities.PatientLog;
import heart_rate.HeartRateMonitor;
import heart_rate.HeartRateState;
import temperature_monitor.TemperatureMonitor;
import temperature_monitor.TemperatureState;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

/**
 * @author wmespindula
 */
public class PatientSearchUI extends DisposableJFrame {

    private MonitorRegisterUI monitorRegisterUI;
    private MonitorRemoveUI monitorRemoveUI;

    /**
     * Creates new form MainUI
     */
    public PatientSearchUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        patientInfoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addMonitorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientLogTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        bloodPressureLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        temperatureLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        heartRateLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        removeMonitorButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 0), new java.awt.Dimension(12, 0), new java.awt.Dimension(12, 32767));
        cpfTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar de Paciente");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jPanel3);

        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Logs do Paciente:");

        addMonitorButton.setText("Adicionar Monitor");
        addMonitorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMonitorButtonActionPerformed(evt);
            }
        });

        patientLogTextArea.setEditable(false);
        patientLogTextArea.setColumns(20);
        patientLogTextArea.setRows(5);
        jScrollPane1.setViewportView(patientLogTextArea);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Monitoramento:");

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        jLabel5.setText("Pressão Arterial:");
        jPanel5.add(jLabel5);
        jPanel5.add(filler8);
        jPanel5.add(bloodPressureLabel);

        jPanel2.add(jPanel5);
        jPanel2.add(filler1);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("Temperatura:");
        jPanel6.add(jLabel6);
        jPanel6.add(filler9);
        jPanel6.add(temperatureLabel);

        jPanel2.add(jPanel6);
        jPanel2.add(filler2);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setText("Batimentos Cardíacos:");
        jPanel7.add(jLabel7);
        jPanel7.add(filler10);
        jPanel7.add(heartRateLabel);

        jPanel2.add(jPanel7);
        jPanel2.add(filler3);
        jPanel2.add(filler6);

        removeMonitorButton.setText("Remover Monitor");
        removeMonitorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMonitorButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Atualizar");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientInfoPanelLayout = new javax.swing.GroupLayout(patientInfoPanel);
        patientInfoPanel.setLayout(patientInfoPanelLayout);
        patientInfoPanelLayout.setHorizontalGroup(
            patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, patientInfoPanelLayout.createSequentialGroup()
                        .addComponent(removeMonitorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addMonitorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        patientInfoPanelLayout.setVerticalGroup(
            patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientInfoPanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeMonitorButton)
                    .addComponent(addMonitorButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("CPF:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cpfTextField.setToolTipText("cpf");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTextField)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addGap(31, 31, 31)
                .addComponent(patientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        refreshInfo();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void refreshInfo() {
        Patient patient = getCurrentPatient();
        if (patient != null) {
            this.patientInfoPanel.setVisible(true);

            List<PatientLog> patientLogs = getPatientLogsByCPF(patient.getPatientId());
            String log = patientLogsToText(patientLogs);
            this.patientLogTextArea.setText(log);

            this.heartRateLabel.setText(getHeartRateByPatientId(patient.getPatientId()));
            this.bloodPressureLabel.setText(getBloodPressureByPatientId(patient.getPatientId()));
            this.temperatureLabel.setText(getTemperatureByPatientId(patient.getPatientId()));

        } else {
            JOptionPane.showMessageDialog(this, "O Paciente não está cadastrado no nosso hospital!",
                    "Paciente Inexistente!", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private Patient getCurrentPatient() {
        final DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        final PatientController patientAPI = dataCenterConnection.getPatientController();

        String cpf = cpfTextField.getText();
        if (cpf.matches("^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$")) {
            if (!cpf.isBlank()) {
                return patientAPI.getByCPF(cpf);
            }
        } else {
            JOptionPane.showMessageDialog(this, "CPF não é válido!", "CPF INVALIDO!",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    private String getBloodPressureByPatientId(Long patientId) {
        BloodPressureConnector bloodPressureConnector = BloodPressureConnector.getInstance();
        Optional<BloodPressureMonitor> monitor = bloodPressureConnector.getByPatientId(patientId);
        if (monitor.isPresent()) {
            BloodPressureState bloodPressureState = monitor.get().getCurrentState();
            return bloodPressureState.toString();
        } else {
            return "";
        }
    }

    private String getHeartRateByPatientId(Long patientId) {
        HeartRateConnector heartRateConnector = HeartRateConnector.getInstance();
        Optional<HeartRateMonitor> monitor = heartRateConnector.getByPatientId(patientId);
        if (monitor.isPresent()) {
            HeartRateState heartRateState = monitor.get().getCurrentState();
            return heartRateState.toString();
        } else {
            return "";
        }
    }

    private String getTemperatureByPatientId(Long patientId) {
        TemperatureConnector temperatureConnector = TemperatureConnector.getInstance();
        Optional<TemperatureMonitor> monitor = temperatureConnector.getByPatientId(patientId);
        if (monitor.isPresent()) {
            TemperatureState temperatureState = monitor.get().getCurrentState();
            return temperatureState.toString();
        } else {
            return "";
        }
    }

    private List<PatientLog> getPatientLogsByCPF(Long patientId) {
        PatientLogController patientLogAPI = DataCenterConnection.getInstance().getPatientLogController();
        return patientLogAPI.getLogs(patientId);
    }

    private String patientLogsToText(List<PatientLog> patientLogs, int limit) {
        List<PatientLog> patientLogsTrim = trimList(patientLogs, limit);
        StringBuilder logs = new StringBuilder();
        for (PatientLog log : patientLogsTrim) {
            logs.append(log.getMonitorName()).append(": ").append(log.getInfo()).append("\n");
        }
        return logs.toString();
    }

    private List<PatientLog> trimList(List<PatientLog> patientLogs, int limit) {
        final int fromIndex = patientLogs.size() > 50 ? (patientLogs.size() - limit) : 0;
        return patientLogs.subList(fromIndex, patientLogs.size());
    }

    private String patientLogsToText(List<PatientLog> patientLogs) {
        return this.patientLogsToText(patientLogs, 50);
    }

    private void addMonitorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMonitorButtonActionPerformed
        Patient currentPatient = getCurrentPatient();
        if (currentPatient != null) {
            if (monitorRegisterUI == null || monitorRegisterUI.isDisposed()){
                monitorRegisterUI = new MonitorRegisterUI(currentPatient);
                monitorRegisterUI.setVisible(true);
            }
        }
    }//GEN-LAST:event_addMonitorButtonActionPerformed

    private void removeMonitorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMonitorButtonActionPerformed
        Patient currentPatient = getCurrentPatient();
        if (currentPatient != null) {
            if (monitorRemoveUI == null || monitorRemoveUI.isDisposed()){
                monitorRemoveUI = new MonitorRemoveUI(currentPatient);
                monitorRemoveUI.setVisible(true);
            }
        }
    }//GEN-LAST:event_removeMonitorButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshInfo();
        pack();
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMonitorButton;
    private javax.swing.JLabel bloodPressureLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel heartRateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel patientInfoPanel;
    private javax.swing.JTextArea patientLogTextArea;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeMonitorButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel temperatureLabel;
    // End of variables declaration//GEN-END:variables
}
