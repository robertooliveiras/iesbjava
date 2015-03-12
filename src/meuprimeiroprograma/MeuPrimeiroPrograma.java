/**
 * Fazendo tudo denovo.
 * Indique qual é o pacote da classe
 * O pacote é algo criado pelo próprio desenvolvedor, serve para organizar o código e funções
 * @author RobertoOliveira
 */
package meuprimeiroprograma;

/**
 * Agora é só criar sua classe
 * A classe precisa ter o mesmo nome do arquivo
 * public é especificador do tipo modificador de visibilidade. o tipo public
 *        é o tipo que pode ser acessado e utilizado por qualquer outra classe
 * class é a declaração de classe
 */
public class MeuPrimeiroPrograma{
	/**
	 * Agora é só criar o método
	 * public é um qualificador do método, ele pode ser enxergado de qualquer lugar da aplicação
	 * static significa que é um método da classe, não do objeto
	 * void é um tipo de retorno. significa que a classe não retorna nada ou retorna vazio
	 * main é o nome do método
	 * o método main recebe argumentos na variável args que é um array (por causa do []) de objetos do tipo String
	 * @param args
	 */
	public static void main(String[] args){
		//esse é um comentário em java
		// o "/**/" também é comentário java
		/* nenhum trecho de código comentado aparece na saída*/
		System.out.println("Escrenvendo o meu primeiro programa!");
		System.out.println("System.out.println é um comando que " +
							"\n 1) informa ao sistema (System);" +
							"\n 2) que será realizada uma saída(out);" +
							"\n 3) e que essa saída consiste em uma impressão com quebra de linha (println).");
	}
}
