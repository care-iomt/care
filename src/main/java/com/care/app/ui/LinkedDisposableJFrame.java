package com.care.app.ui;

import java.awt.*;

public abstract class LinkedDisposableJFrame extends DisposableJFrame {
    private DisposableJFrame previousJFrame;

    public LinkedDisposableJFrame(DisposableJFrame previousJFrame) throws HeadlessException {
        this.previousJFrame = previousJFrame;
    }

    @Override
    public void dispose() {
        this.isDisposed = true;
        previousJFrame.dispose();
        previousJFrame.isDisposed = true;
        super.dispose();
    }
}
