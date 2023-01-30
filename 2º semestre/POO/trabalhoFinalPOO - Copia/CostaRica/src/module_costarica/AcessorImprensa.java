package module_costarica;
/*
 * Autor: Luan L. Guarnieri - POO 2022-2
 * */
public class AcessorImprensa extends Comissao {

	private static final String cargo = "ACESSOR DE IMPRENSA";
	private String tel1;
	private String tel2;
	private String email;
	@SuppressWarnings("unused")
	private CostaRica selecao;

	public AcessorImprensa(String clube, String nome, String apelido, int altura, double peso, String datNasc,
			String tel1, String tel2, String email, CostaRica selecao) {
		super(clube, nome, apelido, altura, peso, datNasc);
		setTel1(tel1);
		setTel2(tel2);
		setEmail(email);
		this.selecao = selecao;
	}

	// sets
	private void setTel1(String tel1) {
		if (tel1 != null && tel1.length() == 8) {
			this.tel1 = "+504" + tel1;
		} else {
			throw retornaExcecao("Número principal inválido!");
		}
	}

	private void setTel2(String tel2) {
		if (tel2 != null && tel2.equals("+504" + tel1)) {
			throw retornaExcecao("Número secundário igual ao principal");

		} else if (tel2 != null && tel2.length() == 8) {
			this.tel2 = "+34" + tel2;

		} else {
			throw retornaExcecao("Número secundário inválido");
		}
	}

	private void setEmail(String email) {
		if (email != null && email.length() > 5 && email.contains("@")) {
			this.email = email;
		} else {
			throw retornaExcecao("Email inválido");
		}
	}

	// gets
	@Override
	public String getCargo() {
		return AcessorImprensa.cargo;
	}

	public String getTel1() {
		return this.tel1;
	}

	public String getTel2() {
		return this.tel2;
	}

	public String getEmalil() {
		return this.email;
	}
}
