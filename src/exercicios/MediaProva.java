/**
 * Implementem um programa em Java que realiza o cálculo da média e exiba a mensagem "Aprovado" ou "Reprovado", conforme fluxograma abaixo:
 * 
 */
package exercicios;
/**
 * Esse pacote permite escanear entradas de dados
 */
import java.util.Scanner;
/**
 * @author RobertoOliveira
 *
 */
public class MediaProva {

	/**
	 * Tira a média entre duas notas
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		float M, p1, p2;
		
		System.out.println("Informe a nota P1: ");
		p1 = entrada.nextFloat();
        
        System.out.println("Informe a nota P2: ");
        p2 = entrada.nextFloat();
        
        M = ( p1 + p2 ) / 2;
    	System.out.println("Média = "+M);
        if(M >= 6.0){
        	System.out.println("Aprovado");
        } else {
        	System.out.println("Preprovado");
        }
        

	}

}
