/**
 * 
 */
package br.iesb.graduacao.ads.lp.exercicios;

/**
 * @author RobertoOliveira
 *
 */
public class MontaPalavra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] wordListOne = {"24/7", "IESB", "alunos", "B-to-B", "todos ganham", "eduardo"
								, "baseado na web", "difundido", "inteligente", "seis", "sigma"
								, "caminho critico", " dinamico"};       

		String[] wordListTwo = {"Habilitado", "adesivo", "valor agregado", "rocha", "Central", "distribuido"
								, "agrupado", "solidificado", "independente", "posicionado", "em rede"
								, "dedicado", "compartilhado", "cooperativo", "acelerado"};       

		String[] wordListThree= {"processo", "forte", ",maximo", "solucao", "arquitetura", "Habilitacao do nucleo"
								, "estrategia", "mindshare", "portal", "espaço", "visap", "paradigma", "missao"};               

		//Descubra
		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;       

		//gere tres numeros aleatorios
		int rand1 = (int) (Math.random() * oneLength);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);
		
		//Contruir frase
		String phrase = wordListOne [rand1] + " " + wordListTwo [rand2] + " " + wordListThree [rand3];
		System.out.println("Precisamos de " + phrase);    
	}
}
