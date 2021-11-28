/* Questão número 2 apresentada a avaliação da sprint 2
 * do Programa de Bolsas SpringBoot Compasso UOL
 * 
 * @author Eduardo Braz 
 * @link 
 * @date 11/27/2021
 */


import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {

    	Controller controller = new Controller();
    	List<Filme> filmes = controller.listar();
    	int numFilmesPagina;  // Quantidade filmes por página
    	int qntPaginas;		  // Quantidade de páginas a exibir
    	int pagSelecionada;	  // Pagina selecionada pelo usuário
    	
    	int min=1;  
    	int max=20;
    	
    	do {
    		System.out.println("Insira a quantidade de filmes por página: ");
    		numFilmesPagina = validaEntradaMenu(min,max);
    	} while (numFilmesPagina<min || numFilmesPagina>max);
    	    	
				
		if (max%numFilmesPagina==0)
			qntPaginas = 20/numFilmesPagina;
		else
			qntPaginas = (20/numFilmesPagina)+1;
		
		
    	do {
    		System.out.println("Qual página deseja visualizar (entre 1 a "
    					+ qntPaginas + "): ");
    		pagSelecionada = validaEntradaMenu(min,qntPaginas);
    	} while (pagSelecionada<min || pagSelecionada>qntPaginas);
    	
    	
    	imprimePaginado(filmes, controller, numFilmesPagina, max, pagSelecionada);
        
    }

    /* Método para validação de entrada inserida pelo usuário 
     * @param int - min
     * @param int - max
     * @return int - Opção desejada 
     */
    public static int validaEntradaMenu(int min, int max) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
		int opcao=0;
		try {
			do {
				opcao = input.nextInt();
				if (opcao<min || opcao>max) {
                    limpaSaida();
					System.out.println("OPÇÃO INVÁLIDA!");
				}
			} while (opcao<min || opcao>max);
			return opcao;
		} catch (Exception e) {
            limpaSaida();
			System.out.println("OPÇÃO INVÁLIDA!");
			return validaEntradaMenu(min, max);
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
    
    /* Exibe os filmes selecionados 
     * 
     * @param List<Filme> Lista com filmes
     * @param Controller
     * @param int numFilmesPagina Quantidade de filmes por página
     * @param int max Quantidade de filmes cadastrados na base
     * @param int pagSelecionada Página selecionada para exibição
     * 
     */
      
    public static void imprimePaginado(List<Filme> filmes, Controller controller, int numFilmesPagina, int max, int pagSelecionada) {
    	int primeiro = (numFilmesPagina*pagSelecionada)-(numFilmesPagina-1);
    	int ultimo = (numFilmesPagina*pagSelecionada);
    	
    	if (ultimo>max)
    		ultimo=max;
    	controller.imprimeLista(filmes, primeiro, ultimo);
    	
    }
}