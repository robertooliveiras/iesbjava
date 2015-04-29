package br.iesb.posgraduacao.jogos.batalhanaval;

import java.util.Scanner;

public class Jogar {

	public static void main(String[] args) {String again;
		CampoBatalha jogo = new CampoBatalha(6);
		jogo.entrada = new Scanner(System.in);
		jogo.play();
		
		System.out.println("JOGAR NOVAMENTE?(S/N): ");
		again = jogo.entrada.nextLine();
		while(again.charAt(0) == 'S'){
			jogo.init();
			jogo.play();
			System.out.println("JOGAR NOVAMENTE?(S/N): ");
			again = jogo.entrada.nextLine();
		}
		jogo.entrada.close();
		System.out.println("FIM!");
	}
}
