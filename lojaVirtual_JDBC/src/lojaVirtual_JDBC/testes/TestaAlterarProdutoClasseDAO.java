package lojaVirtual_JDBC.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaVirtual_JDBC.ConnectionFactory;
import lojaVirtual_JDBC.ProdutoDAO;
import lojaVirtual_JDBC.modelo.Produto;

public class TestaAlterarProdutoClasseDAO {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Produto para alteracao", "PARA ALTERACAO Descricao de produto");
		ConnectionFactory factory = new ConnectionFactory();
		int idProdutoCriado;
		try(Connection connection = factory.getConnection()){
			List<Produto> listaProdutos = new ArrayList<>();
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			idProdutoCriado = produtoDAO.inserir(produto);
			
			System.out.println("====== Lista Completa com o produto id: "+idProdutoCriado +" =======");
			listaProdutos= produtoDAO.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
			
			System.out.println("====== Lista Alterado de produto id: "+idProdutoCriado +" =======");
			produto.setNome("Produto alterado");
			produto.setDescricao("ALTERADO Descricao de produto para alteracao");
			produtoDAO.alterar(produto);
			listaProdutos= produtoDAO.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
		

}
