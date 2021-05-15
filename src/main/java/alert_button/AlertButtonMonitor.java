package alert_button;

public interface AlertButtonMonitor {
    /**
     * Adicionar um Observer que irá criar um callback em caso de pressionamento do botão
     * @param alertButtonObserver objeto para callback
     */
    void addObserver(AlertButtonObserver alertButtonObserver);

    /**
     * Remove um Observer
     * @param alertButtonObserver objeto para callback
     */
    void removeObserver(AlertButtonObserver alertButtonObserver);

    /**
     * Retorna o código do dispositivo
     * @return código do dispositivo
     */
    Long getCode();
}