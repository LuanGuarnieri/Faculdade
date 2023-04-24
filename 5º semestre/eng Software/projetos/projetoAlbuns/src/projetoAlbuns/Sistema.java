package projetoAlbuns;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

	public void criarArtista(Long codPessoa, String nome, LocalDate nasc, String categoria) {
		new Artista(codPessoa, nome, nasc, categoria);

		// depois de criado, que passará pelas validações terá que gravar no banco
	}

	public void alterarArtista(Long codPessoa, String nome, LocalDate nasc, String categoria) {
		//busca o artista com o respectivo código, e faz o update os parametros
	}
	
	public void cadastrarAlbum(Long codAlbum, String titulo, LocalDate datCriacao, List<Artista> artistas) {
		new Album(codAlbum, titulo, datCriacao, artistas);

		// depois de criado, que passará pelas validações terá que gravar no banco
	}

	public void alterarAlbum(Long codAlbum, String titulo, LocalDate datCriacao, List<Artista> artistas) {
		//busca o album com o respectivo código, e faz o update os parametros
	}
	
	public boolean excluirAlbum(Long codAlbum) {
		boolean retorno = false;
		
		//busca o id no banco e efetua o delete
		return retorno;
	}
	
	public boolean excluirArtista(Long codArtista) {
		boolean retorno = false;
		
		//busca o id no banco e efetua o delete
		return retorno;
	}
	
	public List<Artista> buscarArtista(String nome) {
		List<Artista> artistas = new ArrayList<>();
		
		//Da um like %nome% no banco nos artistas e add na lista 
		
		return artistas;
	}
	
	public List<Album> gerarRelatorioAlbuns(Long codArtista, int tipoOrdenacao) {
		List<Album> albuns = new ArrayList<>();
		
		/*busca os dados no banco pelo id, monda o artista e usa o método
		  getAlbuns() que irá retornar um hashMap dos albuns do artista*/
		
		return albuns;
	}
	
	public List<Musica>buscarMusica(String nome) {
		List<Musica> musicas = null;
		
		//da um like %nome% no banco e joga as musicas na lista, dai retorna a mesma
		
		return musicas;
	}
	
	public List<Album>buscarAlbum(String nome) {
		List<Album> albuns = null;
		
		//da um like %nome% no banco e joga os albuns na lista, dai retorna a mesma
		
		return albuns;
	}

}
