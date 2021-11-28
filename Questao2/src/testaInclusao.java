import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testaInclusao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
        List<Filme> filmes = new ArrayList<Filme>();
        
        
        Controller controller = new Controller();
        
        

        
        /*
		
		try (Connection connection = new ConnectionFactory().conexao()) {
			//connection.setAutoCommit(false);
			 System.out.println("Conectado");
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			
			
			for (int i=0; i<produtos.size();i++) {
				produtoDao.salvar(produtos.get(i));
			}
			
			
			produtos = produtoDao.listar();
			produtos.forEach(System.out::println);
			
		}


        */
       
        
        
	}

}
