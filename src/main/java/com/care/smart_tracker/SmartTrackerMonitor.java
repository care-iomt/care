package com.care.smart_tracker;

public interface SmartTrackerMonitor {
    /**
     * Inicia o monitoramento
     *
     * @param patientId identificação do paciênte relacionado
     */
    void start(Long patientId);

    /**
     * Para o monitoramento
     */
    void stop();

    /**
     * Adicionar um observer para callback em caso de alertas configurados
     *
     * @param smartTrackerObserver objeto para callback
     */
    void addObserver(SmartTrackerObserver smartTrackerObserver);

    /**
     * Retorna o código do dispositivo
     *
     * @return código do dispositivo
     */
    Long getCode();

    /**
     * Retorna se o dispositivo está sendo utilizado
     *
     * @return código do dispositivo
     */
    boolean isUsed();
}
