package app.ui;

import javax.swing.*;

public class NotificationReceiverImpl implements NotificationReceiver {
    private JFrame mainJFrame;

    public NotificationReceiverImpl(JFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void alert(String TAG, String message) {
        String messageAlert = TAG+": "+message;
        alert(messageAlert);
    }

    @Override
    public void alert(String message) {
        JOptionPane.showMessageDialog(mainJFrame, message, "ATENÇÃO!", JOptionPane.ERROR_MESSAGE);
    }
}
