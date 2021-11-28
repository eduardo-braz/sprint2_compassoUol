import java.sql.Connection;
import java.util.List;

public class Controller {
	private FilmeDAO filmeDAO;
	
	public Controller() {
		Connection connection = new ConnectionFactory().conexao();
		this.filmeDAO = new FilmeDAO(connection);
	}

	public List<Filme> listar() {
		return this.filmeDAO.listar();
	}
	
	public void imprimeListaCompleta(List<Filme> filmes) {
		this.filmeDAO.imprimeListaCompleta(filmes);
	}
	
	public void imprimeLista(List<Filme> filmes, int inicio, int fim) {
		this.filmeDAO.imprimeLista(filmes, inicio, fim);
	}
	
}
