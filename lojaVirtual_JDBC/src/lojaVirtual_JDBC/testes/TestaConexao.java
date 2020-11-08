package lojaVirtual_JDBC.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "1234");
		System.out.println("Conexão aberta");
		connection.close();
		System.out.println("Conexão fechada");
	}

}
