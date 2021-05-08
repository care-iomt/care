package smart_tracker;

public interface SmartTracker {
    /**
     * Configura o monitor
     * @param config objeto de configuração
     */
    void configure(Config config);

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     * @param observer objeto para callback
     */
    void addObserver(Observer observer);

    /**
     * remove um observer
     * @param observer objeto para callback
     */
    void removeObserver(Observer observer);
}
