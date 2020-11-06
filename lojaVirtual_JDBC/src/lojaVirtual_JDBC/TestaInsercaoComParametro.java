package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		try(Connection connection = connFactory.getConnection()){
		connection.setAutoCommit(false);
		
		try (PreparedStatement stmt = 
				(PreparedStatement) connection.
					prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)", 
							Statement.RETURN_GENERATED_KEYS)){
			
			adicionarVariavel("nome produto 42", "descricao produto", stmt);
			adicionarVariavel("radio", "descricao produto", stmt);
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RollBack executado");
			connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stmt) throws SQLException {
		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		
//		if(nome.equals("radio")) {
//			throw new RuntimeException("Nao foi possivel adicionar produto");
//		}
		
		stmt.execute();
		try(ResultSet rst = stmt.getGeneratedKeys()){
		while (rst.next()) {
			System.out.println("novo Id:"+rst.getInt(1));
			}
		}
	}
}
