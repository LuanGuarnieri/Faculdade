package projetoAlbuns;

import java.time.LocalDate;

public abstract class Pessoa {
	
	private long codPessoa;
	private String nome;
	private LocalDate nasc;
	
	
	public Pessoa(long codPessoa, String nome, LocalDate nasc) {
		
		setCodPessoa( codPessoa );
		setNome( nome );
		setNasc( nasc );
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

	public void setNasc(LocalDate nasc) {
		try {
			if (nasc.isBefore(LocalDate.now())) {
				this.nasc = nasc;
			
			} else {
				throw new Exception();
			} 
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Data informada invalida");
		}
	}
	
	public LocalDate getNasc() {
		return nasc;
	}
	
	public String getNome() {
		return nome;
	}
}
