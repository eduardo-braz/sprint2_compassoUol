package Questao3;
/* Questão 3 da avaliação da Sprint 2 – 
 * Programa de Bolsas SpringBoot - Compass.UOL
 * @author Eduardo Braz de Campos
 * @link https://github.com/eduardo-braz/sprint2_compassoUol/
 * 
 */
public class Main {

	public static void main(String[] args) {

		String chateado = ":-(";
		String divertido = ":-)";
		
		String entrada = ":-):-(:-(:-)";
		
		int qntDivertido = contaOcorrencias(entrada, divertido);
		int qntChateado = contaOcorrencias(entrada, chateado);
		
		if (qntDivertido>qntChateado) {
			System.out.println("Divertido!");
		} else {
			if (qntChateado>qntDivertido) {
				System.out.println("Chateado!");
			} else {
				System.out.println("Neutro!");
			}
		}
		
		
	}
	
	/*
	 * Conta quantas vezes o padrão se repetiu na String "entrada"
	 * @param String - entrada
	 * @param String - padrao
	 * @return int - Contendo quantas vezes houve repetição do padrão
	 */
	public static int contaOcorrencias(String entrada, String padrao) {
		
		int ocorrencias = 0;
		/*
		 * Primeiro verifica se há pelo menos uma ocorrência do padrão, usando o String.contais(),
		 * se houver, iniciam duas variáveis "ultimaOcorrencia" e "pos", pegando a última ocorrência
		 * e a primeira, respectivamente. Um laço while é executado até que a referência "pos" alance
		 * a referência "ultimaOcorrencia".
		 * 
		 * Caso não encontre nenhuma, o método retorna zero.
		 */
		if (entrada.contains(padrao)) {
			int ultimaOcorrencia = entrada.lastIndexOf(padrao);
			int pos = entrada.indexOf(padrao);
			while (pos<ultimaOcorrencia) {
				pos = entrada.indexOf(padrao, pos);
				pos++;
				ocorrencias++;
			}		
		} 
		
		return ocorrencias;
		
	}

}
