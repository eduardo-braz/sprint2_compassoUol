
public class Filme {
	
	private int id;
	private int ano;
	private String nome;
	private String descricao;
	
	public Filme(int id, int ano, String nome, String descricao) {
		this.setId(id);
		this.setAno(ano);
		this.setNome(nome);
		this.setDescricao(descricao);
	}

	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
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
		return String.format(
				"ID: %d\t Filme: %s\t Ano: %d\t Descrição: %s", 
				this.id, this.nome, this.ano ,this.descricao);
	}
	

}
