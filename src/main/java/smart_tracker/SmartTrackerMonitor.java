package smart_tracker;

public interface SmartTrackerMonitor {
    /**
     * Inicia o monitoramento
     * @param patientId identificação do paciênte relacionado
     */
    void start(Long patientId);

    /**
     * Para o monitoramento
     */
    void stop();

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

    /**
     * Retorna o código do dispositivo
     * @return código do dispositivo
     */
    Long getCode();

    /**
     * Retorna se o dispositivo está sendo utilizado
     * @return código do dispositivo
     */
    boolean isUsed();
}
