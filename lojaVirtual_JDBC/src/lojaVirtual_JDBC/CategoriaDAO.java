package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaVirtual_JDBC.modelo.Categoria;
import lojaVirtual_JDBC.modelo.Produto;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection=connection;
	}
	
	public List<Categoria> listar() throws SQLException{
		ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
		
		String sql = ("SELECT ID, NOME FROM CATEGORIA");
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.execute();
			try(ResultSet rset = pstmt.getResultSet()){
				while(rset.next()) {
					Categoria categoria = new Categoria(rset.getInt(1), rset.getString(2));
					listaCategoria.add(categoria);
				}
			}
		}
		return listaCategoria;
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		Categoria referencia = null;
		Categoria categoria = null;
		ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
		
		String sql = ("SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN "
				+ "PRODUTO P ON C.ID = P.CATEGORIA_ID ");
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.execute();
			try(ResultSet rset = pstmt.getResultSet()){
				while(rset.next()) {
					if(referencia == null || !referencia.getDescricao().equals(rset.getString(2))) {
						categoria = new Categoria(rset.getInt(1), rset.getString(2));
						listaCategoria.add(categoria);
						referencia = categoria; 
					}

					Produto produto 
						= new Produto(rset.getInt(3), rset.getString(4), rset.getString(5));
					categoria.adicionar(produto);
				}
			}
		}
		return listaCategoria;
	}
}
