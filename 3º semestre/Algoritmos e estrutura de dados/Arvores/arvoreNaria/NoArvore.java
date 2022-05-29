package trabalho02Algoritmos.arvoreNaria;

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	private int nivel;

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
			result += irmao.imprimePre();
		}

		return result;
	}

	public void inserirFilho(NoArvore<T> filho) {
		filho.setIrmao(this.getFilho());
		this.filho = filho;
		filho.setNivel(this.getNivel() + 1);

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

	public boolean ehFolha() {
		return (this.filho == null);
	}

	public void setNivel(int i) { // recebendo o nivel
		this.nivel = i;
	}

	public int getNivel() { // retornando o nivel
		return this.nivel;
	}

}