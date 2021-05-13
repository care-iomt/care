package app;

import alert_button.AlertButtonObserver;

public class AlertButtonObserverImpl implements AlertButtonObserver {
    @Override
    public void alert() {
        System.out.println("Alerta do botão");
    }
}
