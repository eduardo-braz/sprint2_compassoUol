import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	
	public void salvar(Produto produto) {
		try {			
			String mysql = "INSERT INTO PRODUTO (NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES (?, ?, ?, ?)";
			
			try (PreparedStatement pstm = connection.prepareStatement(mysql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());
				pstm.setInt(3, produto.getQuantidade());
				pstm.setDouble(4, produto.getPreco());
				
				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	 public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {	
			String mysql = "SELECT ID, NOME, DESCRICAO, QUANTIDADE, PRECO FROM PRODUTO";
			try (PreparedStatement pstm = connection.prepareStatement(mysql)) {
				pstm.execute();

				resultToProduto(produtos, pstm);
			} 
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* "Converte" o ResultSet obtido através do prepared statement em objetos do tipo Produto
	 * @param List<Produto>
	 * @param PreparedStatement
	 */
	private void resultToProduto(List<Produto> produtos, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Produto produto = new Produto(
						rst.getInt(4), rst.getDouble(5), rst.getString(2), rst.getString(3)
						);
				produto.setId(rst.getInt(1));
				produtos.add(produto);
			}
		}
	 }
	
	/* Exclui o produto referente a ID informada
	 * @param int - id
	 */
	 	

	public void deletar(int id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* Altera / Update de produto
	 * 
	 * @param String - nome
	 * @param String - descricao
	 * @param int - quantidade
	 * @param double - preco
	 * @param int - id
	 */
		

	public void alterar(String nome, String descricao, int quantidade, double preco, int id) {
		try (PreparedStatement stm = connection.prepareStatement(
				"UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ?, P.QUANTIDADE = ?, P.PRECO = ? WHERE ID = ?")) 
		{
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.setInt(3, quantidade);
			stm.setDouble(4, preco);
			stm.setInt(5, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* Imprime todos os produtos cadastrados na tabela produtos
	 * 
	 * @param List<Produto>
	 */
	public void imprimeListaCompleta(List<Produto> produtos) {
		produtos.forEach(System.out::println);
	}
	
	/* Imprime os últimos "elementos" da tabela produtos
	 * 
	 * @param List<Produto>
	 * @param int - elementos
	 */
	
	public void imprimeLista(List<Produto> produtos, int elementos) {
		int tam = produtos.size();
		for (int i=elementos; i>0; i--) {
			//tam--;
			System.out.println(produtos.get(tam-i));
		}
	}


}
