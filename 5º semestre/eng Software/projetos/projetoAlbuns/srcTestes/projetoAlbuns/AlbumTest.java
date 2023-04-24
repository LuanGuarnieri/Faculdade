package projetoAlbuns;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlbumTest {
	
	Album alb;
	Musica music;
	List<Musica> musics;
	List<Artista> lista;

	@BeforeEach
	void criarAlbum() {
		Artista art = new Artista(10L, "Luan Guarnieri", LocalDate.of(2002, 2, 14), "Tudo");
		Artista art2 = new Artista(11L, "Cleiton da Quebrada", LocalDate.of(2002, 2, 13), "Tudo");
			
		lista = new ArrayList<>();

		lista.add(art);
		lista.add(art2);
		
		alb = new Album(1000, "Album Luan", LocalDate.now(), lista);
	}
	
	@Test
	void mudarTituloAlbum() {
		alb.setTitulo("Titulo 1");
		assertEquals("Titulo 1", alb.getTitulo());
	}
	
	@Test 
	void excecaoTituloInvalido() {
		assertThrows(IllegalArgumentException.class, () -> {
			alb.setTitulo("A");
		});
	}
	
	@Test
	void inserirMusica() {
		music = new Musica(1L, "Musica teste", LocalDate.now(), lista);
		alb.adicionarMusica(music);
		
		assertEquals(1, alb.getMusicas().size());
	}
	
	@Test
	void excecaoInserirMusica() {
		music = new Musica(1L, "Musica teste", LocalDate.now(), lista);
		alb.adicionarMusica(music);
		
		assertThrows(IllegalArgumentException.class, () -> {
			alb.adicionarMusica(music);
		});
	}
	
	@Test
	void excluirMusica() {
		music = new Musica(1L, "Musica teste", LocalDate.now(), lista);
		alb.adicionarMusica(music);
		
		assertTrue(alb.excluirMusica(1L));
	}
	
	@Test
	void excluirMusica2() {
		alb.excluirMusica(1L);
		assertFalse(alb.excluirMusica(1L));
	}

}
