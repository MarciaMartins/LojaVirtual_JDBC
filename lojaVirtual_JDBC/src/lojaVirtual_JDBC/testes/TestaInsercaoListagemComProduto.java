package lojaVirtual_JDBC.testes;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaVirtual_JDBC.ConnectionFactory;
import lojaVirtual_JDBC.ProdutoDAO;
import lojaVirtual_JDBC.modelo.Produto;

public class TestaInsercaoListagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Novo produto DAO", "Descricao produto DAO");
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		ConnectionFactory factory = new ConnectionFactory();
		//Inclusao do produto DAO
		try(Connection connection =
				factory.getConnection()){
			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
				produtoDAO.inserir(produto);
				listaProdutos = produtoDAO.listar();
				listaProdutos.stream().forEach(lp -> System.out.println(lp));
		
		}
	
		
	}
}
