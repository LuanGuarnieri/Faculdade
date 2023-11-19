import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class TimeClient extends UnicastRemoteObject implements TimeInterface {

    private final int idCliente;
    private LocalTime hrCliente;

    public TimeClient(int id) throws RemoteException {
        this.idCliente = id;
        hrCliente = LocalTime.now().plusMinutes(new Random().nextInt(0,4));
        mostrarHora();
        addSegundosTempo();
        addSegundosAleatorios();
    }

    @Override //metodo para o  servidor
    public int idUltimoCliente() throws RemoteException {
        return 0;
    }

    @Override // aplicando o ajuste em segundos
    public void ajustarTempo(long ajusteEmSegundos) {
        System.out.println(montaMsgPadrao() + "efetuando ajuste de " + ajusteEmSegundos  + " segundos - " + this.hrCliente);
        addTempo(ajusteEmSegundos);
        System.out.println(montaMsgPadrao() + "hora atualizada " + hrCliente);
    }

    @Override // servidor calcula a diferença
    public void calcularDiferencaDeTempo() {}

    @Override //metodo para o  servidor
    public void adicionarCliente(TimeInterface client) throws RemoteException {

    }

    @Override // retorna diferença em segundos
    public long requsicaoDiferencaTempoSegundos(LocalTime hrServidor) throws RemoteException {
        return ChronoUnit.SECONDS.between(hrServidor, hrCliente);
    }

    @Override
    public int getId() { return this.idCliente; }

    @Override
    public void mostrarHora() throws RemoteException {
        System.out.println(montaMsgPadrao() + " hora: " + hrCliente);
    }

    private String montaMsgPadrao() {
        return "== Cliente "+ this.getId() +": ";
    }

    private synchronized void addTempo(Long segundos) {
        hrCliente = hrCliente.plusSeconds(segundos);
    }

    //vai adicionando 1s no relogio do cliente
    private void addSegundosTempo() {
        new Thread(() -> {
            while (true) {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        addTempo(1L);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(montaMsgPadrao() + "Erro em addSegundosTempo - " + e);
                }
            }
        }).start();
    }

    //adiciona alguns segundos no tempo
    private void addSegundosAleatorios() {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(60000);

                    System.out.println(montaMsgPadrao() + "adicionando segundos aleatorios");
                    addTempo(new Random().nextLong(1, 601));
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(montaMsgPadrao() + "Erro em addSegundosAleatorios - " + e);
            }

        }).start();
    }

    public static void main(String[] args) {
        try {
            TimeInterface servidor = (TimeInterface) Naming.lookup("//localhost/TimeServer");
            TimeClient cliente = new TimeClient(servidor.idUltimoCliente() + 1);

            System.out.println(cliente.montaMsgPadrao() + "ativo");
            servidor.adicionarCliente(cliente);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}