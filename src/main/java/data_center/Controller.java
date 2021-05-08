package data_center;

import java.util.List;

public interface Controller {
    /**
     * Salva um log de um monitor relacionado a um paciênte
     * @param log log com informações relacionadas ao monitor
     */
    void saveLog(Log log);

    /**
     * Retorna todos os logs relacionados a um paciênte
     * @param patientId id do paciênte
     * @return lista de logs salvos no datacenter
     */
    List<Log> getLogs(Long patientId);
}
