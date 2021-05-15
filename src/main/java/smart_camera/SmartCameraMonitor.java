package smart_camera;

public interface SmartCameraMonitor {
    /**
     * Configura a camera
     * @param config objeto de configuração
     */
    void configure(SmartCameraConfig config);

    /**
     * Adicionar um observer para callback em caso de alertas
     * @param observer objeto para callback
     */
    void addObserver(SmartCameraObserver observer);

    /**
     * Remove um observer
     * @param observer objeto para callback
     */
    void removeObserver(SmartCameraObserver observer);

    /**
     * Inicia o monitoramento
     */
    void start();

    /**
     * Para o monitoramento
     */
    void stop();
}
