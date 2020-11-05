package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		//conexao com banco
		
		ConnectionFactory conFactory = new ConnectionFactory();
		
		Connection connection = conFactory.getConnection();
		
		Statement stmt = connection.createStatement();
		String sql =("INSERT inTO PRODUTO (nome, descricao) VALUES ('for�a', 'coragem' )");
		stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rst = stmt.getGeneratedKeys();
		while(rst.next()) {
			System.out.println("Id criado: "+ rst.getInt(1));
		}
		
		
		
		
		
		

	}

}
