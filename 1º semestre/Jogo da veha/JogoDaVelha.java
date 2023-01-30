import java.util.Scanner;

public class JogoDaVelha {

    Jogador jogoJogador;
    PC jogoPC;
    Mapa jogoMapa;

    private JogoDaVelha() { // constructor
        Scanner teclado = new Scanner(System.in);

        this.jogoMapa = new Mapa();
        this.jogoJogador = new Jogador(this.jogoMapa);
        this.jogoPC = new PC(this.jogoMapa);

        char opcao = 'S'; // começar com S para rodar o dowhile

        do {
            jogar(teclado); // chamar método

            System.out.println("\n=========================");
            System.out.println("Jogar novamente :\ns = sim\nn = não");
            opcao = teclado.next().toUpperCase().charAt(0); // Deixar sempre em maiúsculo a resposta
        } while (opcao == 'S');

        System.out.println("=== JOGO ENCERRADO ===");
        teclado.close();
    }

    private void jogar(Scanner teclado) {
        int jogada = 0;
        boolean mudar = false; // começa com false para controlar a alternância
        boolean empate = true;

        jogoMapa.limpar(); // Adicionar ' ' aos valores
        
        if (this.jogoMapa.sortear(0, 2) == 1)
            mudar = true; // Para escolher quem começa

        this.jogoMapa.desenhar(jogada); // desenhar o mapa

        while (jogada < 9) { // Enquanto jogada for menor que 9 jogadas
            jogada++; // cada jogada ele ganha + 1

            if (mudar) { // for verdadeiro
                if (this.jogoPC.jogar()) {
                    empate = false;
                    break;
                }
                mudar = false;
            } else {
                if (jogoJogador.jogar(teclado)) {
                    empate = false;
                    break;
                }
                mudar = true;
            }
            this.jogoMapa.desenhar(jogada);
        }
        this.jogoMapa.desenhar(jogada);

        if (empate) { // se empate mudar para true

            System.out.println("=== Deu velha ===");
        }

    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
