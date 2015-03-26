/**
 * Exercicio 1
 */
package br.iesb.graduacao.ads.lp.exercicios;

/**
 * Esse pacote permite escanear entradas de dados
 */
import java.util.Scanner;

/**
 * 
 * O Indice de Massa Corporal eh uma medida utilizada para medir a obesidade adotada pela 
 * Organizacao Mundial de Saude (OMS). Eh o padrao internacional para avaliar o grau de obesidade
 * 
 * IMC = Peso/(altura*altura)  //Peso em Kg dividido pelo quadrado do valor da altura em metros
 * 
 * @author RobertoOliveira
 *
 */
public class IndiceMassaCorporal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        float IMC, altura, peso;
        
        System.out.println("Informe a altura (metros): ");
        altura = entrada.nextFloat();
        
        System.out.println("Informe o peso (kg): ");
        peso = entrada.nextFloat();
        
        entrada.close();
        
        IMC = peso / (altura * altura);
        System.out.println("O IMC de uma pessoa que pesa "+peso+" kg e tem "+altura+"m de altura é : " + IMC);
	}
}
