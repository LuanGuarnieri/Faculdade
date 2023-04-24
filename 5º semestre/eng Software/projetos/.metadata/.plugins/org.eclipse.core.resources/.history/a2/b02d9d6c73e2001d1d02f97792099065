package projetoAlbuns;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDadosDao {
	private Connection conexao;
	private final String url = "jdbc:mariadb://localhost:3306";
	private final String user = "root";
	private final String senha = "*****";
	
	public Connection getConexao() {
		
		if (conexao == null ) {
			try {
				conexao = DriverManager.getConnection(url, user, senha);
				
			} catch (Exception e) {
				throw new IllegalArgumentException("Erro ao estabalecer uma conexão com o banco");
			}
		}
		return conexao;
	}
}
