package temperature_monitor;

public interface TemperatureMonitor {
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
    void configure(TemperatureConfig config);

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     * @param observer objeto para callback
     */
    void addObserver(TemperatureObserver observer);

    /**
     * remove um observer
     * @param observer objeto para callback
     */
    void removeObserver(TemperatureObserver observer);

    /**
     * Retorna o estado atual
     * @return estado atual
     */
    TemperatureState getCurrentState();

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