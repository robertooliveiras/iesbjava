package br.iesb.graduacao.ads.lp.UIA;

import java.util.Scanner;

public class DiaSemana{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);		
		System.out.println("Informe um número de 1 a 7: ");
		while(true){
			int diaDaSemana = entrada.nextInt();
			switch(diaDaSemana){		
			case 1:
				System.out.println("Domingo");
				break;		
			case 2:
				System.out.println("Segunda-feira");
				break;		
			case 3:
				System.out.println("Terça-feira");
				break;		
			case 4:
				System.out.println("Quarta-feira");
				break;		
			case 5:
				System.out.println("Quinta-feira");
				break;		
			case 6:
				System.out.println("Sexta-feira");
				break;		
			case 7:
				System.out.println("Sabado");
				break;
			default:
				System.out.println(diaDaSemana + " não um número válido, digite um número entre 1 e 7.");
			}
		}
	}
}