package projetoAlbuns;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicaTest {

	Musica music;
	
	@BeforeEach
	void criarMusica() {
		
		Artista art = new Artista(10L, "Luan Guarnieri", LocalDate.of(2002, 2, 14), "Tudo");
		List<Artista> lista = new ArrayList<>();

		lista.add(art);
		
		music = new Musica(1L, "Musica teste", LocalDate.now(), lista);
	}
	
	@Test
	void alterarNomeLista() {
		music.setTitulo("Titulo modificado");
		assertEquals("Titulo modificado", music.getTitulo());
	}
	
	@Test
	void retornarExcecaoTitulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			music.setTitulo("A");
		});
	}
	
	@Test
	void alterarDataCriacaoLista() {
		DateTimeFormatter maskData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		music.setDataCriacao(LocalDate.of(2023, 4, 20));
		String data = music.getDataCriacao().format(maskData);
		
		assertEquals("20/04/2023", data);
	} 	
	
	@Test
	void retornarExcecaoData() {
		assertThrows(IllegalArgumentException.class, () -> {
			music.setDataCriacao(LocalDate.of(2024, 1, 10));
		});
	}
	
	@Test
	void validarListaArtistas() {
		assertFalse(music.getArtistas().isEmpty());
	} 	
	
	@Test
	void retornarExcecaoListaArtistas() {
		assertThrows(IllegalArgumentException.class, () -> {
			music.setArtistas(new ArrayList<Artista>());
		});
	}
}
