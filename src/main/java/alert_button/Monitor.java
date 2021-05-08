package alert_button;

public interface Monitor {
    /**
     * Adicionar um Observer que irá criar um callback em caso de pressionamento do botão
     * @param observer objeto para callback
     */
    void addObserver(Observer observer);

    /**
     * Remove um Observer
     * @param observer objeto para callback
     */
    void removeObserver(Observer observer);
}