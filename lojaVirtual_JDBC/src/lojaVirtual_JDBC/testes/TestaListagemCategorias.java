package lojaVirtual_JDBC.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import lojaVirtual_JDBC.CategoriaDAO;
import lojaVirtual_JDBC.ConnectionFactory;
import lojaVirtual_JDBC.ProdutoDAO;
import lojaVirtual_JDBC.modelo.Categoria;
import lojaVirtual_JDBC.modelo.Produto;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> listaCategoria = categoriaDao.listar();
			listaCategoria.stream().forEach(lc -> {
				System.out.println("Categoria: "+lc.getDescricao());
				try {
					for (Produto produto: new ProdutoDAO(connection).busca(lc)) {
						System.out.println(lc.getDescricao()+" - "+produto.getNome());
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			});
		}

	}

}
