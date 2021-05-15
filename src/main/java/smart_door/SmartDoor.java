package smart_door;

public interface SmartDoor {
    /**
     * Autentica um usuário, abrindo a porta caso permitido
     * @param smartDoorAuth Autenticação do usuário
     * @return true para permissão concedia e false para negada
     */
    boolean auth(SmartDoorAuth smartDoorAuth);

    /**
     * Configura as permissões da porta
     * @param smartDoorConfig configurações da porta inteligente
     */
    void configure(SmartDoorConfig smartDoorConfig);
}
