package br.iesb.graduacao.ads.lp.UIA;

import java.util.Scanner;

public class DoWhileR {

	public static void main(String[] args) {
		
		boolean continuar = true;
		
		int opcao;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			System.out.println("\t\tMenu de op��es a serem escolhidas:");
			System.out.println("\t1. Que n�mero voc� apertou?");
			System.out.println("\t2. Desculpe, n�o entendi");
			System.out.println("\t3. Voc� j� digitou? Digite de novo, ok?");
			System.out.println("\t4. O menu ser� apresentado novamente, ok?");
			System.out.println("\t5. N�o li, pode repetir por favor?");
			System.out.println("\t0. Sair.");
			
			System.out.println("\n Insira uma das op��es");
			opcao = entrada.nextInt();
			
			if(opcao == 0){
				continuar = false;
				System.out.println("Programa finalizado");
			}else{
				System.out.println("\n\n\n\n\n\n\n\n\n");
			}
			
		} while (continuar);

	}

}
