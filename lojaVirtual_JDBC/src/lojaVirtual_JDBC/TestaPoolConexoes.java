package lojaVirtual_JDBC;

import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		
		for (int i = 1; i < 20; i++) {
			conFactory.getConnection();
			System.out.println("Numero conexao: "+i);
		}
		

	}

}
