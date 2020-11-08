package lojaVirtual_JDBC.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lojaVirtual_JDBC.ConnectionFactory;


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
