package module_costarica;
/*
 * Autor: Luan L. Guarnieri - POO 2022-2
 * */
public class ComissaoTecnica extends Comissao {
	protected String cargo;
	private CostaRica selecao;

	public ComissaoTecnica(String clube, String nome, String apelido, int altura, double peso, String datNasc, String cargo, CostaRica selecao) {
		super(clube, nome, apelido, altura, peso, datNasc);
		this.selecao = selecao;
		setCargo (cargo);
	} 

	public void setCargo (String cargo) {
		if (validarString(cargo, 4) ) {
			this.cargo = cargo;
		} else {
			throw retornaExcecao("Cargo nullo ou com tamamnho minimo inválido");
		}
	}
	public CostaRica getSelecao() {
		return this.selecao;
	}

}
