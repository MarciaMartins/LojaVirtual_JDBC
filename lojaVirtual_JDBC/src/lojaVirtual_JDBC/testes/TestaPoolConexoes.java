package lojaVirtual_JDBC.testes;

import java.sql.SQLException;

import lojaVirtual_JDBC.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		
		for (int i = 1; i < 20; i++) {
			conFactory.getConnection();
			System.out.println("Numero conexao: "+i);
		}
		

	}

}
