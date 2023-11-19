import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

public interface TimeInterface extends Remote {

    int idUltimoCliente() throws RemoteException;

    void ajustarTempo(long ajuste) throws RemoteException;

    void calcularDiferencaDeTempo() throws RemoteException;

    void adicionarCliente(TimeInterface client) throws RemoteException;

    long requsicaoDiferencaTempoSegundos(LocalTime hrServidor) throws RemoteException;

    int getId() throws RemoteException;

    void mostrarHora() throws RemoteException;
}
