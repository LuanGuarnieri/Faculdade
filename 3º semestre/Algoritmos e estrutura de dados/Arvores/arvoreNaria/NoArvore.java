package trabalho02Algoritmos.arvoreNaria;

/**
 * === CRIADORES ===
 * 
 * Luan L. Guarnieri e Maria Eduarda Krutzsch
 */

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	private int nivel; // variavel de nivel criada

	public NoArvore(T info) {
		this.info = info;

	}

	public String imprimePre() {
		String result = "<" + this.info.toString();

		if (this.getFilho() != null) {
			result += filho.imprimePre();
		}

		result += ">";

		if (this.getIrmao() != null) {
			result += "" + irmao.imprimePre();
		}

		return result;
	}

	public void inserirFilho(NoArvore<T> filho) {
		filho.setIrmao(this.getFilho());
		this.filho = filho;
		filho.setNivel(this.getNivel() + 1); // adicionado aqui

		// teste depois apagar
		System.out.println("pai : " + this.getInfo() + " filho: " + this.filho.getInfo() + " recebendo nivel : "
				+ filho.getNivel());
	}

	public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvore<T> no = null;
			if (this.getFilho() != null) {
				no = this.getFilho().pertence(info);
			}
			if (no == null && this.getIrmao() != null) {
				no = this.getIrmao().pertence(info);
			}
			return no;
		}
	}

	public NoArvore<T> getFilho() {
		return filho;
	}

	public NoArvore<T> getIrmao() {
		return irmao;
	}

	private void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	/*
	 * ==== METODOS PARA O TRABALHO A PARTIR DAQUI ====
	 * 
	 * Obs.: Adicionado o filho.setNivel( this.getNivel() + 1) no metodo
	 * inserirFilho()
	 * onde o filho recebe o nivel do pai + 1
	 */

	public boolean ehFolha() {
		return (this.filho == null);
	}

	public void setNivel(int i) {
		this.nivel = i;
	}

	public int getNivel() {
		return this.nivel;
	}

	public int returnAltura() {
		// Utilizado no getAltura02 - baseado no metodo imprimePre
		int altura = 0;

		if (ehFolha()) {
			altura = getNivel();
			// se for folha recebe o nivel
		}

		if (this.getFilho() != null) {
			int i = filho.returnAltura();
			// percorrendo até o ultimo filho

			if (i > altura) {
				altura = i;
			}
		}

		if (this.getIrmao() != null) {
			int i = irmao.returnAltura();
			// retornando nivel de no.filho caso no.irmão tiver

			if (i > altura) {
				altura = i;
				// se nivel retornado for maior retorna ele
			}
		}

		return altura;
	}

	public String returnStringNosFolha() {
		// metodo criado para pegar todos os nós folhas da arvore e add em String

		String nosFolha = "";

		if (ehFolha()) {
			nosFolha = nosFolha + getNivel() + ",";
			// se for folha recebe o nivel + ',' para futuamente quebrar em array
		}

		if (this.getFilho() != null) {
			nosFolha += filho.returnStringNosFolha();

		}

		if (this.getIrmao() != null) {
			nosFolha += irmao.returnStringNosFolha();
		}

		return nosFolha;
	}

}