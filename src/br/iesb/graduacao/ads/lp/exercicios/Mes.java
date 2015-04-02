package br.iesb.graduacao.ads.lp.exercicios;

import java.util.Scanner;

public class Mes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o dia do mês:");
		int dia = entrada.nextInt();
		entrada.close();
		
		if (dia >= 1 && dia <= 10){
			System.out.println("Estamos no início do mês");
		}else if(dia >= 11 && dia <= 20){
			System.out.println("Estamos no meio do mês");
		}else if(dia >= 21 && dia <= 31){
			System.out.println("Estamos no final do mês");
		}else{
			System.out.println("Número inválido");
		}
	}
}
