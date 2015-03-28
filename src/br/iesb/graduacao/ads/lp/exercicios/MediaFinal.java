package br.iesb.graduacao.ads.lp.exercicios;

import java.util.Scanner;

public class MediaFinal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double mediaFinal;
		double notas = 0;
		double nota = 0;
		double maiorNota = 0;
		double menorNota = 0;
		int contador = 0;
		int contadorReprovacoes = 0;
		int contadorAprovacoes = 0;
		boolean continuar = true;
		String opcao = "";
		
		System.out.println("Sistema de cálculo de média entre notas.\n" +
				"\nInsira notas de 0 a 10 para calcular a média." +
				"\nEnquanto você desejar digitar notas, informe S ou s;"+
				"\nSe você desejar terminar digite N ou n.\n\n");
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Deseja inserir uma nova nota entre 0 e 10?");
			opcao = entrada.next();
			
			if(opcao.equalsIgnoreCase("S")){
				System.out.println("Digite o valor da nota?");
				nota = entrada.nextDouble();
				if(nota >= 0 && nota <= 10){
					notas += nota;
					++contador;
					
					if(nota >= 0 && nota < 5){
						++contadorReprovacoes;
					}else if(nota >= 5 && nota <= 10){
						++contadorAprovacoes;
					}
					
					if(nota > maiorNota){
						maiorNota = nota;
					}
					
					if(nota < menorNota){
						menorNota = nota;
					}
					
				}else{
					System.out.println("OPA! A nota tem que ser entre 0 e 10?");
				}
			}else if(opcao.equalsIgnoreCase("N")){
				continuar = false;
			}else{
				System.out.println("OPA! NÃO ENTENDI! Deseja inserir uma nova nota?");
			}
			
		} while (continuar);
		
		mediaFinal = notas/contador;
		System.out.println("Média das notas: " + mediaFinal);
		System.out.println("Menor nota: " + menorNota);
		System.out.println("Maior nota: " + maiorNota);
		System.out.println("Quantidade de notas abaixo de 5: " + contadorReprovacoes);
		System.out.println("Quantidade de notas iguais ou superiores a 5: " + contadorAprovacoes);
	}

}
