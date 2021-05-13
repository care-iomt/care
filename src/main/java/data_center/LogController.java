package data_center;

import java.util.List;

public interface LogController {
    /**
     * Salva um log de um monitor relacionado a um paciênte
     * @param patientLog log com informações relacionadas ao monitor
     */
    void saveLog(PatientLog patientLog);

    /**
     * Retorna todos os logs relacionados a um paciênte
     * @param patientId id do paciênte
     * @return lista de logs salvos no datacenter
     */
    List<PatientLog> getLogs(Long patientId);
}
