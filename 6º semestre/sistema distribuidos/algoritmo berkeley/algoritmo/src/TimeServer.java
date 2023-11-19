import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeServer extends UnicastRemoteObject implements TimeInterface {
    private List<TimeInterface> clientes;
    private LocalTime hrServidor;

    private static final String msg = "-- Servidor: ";

    public TimeServer() throws RemoteException {
        clientes = new ArrayList<>();
        hrServidor = LocalTime.now();
        mostrarHora();
        addSegundosTempo();
    }

    @Override
    public int idUltimoCliente() throws RemoteException {
        int retorno;
        if (clientes.isEmpty()) {
            retorno =  0;
        } else {
            retorno =  this.clientes.get(clientes.size() - 1).getId();
        }

        return retorno;
    }

    @Override
    public void ajustarTempo(long ajusteEmSegundos) {
        addTempo(ajusteEmSegundos);
    }

    @Override
    public void calcularDiferencaDeTempo() {
        HashMap<TimeInterface, Long> diferencaTempoClientes = new HashMap<>();
        long diferencasSegundos = 0;

        System.out.println(msg + "iniciando calculo de média em segundos");

        try {

            for (TimeInterface cliente : clientes) {
                diferencaTempoClientes.put(cliente, cliente.requsicaoDiferencaTempoSegundos(hrServidor));
                diferencasSegundos += diferencaTempoClientes.get(cliente);
            }

            System.out.println(msg + "média ficou em " + diferencasSegundos + " segundos");
            if (diferencasSegundos > 0) {

                diferencasSegundos = diferencasSegundos / clientes.size();

                for (TimeInterface c : clientes) {
                    c.ajustarTempo(diferencasSegundos + (diferencasSegundos - diferencaTempoClientes.get(c)));
                }
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void adicionarCliente(TimeInterface cliente) throws RemoteException {
        System.out.println(msg + "Cliente " + cliente.getId() + " adicionado");
        clientes.add(cliente);
    }

    @Override
    public long requsicaoDiferencaTempoSegundos(LocalTime hrServidor) throws RemoteException {
        return 0;
    }

    @Override //usado pelo cliente
    public int getId() throws RemoteException {
        return 0;
    }

    @Override
    public void mostrarHora() throws RemoteException {
        System.out.println(msg + "hora: " + hrServidor);
    }


    //para sincronizar as threads
    private synchronized void addTempo(Long segundos) {
        hrServidor = hrServidor.plusSeconds(segundos);
    }

    //vai adicionando 1s no relogio do cliente
    private void addSegundosTempo() {
        new Thread( () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    addTempo(1L);

                } catch (InterruptedException e) {
                    throw new RuntimeException(msg + "Erro em addSegundosTempo - " + e);
                }
            }
        }).start();
    }

    // acada 30s faz o ajuste de tempo
    public void sincronizarClientes() {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(30000);

                    if (!clientes.isEmpty()) {
                        System.out.println(msg + "iniciando sincronização");
                        calcularDiferencaDeTempo();
                        System.out.println(msg + "fim sincronização");
                    }
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(msg + "Erro em sincronizarClientes - " + e);
            }
        }).start();
    }

    public static void main(String[] args) {
        try {

            TimeServer servidor = new TimeServer();
            Naming.rebind("//localhost/TimeServer", servidor);
            System.out.println(" -- Servidor: estou pronto.");

            servidor.sincronizarClientes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}