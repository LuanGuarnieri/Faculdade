import java.util.Scanner;

public class Jogador {

    private char letra = 'X';
    Mapa mapa;

    public Jogador(Mapa mapa) {
        this.mapa = mapa; // instânciar objeto mapa
    }

    boolean jogar(Scanner teclado) {
        while (true) { // repetir enquanto for verdadeiro
            System.out.println("== JOGADOR == ");
            System.out.println("    Linha :");
            int l = teclado.nextInt();
            System.out.println("    Coluna :");
            int c = teclado.nextInt();

            if (l >= 0 && l < 3 && c >= 0 && c < 3) { // confere se é maior ou igual a 0 e menor que 3
                if (this.mapa.jogar(l, c, 'X')) {
                    break; // parar se estiver correto
                }
                System.out.println(" === Posição inválida! ===\n");
            }
        }

        if (this.mapa.verificarGanhador('X')) { // verificar se ganhou
            System.out.println(" === Jogador GANHOU! ===");
            return true;
        }
        return false;
    }
}
