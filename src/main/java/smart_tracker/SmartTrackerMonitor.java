package smart_tracker;

public interface SmartTrackerMonitor {
    /**
     * Configura o monitor
     * @param config objeto de configuração
     */
    void configure(SmartTrackerConfig config);

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     * @param smartTrackerObserver objeto para callback
     */
    void addObserver(SmartTrackerObserver smartTrackerObserver);

    /**
     * remove um observer
     * @param smartTrackerObserver objeto para callback
     */
    void removeObserver(SmartTrackerObserver smartTrackerObserver);
}
