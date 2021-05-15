package app.ui;

import data_center.DataCenterConnection;
import data_center.controller.PatientController;
import data_center.controller.PatientLogController;
import data_center.entities.Patient;
import data_center.entities.PatientLog;

import javax.swing.*;
import java.util.List;

public class PatientSearchUI extends javax.swing.JFrame {

    private final MonitorRegisterUI monitorRegisterUI;

    public PatientSearchUI() {
        monitorRegisterUI = new MonitorRegisterUI();

        initComponents();
        patientInfoPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
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
        jLabel3 = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 0), new java.awt.Dimension(8, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 0), new java.awt.Dimension(12, 0), new java.awt.Dimension(12, 32767));
        cpfTextField = new javax.swing.JTextField();

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informações do Paciente:");

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

        javax.swing.GroupLayout patientInfoPanelLayout = new javax.swing.GroupLayout(patientInfoPanel);
        patientInfoPanel.setLayout(patientInfoPanelLayout);
        patientInfoPanelLayout.setHorizontalGroup(
            patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patientInfoPanelLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(addMonitorButton)
                .addGap(61, 61, 61))
            .addComponent(jScrollPane1)
        );
        patientInfoPanelLayout.setVerticalGroup(
            patientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addMonitorButton))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(searchButton)))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addComponent(patientInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        final DataCenterConnection dataCenterConnection = DataCenterConnection.getInstance();
        final PatientController patientAPI = dataCenterConnection.getPatientController();

        String cpf = cpfTextField.getText();
        if (!cpf.isBlank()) {
            final Patient patient = patientAPI.getByCPF(cpf);
            if (patient != null){
                List<PatientLog> patientLogs = getPatientLogsByCPF(dataCenterConnection, patient.getPatientId());
                String log = patientLogsToText(patientLogs);
                this.patientLogTextArea.setText(log);
                this.patientInfoPanel.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "O Paciente não está cadastrado no nosso hospital!",
                        "Paciente Inexistente!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "CPF não é válido!", "CPF INVALIDO!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private List<PatientLog> getPatientLogsByCPF(DataCenterConnection dataCenterConnection, Long patientId) {
        PatientLogController patientLogAPI = dataCenterConnection.getPatientLogController();
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

    private void addMonitorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        monitorRegisterUI.setVisible(true);

    }

    private javax.swing.JButton addMonitorButton;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel patientInfoPanel;
    private javax.swing.JTextArea patientLogTextArea;
    private javax.swing.JButton searchButton;
}
