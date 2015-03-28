package br.iesb.graduacao.ads.lp.UIA;

import java.util.Scanner;

public class DoWhileR2 {

	public static void main(String[] args) {
		
		boolean continuar = true;		
		int opcao;
		
		String um  = "\nQue n�mero voc� apertou?";
		String dois  = "\nDesculpe, n�o entendi";
		String tres  = "\nVoc� j� digitou? Digite de novo, ok?";
		String quatro  = "\nO menu ser� apresentado novamente, ok?";
		String cinco  = "\nN�o li, pode repetir por favor?";
		
		System.out.println("\t\tMenu de op��es a serem escolhidas:");
		System.out.println("\t1. Que n�mero voc� apertou?");
		System.out.println("\t2. Desculpe, n�o entendi");
		System.out.println("\t3. Voc� j� digitou? Digite de novo, ok?");
		System.out.println("\t4. O menu ser� apresentado novamente, ok?");
		System.out.println("\t5. N�o li, pode repetir por favor?");
		System.out.println("\t0. Sair.");
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("\n Insira uma das op��es");
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
				System.out.println("\nDigite uma op��o v�lida");
				break;
			}

			
		} while (continuar);

	}

}
