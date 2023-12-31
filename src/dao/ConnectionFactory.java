package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private ConnectionFactory() {}
	
	private static Connection conexao = null;
	
	public static Connection getConexao() throws SQLException {
		
		if(conexao == null) {
			String dbURL = "jdbc:mysql://localhost:3306/hotel1";
			String username = "root";
			String senha = "";
			
			Connection conexao = null;
			
			ConnectionFactory.conexao = DriverManager.getConnection(dbURL, username, senha);	
		}
		return conexao;
	
	}
	
}
