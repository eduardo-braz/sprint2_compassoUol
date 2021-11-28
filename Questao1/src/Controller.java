import java.sql.Connection;
import java.util.List;

public class Controller {
	private ProdutoDAO produtoDAO;
	
	public Controller() {
		Connection connection = new ConnectionFactory().conexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void deletar(int id) {
		this.produtoDAO.deletar(id);
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
	}

	public void alterar(String nome, String descricao, int quantidade, double preco, int id) {
		this.produtoDAO.alterar(nome, descricao,quantidade, preco, id);
	}
	
	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}
	
	public void imprimeListaCompleta(List<Produto> produtos) {
		this.produtoDAO.imprimeListaCompleta(produtos);
	}
	
	public void imprimeLista(List<Produto> produtos, int elementos) {
		this.produtoDAO.imprimeLista(produtos, elementos);
	}
	
}
