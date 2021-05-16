package app.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public abstract class DisposableJFrame extends JFrame {
    protected boolean isDisposed;

    public DisposableJFrame() throws HeadlessException {
        this.isDisposed = false;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }

    private void formWindowClosing(WindowEvent evt) {
        this.isDisposed = true;
    }

    public boolean isDisposed(){
        return this.isDisposed;
    }

    @Override
    public void dispose() {
        this.isDisposed = true;
        super.dispose();
    }
}
