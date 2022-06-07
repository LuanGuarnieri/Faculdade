public class MapaDispersao<T, K> {

    int qtd;
    int qtdElementos;

    public MapaDispersao(int qtd) {

        this.qtd = qtd;
    }

    private int calcularHash(K chave) {

        return 0;
    }

    public boolean inserir(K chave, T valor) {

        setQtdElementos(getQtdElementos() + 1); // somando + 1 a cada elemento inserido
        return true;
    }

    public T remover(K chave) {

        // modificar campo valido para nullo apenas
        setQtdElementos(getQtdElementos() - 1); // retirando 1 na quantidade de elementos
        return null;
    }

    public T buscar(K chave) {

        return null;
    }

    public int quantosElementos() {
        return getQtdElementos();
    }

    private int getQtdElementos() { // retornando a qtd de elementos
        return qtdElementos;
    }

    private void setQtdElementos(int tamanho) {
        qtdElementos = tamanho;
    }
}