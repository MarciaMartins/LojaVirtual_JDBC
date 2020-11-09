package lojaVirtual_JDBC.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Integer id;
	private String descricao;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public Categoria(Integer id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		listaProdutos.add(produto);
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
}
