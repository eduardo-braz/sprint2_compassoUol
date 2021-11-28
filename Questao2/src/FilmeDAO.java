import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

	private Connection connection;

	public FilmeDAO(Connection connection) {
		this.connection = connection;
	}

	 public List<Filme> listar() {
		List<Filme> filmes = new ArrayList<Filme>();
		try {	
			String mysql = "SELECT ID, NOME, DESCRICAO, ANO FROM FILMES";
			try (PreparedStatement pstm = connection.prepareStatement(mysql)) {
				pstm.execute();

				resultToFilmes(filmes, pstm);
			} 
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* "Converte" o ResultSet obtido através do prepared statement em objetos do tipo Filme
	 * @param List<Filme>
	 * @param PreparedStatement
	 */
	private void resultToFilmes(List<Filme> filmes, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Filme filme = new Filme(
						rst.getInt(1), rst.getInt(4), rst.getString(2), rst.getString(3)
						);
				filmes.add(filme);
			}
		}
	 }
	
	/* Imprime todos os filmes cadastrados na tabela filmes
	 * 
	 * @param List<Produto>
	 */
	public void imprimeListaCompleta(List<Filme> filmes) {
		filmes.forEach(System.out::println);
	}
	
	/* Imprime os últimos "elementos" da tabela filmes
	 * 
	 * @param List<Produto>
	 * @param int - inicio (Primeiro filme a imprimir)
	 * @param int - fim (Ultimo filme a imprimir)
	 */
	
	public void imprimeLista(List<Filme> filmes, int inicio, int fim) {
		filmes.forEach( x -> {
			if (x.getId()>=inicio && x.getId()<=fim)
				System.out.println(x.toString());
		});
	}


}
