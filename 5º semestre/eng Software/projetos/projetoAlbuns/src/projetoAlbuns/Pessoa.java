package projetoAlbuns;

public abstract class Pessoa {
	
	private Long codPessoa;
	private String nome;
	private String nacionalidade; 
	
	public Pessoa(long codPessoa, String nome, String nacionalidade) {
		
		setCodPessoa( codPessoa );
		setNome( nome );
		setNascionalidade( nacionalidade );
	}

	public void setCodPessoa(long codPessoa) {
		if (codPessoa > 0) {
			this.codPessoa = codPessoa;
		
		} else {
			throw new IllegalArgumentException("Codigo de pessoa invalido");
		}
	}
	
	public long getCodPessoa() {
		return codPessoa;
	}

	public void setNome(String nome) {
		if (nome.length() > 3) {
			this.nome = nome;
			
		} else {
			throw new IllegalArgumentException("Nome devera conter pelo menos 4 caracteres");
		}
	}
	
	public void setNascionalidade(String nacionalidade) {
		if (nacionalidade.length() > 1) {
			this.nacionalidade = nacionalidade;
		
		} else {
			throw new IllegalArgumentException("Nacionalidade invalida");
		}
	}

	public String getNacionalidadeX() {
		return nacionalidade;
	}
	
	public String getNome() {
		return nome;
	}
}
