package lojaVirtual_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaVirtual_JDBC.modelo.Categoria;
import lojaVirtual_JDBC.modelo.Produto;

public class ProdutoDAO {
	private Connection connection;
	
		public ProdutoDAO(Connection connection) {
			this.connection = connection;
		}
	
		public int inserir(Produto produto) throws SQLException {
			String sql = ("INSERT INTO PRODUTO(NOME, DESCRICAO) VALUES (?,?)");
			
			try(PreparedStatement stmt = 
					connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
												
				stmt.setString(1, produto.getNome());
				stmt.setString(2, produto.getDescricao());
				stmt.execute();
				try(ResultSet rst = stmt.getGeneratedKeys()){
					while(rst.next()) {
						
						produto.setId(rst.getInt(1));
						System.out.println("Id criado (ProdutoDAO): "+ rst.getInt(1));
					}
				}
			}
			return produto.getId();
		}

		public List<Produto> listar() throws SQLException {
			List<Produto> produtos = new ArrayList<Produto>();
			String sql = ("SELECT * FROM PRODUTO");
			try(PreparedStatement pstmt = connection.prepareStatement(sql)){
				pstmt.execute();
				try(ResultSet rst = pstmt.getResultSet()){
					while(rst.next()) {
						Produto produto = 
								new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
						produtos.add(produto);
					}
				}
			}
			return produtos;
		}
	
		public void excluir(Produto produto) throws SQLException {
			String sql = ("DELETE FROM PRODUTO WHERE ID = ?");
			try(PreparedStatement pstmt = connection.prepareStatement(sql)){
				pstmt.setInt(1, produto.getId());
				pstmt.executeUpdate();
		}
	}
		
		public void alterar(Produto produto) throws SQLException {
			String sql = ("UPDATE PRODUTO SET NOME=?, DESCRICAO=? where id = ?");
			try(PreparedStatement pstmt = connection.prepareStatement(sql)){
				pstmt.setString(1, produto.getNome());
				pstmt.setString(2, produto.getDescricao());
				pstmt.setInt(3, produto.getId());
				pstmt.execute();
			}
		}

		public List<Produto> busca(Categoria categoria) throws SQLException {
			List<Produto> produtos = new ArrayList<Produto>();
			String sql = ("SELECT * FROM PRODUTO WHERE CATEGORIA_ID=?");
			try(PreparedStatement pstmt = connection.prepareStatement(sql)){
				pstmt.setInt(1, categoria.getId());
				pstmt.execute();
				try(ResultSet rset = pstmt.getResultSet()){
					while(rset.next()) {
						Produto produto = new Produto(rset.getInt(1), rset.getString(2), rset.getString(3));
						produtos.add(produto);
					}
				}
			}
			return produtos;
		}
}

