import data_center.DataCenterConnection;
import data_center.LogController;
import data_center.LogControllerImpl;

public class Main {
    // TODO: Se sobrar tempo implementar:
    // Frequência Respiratória
    // Saturação de Oxigênio
    // Nível de Dióxido de Carbono
    public static void main(String[] args) {
        final LogController logController = new LogControllerImpl();
        final DataCenterConnection dataCenterConnection = new DataCenterConnection(logController);

        System.out.println("Eu sou o seu primeiro programa.");
    }
}
