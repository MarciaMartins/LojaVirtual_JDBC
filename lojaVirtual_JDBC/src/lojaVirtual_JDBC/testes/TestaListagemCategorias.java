package lojaVirtual_JDBC.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import lojaVirtual_JDBC.CategoriaDAO;
import lojaVirtual_JDBC.ConnectionFactory;
import lojaVirtual_JDBC.modelo.Categoria;
import lojaVirtual_JDBC.modelo.Produto;


public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			
			List<Categoria> listaCategoria = categoriaDao.listarComProdutos();
			
			listaCategoria.stream().forEach(ct -> {
				System.out.println("Categoria: "+ct.getDescricao());
				for(Produto produto: ct.getListaProdutos()) {
					System.out.println(ct.getDescricao() +" - "+produto.getNome());
				}

			});
		}

	}

}
