package data_center.controller;

import data_center.entities.ButtonLog;

import java.util.List;

public interface ButtonLogController {
    /**
     * Salva um log de um monitor relacionado a um paciênte
     * @param id id do botão
     * @param info string com informações do log
     */
    void saveLog(Long id, String info);

    /**
     * Retorna todos os logs relacionados a um paciênte
     * @param id id do botão
     * @return lista de logs salvos no datacenter
     */
    List<ButtonLog> getLogs(Long id);
}
