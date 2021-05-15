package app.observers;

import alert_button.AlertButtonObserver;

public class AlertButtonObserverImpl implements AlertButtonObserver {
    @Override
    public void alert(Long buttonCode) {
        System.out.println("Alerta do botão");
    }
}
