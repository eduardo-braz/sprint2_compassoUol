import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testaInclusao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
        List<Produto> produtos = new ArrayList<Produto>();
        // Lista com 3 produtos a serem adicionados
        //produtos.add(new Produto(5, 3.90, "Bolinha", "Bolinha cravo anti-estresse"));
        //produtos.add(new Produto(2, 29.90, "Cama pet", "Cama para pet tamanho 50x40"));
        //produtos.add(new Produto(3, 27.90, "Comedouro Inox", "Comedouro tigela Inox duplo"));
		
        Controller controller = new Controller();
        
        
        produtos = controller.listar();
		produtos.forEach(System.out::println);
        
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
