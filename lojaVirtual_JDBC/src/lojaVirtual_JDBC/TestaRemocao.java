package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conFac = new ConnectionFactory();
		Connection connection = conFac.getConnection();
		
		Statement stmt = connection.createStatement();
		stmt.execute("DELETE From PRODUTO WHERE ID>2");
		
		Integer qtdLinhas = stmt.getUpdateCount();
		System.out.println("Qtd de linhas exclu�das: "+qtdLinhas);
		
		connection.close();
		
		

	}

}
