package br.iesb.graduacao.ads.lp.UIA;

import java.util.Scanner;

public class DoWhileR2 {

	public static void main(String[] args) {
		
		boolean continuar = true;		
		int opcao;
		
		String um  = "\nQue numero voce apertou?";
		String dois  = "\nDesculpe, não entendi";
		String tres  = "\nVocê já digitou? Digite de novo, ok?";
		String quatro  = "\nO menu será apresentado novamente, ok?";
		String cinco  = "\nNão li, pode repetir por favor?";
		
		System.out.println("\t\tMenu de opções a serem escolhidas:");
		System.out.println("\t1. "+um);
		System.out.println("\t2. "+dois);
		System.out.println("\t3. "+tres);
		System.out.println("\t4. "+quatro);
		System.out.println("\t5. "+cinco);
		System.out.println("\t0. Sair.");
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("\n Insira uma das opções acima");
			opcao = entrada.nextInt();
			
			switch(opcao){
			case 0:
				continuar = false;
				System.out.println("\nSair.");
				System.out.println("\nPrograma finalizado");
				break;
			case 1:
				System.out.println(um);
				break;
			case 2:
				System.out.println(dois);
				break;
			case 3:
				System.out.println(tres);
				break;
			case 4:
				System.out.println(quatro);
				break;
			case 5:
				System.out.println(cinco);
				break;
			default:
				System.out.println("\nDigite uma opção válida");
				break;
			}

			
		} while (continuar);

	}

}
