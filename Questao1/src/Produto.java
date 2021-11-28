
public class Produto {
	
	private int id;
	private int quantidade;
	private double preco;
	private String nome;
	private String descricao;
	
	public Produto(int quantidade, double preco, String nome, String descricao) {
		this.setQuantidade(quantidade);
		this.setPreco(preco);
		this.setNome(nome);
		this.setDescricao(descricao);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
				"ID: %d\t Nome: %s\t Preço: R$ %.2f\t Quantidade: %d\t Descrição: %s", 
				this.id, this.nome, this.preco, this.quantidade ,this.descricao);
	}
	

}
