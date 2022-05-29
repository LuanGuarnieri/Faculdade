package trabalho02Algoritmos.arvoreNaria;

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

    public int getAltura() {
        if (vazia()) {
            return -1;

        } else {
            return altura(getRaiz()); // retornando o metodo privado altura
        }
    }

    // feito
    private int altura(NoArvore<T> no) {
        int menorNo = -1; // criando variavel local

        NoArvore<T> aux; // criando nó auxiliar

        for (aux = no.getFilho(); aux != null; aux = aux.getIrmao()) { // enquanto aux não for nulo

            int h = altura(aux);
            if (h > menorNo) {

                menorNo = h;
            }
        }
        return menorNo + 1;
    }

    // feito
    public int getNivel(T valor) {
        NoArvore<T> aux = pertence(valor);
        int nivelArvore = 0;

        if (aux == null) {
            nivelArvore = -1;
        } else {
            nivelArvore = aux.getNivel();
        }
        return nivelArvore;
    }

    private int menorNo(NoArvore<T> no) { // em produção
        if (no == no.ehFolha()) {
            return no.getNivel();

        }
    }

    public boolean isBalanceada() {
        if (getAltura() - menorNo(getRaiz()) == 0
                || getAltura() - menorNo(getRaiz()) == 1) {

            return true;
        } else {
            return false;
        }
    }
}
