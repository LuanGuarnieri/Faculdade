public class PC {
    private char letra = 'O';
    Mapa mapa;

    public PC(Mapa mapa) {
        this.mapa = mapa;
    }

    boolean jogar() {
        while (true) { // repetir enquanto for verdadeiro
            int l = this.mapa.sortear(0, 3); // adicionar valores com o sortear
            int c = this.mapa.sortear(0, 3);

            if (this.mapa.jogar(l, c, 'O')) { // conferir se passa no método jogar

                System.out.println("PC [" + l + "," + c + "]"); // mostra a jogada do pc

                if (this.mapa.verificarGanhador('O')) {
                    System.out.println("=== PC GANHOU ===");
                    return true;
                }
                return false;
            }
        }
    }
}
