package module_costarica;

public class Jogador extends Comissao {
	protected final static String cargo = "JOGADOR";
	private int numero;
	private String posicao;
	private CostaRica selecao;

	public Jogador (String clube, String nome, String apelido, int altura, double peso, String datNasc, int numero, String pos, CostaRica selecao) {
		super (clube, nome, apelido, altura, peso, datNasc);
		this.selecao = selecao;
		this.setNumero  (numero);
		this.setPosicao (pos); 

	}

	//sets
	private void setNumero (int numero) {
		if (selecao.listaJogadores() == null 
			|| numero > 0
			&& selecao.listaJogadores().get(numero) == null ) {
				this.numero = numero;			
		} else {
			retornaExcecao( "Número inválido" ); 
		}
	}

	private void setPosicao (String pos) {
		if ( validarString(pos, 5) ) {
			boolean achou = false; 

				for (String aux : selecao.getPosicoes()) {

					if ( aux.equals(pos.toUpperCase()) ) {
						this.posicao = aux;
						achou = true;
						break;
					}
				}
			if (achou == false) {
				throw retornaExcecao("Posicao não encontrada jogador" + getNome());
			}

		} else {
			throw retornaExcecao("Posição com valor nullo ou tamanho mínimo inválido");
		}
	}
	//gets
	@Override
	public String getCargo() {
		return Jogador.cargo;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getPosicao() {
		return this.posicao;
	}
}