package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
				
		Statement stmt = connection.createStatement();
		stmt.execute("Select * from produto");
		ResultSet rst = stmt.getResultSet();
		
		while (rst.next()) {
			System.out.println(rst.getInt("ID"));
			System.out.println(rst.getString("Nome"));
			System.out.println(rst.getString("Descricao"));

		}
		
		
		
		connection.close();

	}

}
