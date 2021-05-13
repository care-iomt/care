package data_center;

/**
 * Guarda as classes de conexão com o banco de dados
 */
public class DataCenterConnection {
    private final LogController logController;

    public DataCenterConnection(LogController logController) {
        this.logController = logController;
    }

    public LogController getLogController() {
        return logController;
    }
}
