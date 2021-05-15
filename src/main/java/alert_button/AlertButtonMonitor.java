package alert_button;

public interface AlertButtonMonitor {
    /**
     * Adicionar um ObserverImpl que irá criar um callback em caso de pressionamento do botão
     * @param alertButtonObserver objeto para callback
     */
    void addObserver(AlertButtonObserver alertButtonObserver);

    /**
     * Remove um ObserverImpl
     * @param alertButtonObserver objeto para callback
     */
    void removeObserver(AlertButtonObserver alertButtonObserver);

    /**
     * Retorna o código do dispositivo
     * @return código do dispositivo
     */
    Long getCode();
}