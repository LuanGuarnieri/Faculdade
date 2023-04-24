package projetoAlbuns;

import java.util.HashMap;

public class Artista extends Pessoa{

	private HashMap<Long, Album> albuns;

	public Artista(long codPessoa, String nome, String nacionalidade) {
		super(codPessoa, nome, nacionalidade);
		 
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
	
	public HashMap<Long, Album> getAlbuns() {
		return albuns; 
	}
}
