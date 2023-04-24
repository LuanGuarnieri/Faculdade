package projetoAlbuns;

import java.util.List;

public class Musica {
	
	private Long codMusica;
	private String titulo;
	private float tempo;
	private List<Artista> artistas;
	
	public Musica(Long codMusica, String titulo, float tempo, List<Artista> artistas) {
		
		setCodMusica( codMusica );	
		setTitulo( titulo );
		setTempo( tempo );
		setArtistas( artistas );
	}

	private void setCodMusica(Long codMusica) {
		if( codMusica > 0 ) {
			this.codMusica = codMusica;
		
		} else {
			throw new IllegalArgumentException("Codigo de musica invalido");
		}
	}

	public void setTitulo(String titulo) {
		if( titulo.length() >=3 ) {
			this.titulo = titulo;
			
		} else {
			throw new IllegalArgumentException("Titulo da musica deve conter ao menos 3 caracteres");
		}
	}

	public void setTempo(float tempo) {
		try {
			if (tempo > 0.0) {
				this.tempo = tempo;
			
			} else {
				throw new Exception();
			} 
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Tempo de musica invalida");
		}
	}

	public void setArtistas(List<Artista> artistas) {
		if( !artistas.isEmpty() ) {
			this.artistas = artistas;
			
		} else {
			throw new IllegalArgumentException("Nenhum artista vinculado a musica");
		}
	}
	
	public Long getCodMusica() {
		return codMusica;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public float gettempo() {
		return tempo;
	}
	
	public List<Artista> getArtistas() {
		return artistas;
	}
	
}
