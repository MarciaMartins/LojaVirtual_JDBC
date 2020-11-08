package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaVirtual_JDBC.modelo.Categoria;

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
}
