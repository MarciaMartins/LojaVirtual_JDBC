package lojaVirtual_JDBC;


import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaVirtual_JDBC.modelo.Produto;

public class TestaExclusaoProdutoClasseDAO {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("produto para exclusao", "descrição para produto excluido");
		
		int idCriado = 0;
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection =	factory.getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			idCriado = produtoDAO.inserir(produto);
			
			
			System.out.println("====== Lista Completa com o produto id: "+idCriado +" =======");
			listaProdutos= produtoDAO.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
			System.out.println("====== Lista Exclusao do produto id: "+idCriado +" =======");
			produtoDAO.excluir(produto);
			listaProdutos= produtoDAO.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}

}
