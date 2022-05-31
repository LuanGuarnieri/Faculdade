package trabalho02Algoritmos.arvoreNaria;

/**
 * === CRIADORES ===
 * 
 * Luan L. Guarnieri e Maria Eduarda Krutzsch
 */

public class Arvore<T> {

    private NoArvore<T> raiz;

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
        raiz.setNivel(0);
    }

    public NoArvore<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        }
        return raiz.pertence(info);
    }

    public boolean vazia() {
        return (this.raiz == null);
    }

    @Override
    public String toString() {
        if (this.vazia()) {
            return "<>";
        }
        return raiz.imprimePre();
    }

    private NoArvore<T> getRaiz() {
        return this.raiz;
    }

    /* ==== METODOS CRIADO PARA O TRABALHO A PARTIR DAQUI ====== */

    public int getAltura() { // utilizando o metodo privado a baixo
        if (vazia()) {
            return -1;

        } else {
            return altura(getRaiz());
        }
    }

    private int altura(NoArvore<T> no) {
        int alturaArvore = -1;
        // criando variavel com valor -1 caso a a raiz seja noFolha retorna 0

        NoArvore<T> aux;

        for (aux = no.getFilho(); aux != null; aux = aux.getIrmao()) {

            int recebAltura = altura(aux);
            if (recebAltura > alturaArvore) {

                alturaArvore = recebAltura;
            }
        }
        return alturaArvore + 1;
    }

    public int getAltura2() { // metodo 02 utilizando NoArvore
        if (vazia()) {
            return -1;
        } else {
            return getRaiz().returnAltura();
        }
    }

    public int getNivel(T valor) {
        NoArvore<T> aux = pertence(valor);
        // utilizando o pertece() para buscar o valor na arvore

        int nivelArvore = 0;

        if (aux == null) {
            nivelArvore = -1;
        } else {
            nivelArvore = aux.getNivel();
        }
        return nivelArvore;
    }

    public boolean isBalanceada() {

        if (maiorNo() - menorNo() == 0 || maiorNo() - menorNo() == 1) { // validando condição
            return true;

        } else {
            return false;
        }
    }

    // criar metodo menor nó aqui

    private int menorNo() {
        // retornando o nivel do menorNo (utilizado no isBalaceada)

        int recebNivel = 0;
        int menorNo = getAltura();
        // recebendo a altura para decrementar

        String a = getRaiz().returnStringNosFolha();
        String[] aux = a.split(",");
        // qconvertendo em String array a cada ','

        int i = aux.length;

        while (i > 0) {
            recebNivel = Integer.valueOf(aux[i - 1]);
            // convertendo em int

            if (recebNivel < menorNo) {
                menorNo = recebNivel;
            }
            i--;
        }

        return menorNo;
    }

    private int maiorNo() {
        // retornando o nivel do maior no encontrado na arvore = poderia ser um ==
        // getAltura03() ==

        int recebNivel = 0;
        int maiorNo = 0;

        String a = getRaiz().returnStringNosFolha();
        String[] aux = a.split(",");
        // qconvertendo em String array a cada ','

        int i = aux.length;
        // recebendo o tamanho do array

        while (i > 0) {
            recebNivel = Integer.valueOf(aux[i - 1]);
            // convertendo em int

            if (recebNivel > maiorNo) {
                maiorNo = recebNivel;
            }
            i--;
        }

        return maiorNo;
    }
}
