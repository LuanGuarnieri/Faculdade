package projetoAlbuns;

import java.time.LocalDate;
import java.util.HashMap;

public class Artista extends Pessoa{

	private String categoria;
	private HashMap<Long, Album> albuns;

	public Artista(long codPessoa, String nome, LocalDate nasc, String categoria) {
		super(codPessoa, nome, nasc);
		setCategoria( categoria );
		
		albuns = new HashMap<>();	
	}
	
	public void criarAlbum(Album album) {
		Album aux = getAlbuns().get(album.getCodAlbum());
		
		if( aux == null ) {
			getAlbuns().put(album.getCodAlbum(), album);
		
		} else {
			throw new IllegalArgumentException("Album ja vinculado ao Artista");
		} 
	}
	
	public void setCategoria( String cat ) {
		if (cat.length() >=3 ) {
			this.categoria = cat;
			
		} else {
			throw new IllegalArgumentException("Categoria deve conter pelo menos 3 caracteres");
		}
	} 
	
	public HashMap<Long, Album> getAlbuns() {
		return albuns; 
	}
	
	public String getCategoria() {
		return this.categoria;
	}
}
