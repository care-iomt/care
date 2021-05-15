package heart_rate;

public interface HeartRateMonitor {
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
     * @param heartRateConfig objeto de configuração
     */
    void configure(HeartRateConfig heartRateConfig);

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     * @param heartRateObserver objeto para callback
     */
    void addObserver(HeartRateObserver heartRateObserver);

    /**
     * remove um observer
     * @param heartRateObserver objeto para callback
     */
    void removeObserver(HeartRateObserver heartRateObserver);

    /**
     * Retorna o estado atual
     * @return estado atual
     */
    HeartRateState getCurrentState();

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

    /**
     * Busca o id do paciente associado ao dispositivo
     * @return patient id
     */
    Long getPatientId();
}