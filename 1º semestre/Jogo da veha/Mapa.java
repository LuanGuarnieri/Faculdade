public class Mapa {
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim) { // sortear número

        int sorteio = (int) ((Math.random() * fim) - inicio);
        return sorteio;
    }

    public void limpar() { // adicionar ' ' aos espaços
        for (int l = 0; l < mapa.length; l++) {
            for (int c = 0; c < mapa.length; c++) {
                mapa[l][c] = ' ';
            }
        }

    }

    public void desenhar(int jogada) { // desenhar o mapa
        System.out.println("------------- .. jogada : " + jogada);
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("------------- ");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("------------- ");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("---------------------------");
    }

    boolean jogar(int l, int c, char jogador) { // testar se está vazio

        if (mapa[l][c] == ' ') {
            mapa[l][c] = jogador;
            return true;
        } 
            return false;
    }

    boolean verificarGanhador(char jogador) { // possibilidades de ganhar
        for (int l = 0; l < mapa.length; l++) {
            for (int c = 0; c < mapa.length; c++) {

                if (mapa[0][0] == jogador && mapa[0][1] == jogador && mapa[0][2] == jogador) { 
                    return true;
                }
                if (mapa[1][0] == jogador && mapa[1][1] == jogador && mapa[1][2] == jogador) {
                    return true;
                }
                if (mapa[2][0] == jogador && mapa[2][1] == jogador && mapa[2][2] == jogador) {
                    return true;
                }
                if (mapa[2][0] == jogador && mapa[2][1] == jogador && mapa[2][2] == jogador) {
                    return true;
                }
                if (mapa[0][0] == jogador && mapa[1][0] == jogador && mapa[2][0] == jogador) {
                    return true;
                }
                if (mapa[0][1] == jogador && mapa[1][1] == jogador && mapa[2][1] == jogador) {
                    return true;
                }
                if (mapa[0][2] == jogador && mapa[1][2] == jogador && mapa[2][2] == jogador) {
                    return true;
                }
                if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) {
                    return true;
                }
                if (mapa[2][0] == jogador && mapa[1][1] == jogador && mapa[0][2] == jogador) {
                    return true;
                }
            }
        }

        return false;
    }
}
