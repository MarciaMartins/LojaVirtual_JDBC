package lojaVirtual_JDBC.modelo;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
		
	public Produto(String nome, String descricao) {
		this.nome=nome;
		this.descricao=descricao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		
		return String.format("O produto foi adicionado %d, %s, %s", this.id, this.nome, this.descricao);
		
	}
	
	
}
