package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		String nome = "nome produto";
		String descricao = "descricao produto";
		ConnectionFactory connFactory = new ConnectionFactory();
		Connection connection = connFactory.getConnection();
		PreparedStatement stmt = (PreparedStatement) connection.
				prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)", 
						Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		
		stmt.execute();
		ResultSet rst = stmt.getGeneratedKeys();
		while (rst.next()) {
			System.out.println("novo Id:"+rst.getInt(1));
		}
		
		

	}

}
