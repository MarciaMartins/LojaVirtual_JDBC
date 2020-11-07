package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import lojaVirtual_JDBC.modelo.Produto;

public class TestaInsercaoClasseProduto {

	public static void main(String[] args) throws SQLException {
		Produto	produto = new Produto("Produto Classe 54", "produto descricao");
				
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()){
				new ProdutoDAO(connection).inserir(produto);
				
			}
		}

}
