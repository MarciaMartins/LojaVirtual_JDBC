package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conFac = new ConnectionFactory();
		Connection connection = conFac.getConnection();
		
		PreparedStatement stmt = connection.prepareStatement("DELETE From PRODUTO WHERE ID>2");
		stmt.execute();
		
		Integer qtdLinhas = stmt.getUpdateCount();
		System.out.println("Qtd de linhas exclu�das: "+qtdLinhas);
		
		connection.close();
		
		

	}

}
