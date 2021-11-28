/* Questão número 1 apresentada a avaliação da sprint 2
 * do Programa de Bolsas SpringBoot Compasso UOL
 * 
 * @author Eduardo Braz 
 * @link 
 * @date 11/27/2021
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        List<Produto> produtos = new ArrayList<Produto>();
        // Lista com 3 produtos a serem adicionados
        produtos.add(new Produto(5, 3.90, "Bolinha", "Bolinha cravo anti-estresse"));
        produtos.add(new Produto(2, 29.90, "Cama pet", "Cama para pet tamanho 50x40"));
        produtos.add(new Produto(3, 27.90, "Comedouro Inox", "Comedouro tigela Inox duplo"));
        // **** //
    	Controller controller = new Controller();
    	int op;
    	
    	do {
    		menu();
    		op = validaEntradaMenu();
    		switch (op) {
    			case 0:	
    				break;
    			case 1: 
    				limpaSaida();
    				cadastraProdutos(controller, produtos);
    				//controller.imprimeLista(controller.listar(), 3);
    				break;
    			case 2:
    				limpaSaida();
    				alteraProduto(controller, produtos.get(0));
    				break;
    				
    			case 3: 
    				limpaSaida();
    				excluiProduto(controller, produtos.get(1));
    				break;
    		}			
    	} while (op!=0);    
        
    }

    /* Método para validação de entrada inserida pelo usuário de acordo com os seguintes requisitos:
    * 
    * 1 - Cadastra três produtos automaticamente na base
    * 2 - Atualiza o primeiro cadastrado na opção 1
    * 3 - Exclui o segundo produto cadastrado
    * 0 - Finaliza a aplicação
    * 
    * 
    * @return int - Opção desejada 
    */
    public static int validaEntradaMenu() throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
		int opcao=0;
		try {
			do {
				opcao = input.nextInt();
				if (opcao<0 || opcao>3) {
                    limpaSaida();
					System.out.println("OPÇÃO INVÁLIDA!");
				}
			} while (opcao<0 || opcao>3);
			return opcao;
		} catch (Exception e) {
            limpaSaida();
			System.out.println("OPÇÃO INVÁLIDA!");
			return validaEntradaMenu();
		}
    }

    /* Limpa saída do terminal
    *   
    */
    public static void limpaSaida() throws IOException, InterruptedException{
    	  try{
              String operatingSystem = System.getProperty("os.name");
              if(operatingSystem.contains("Windows")){        
                  Process startProcess = new ProcessBuilder(
                		  "cmd", "/c", "cls").inheritIO().start();
                  startProcess.waitFor();
              } else {
                  Process startProcess = new ProcessBuilder(
                		  "clear").inheritIO().start();
                  startProcess.waitFor();
              } 
          }catch(Exception e){
        	  throw new RuntimeException(e);
          }
    }
  

    /* Retorna ID de um produto cadastrado na base
    *
    * @param Controller 
    * @param Produto 
    * @return int - ID do produto
    */
    public static void menu(){
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Cadastra três produtos automaticamente na base");
        System.out.println("2 - Atualiza o primeiro cadastrado na opção 1");
        System.out.println("3 - Exclui o segundo produto cadastrado");
        System.out.println("0 - Finaliza a aplicação");
    }

    public static void cadastraProdutos(Controller controller, List<Produto> produtos) {

        for (int i=0; i<produtos.size(); i++) {
        	controller.salvar(produtos.get(i));
        }      
        System.out.println("\nProdutos cadastrados com sucesso!\n");
    }
    
    
    private static int idProduto(Controller controller, Produto produto) {
    	controller.listar().forEach(
    			x-> {
    	    		if (x.getNome().equalsIgnoreCase(produto.getNome())) {
    	    			produto.setId(x.getId());
    	    		}
        		}		
        	);
    	return produto.getId();
    }
    
    
    /* Método para a opção 2, altera automaticamente o primeiro produto
     * cadastrado na opção 1
     * 
     * @param Controller 
     * @param Produto 
     */
    public static void alteraProduto(Controller controller, Produto produto) {
    	controller.alterar("Bolinha", "Bolinha azul cravo anti-estresse", 2, 3.90, 
    			idProduto(controller, produto));
        System.out.println("\nProduto alterado com sucesso!\n");
    }

    /* Método para a opção 3, exclui automaticamente o segundo produto
     * cadastrado na opção 1
     * 
     * @param Controller 
     * @param Produto 
     */
    public static void excluiProduto(Controller controller, Produto produto) {
    	int id = idProduto(controller, produto);
    	if (busca(controller,id)) {
        	controller.deletar(id);
        	System.out.println("\nProduto excluído com sucesso!\n");
    	} else {
    		System.out.println("\nProduto já excluído anteriormente!\n");
    	}
    			

    }
    
    /* Verifica se existe um produto cadastrado na base com este ID
     * 
     * @param Controller
     * @param int id 
     * @return boolean - contem
     */
	public static boolean busca(Controller controller, int id) {
		boolean contem = false;
		List<Produto> produtos = controller.listar();
		
		for (int i=0; i<produtos.size();i++) {
			if (produtos.get(i).getId() == id) {
				contem = true;
				return contem;
			}
		}
		return contem;
	}
}