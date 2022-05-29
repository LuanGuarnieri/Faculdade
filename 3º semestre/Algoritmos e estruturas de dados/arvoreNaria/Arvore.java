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


    public NoArvore<T> pertence2(T info) {
		if (this.vazia()) {
			return null;
		}
		return raiz.pertence2(info);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}


    private NoArvore<T> getRaiz(){
        return this.raiz;
    }

    public int altura(){
    
        int i = 0;

        raiz.pertence(null);
        

        return i;
    }

    public int getNivel(T valor){
        NoArvore<T> aux = pertence(valor);
        int nivelArvore = 0;
        
        if(aux == null){
                nivelArvore = -1;
        }else{
            nivelArvore = aux.getNivel();
        }
        return nivelArvore;

        
    }
}
