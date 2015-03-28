package br.iesb.graduacao.ads.lp.UIA;

import java.util.Scanner;

public class DoWhileR {

	public static void main(String[] args) {
		
		boolean continuar = true;
		String um  = "\nQue numero voce apertou?";
		String dois  = "\nDesculpe, não entendi";
		String tres  = "\nVocê já digitou? Digite de novo, ok?";
		String quatro  = "\nO menu será apresentado novamente, ok?";
		String cinco  = "\nNão li, pode repetir por favor?";
		
		int opcao;
		
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
			
			if(opcao == 0){
				continuar = false;
				System.out.println("Programa finalizado");
			}else{
				System.out.println("\n\n\n\n\n\n\n\n\n");
			}
			
		} while (continuar);

	}

}
