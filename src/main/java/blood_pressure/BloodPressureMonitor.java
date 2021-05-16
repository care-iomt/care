package blood_pressure;

public interface BloodPressureMonitor {
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
     * @param bloodPressureConfig objeto de configuração
     */
    void configure(BloodPressureConfig bloodPressureConfig);

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     * @param bloodPressureObserver objeto para callback
     */
    void addObserver(BloodPressureObserver bloodPressureObserver);

    /**
     * Retorna o estado atual
     * @return estado atual
     */
    BloodPressureState getCurrentState();

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