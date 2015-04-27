package br.iesb.posgraduacao.uteis;

import java.util.Scanner;

public class EntradaDados {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String input = entrada.nextLine();
		System.out.println(input.length());
		System.out.println(input.charAt(4));
	}

}
