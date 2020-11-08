package lojaVirtual_JDBC.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lojaVirtual_JDBC.ConnectionFactory;


public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
				
		PreparedStatement stmt = connection.prepareStatement("Select * from produto");
		stmt.execute();
		ResultSet rst = stmt.getResultSet();
		
		while (rst.next()) {
			System.out.println(rst.getInt("ID"));
			System.out.println(rst.getString("Nome"));
			System.out.println(rst.getString("Descricao"));

		}
		
		
		
		connection.close();

	}

}
