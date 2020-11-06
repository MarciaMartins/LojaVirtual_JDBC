package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import lojaVirtual_JDBC.modelo.Produto;

public class TestaInsercaoClasseProduto {

	public static void main(String[] args) throws SQLException {
		Produto	produto = new Produto("Produto Classe", "produto descricao");
		
		
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()){
			String sql = ("INSERT INTO PRODUTO(NOME, DESCRICAO) VALUES (?,?)");
			try(PreparedStatement stmt = 
					connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
												
				stmt.setString(1, produto.getNome());
				stmt.setString(2, produto.getDescricao());
				stmt.execute();
				try(ResultSet rst = stmt.getGeneratedKeys()){
					while(rst.next()) {
						
						produto.setId(rst.getInt(1));
						System.out.println("Id criado: "+ rst.getInt(1));
					}
				}
				
			}
			
		}
		System.out.println(produto);
	}
	
	
}
