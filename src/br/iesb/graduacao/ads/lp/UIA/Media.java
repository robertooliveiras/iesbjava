package br.iesb.graduacao.ads.lp.UIA;

import java.util.Scanner;

public class Media {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float a;
		float b;
		float m;
		String resposta; 
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o primeiro número: ");
		a = entrada.nextFloat();
		
		System.out.println("Informe o segundo número: ");
		b = entrada.nextFloat();
		
		entrada.close();
		
		m = (a + b) / 2;
		resposta = "A média entre "+a+" e "+b+" é "+m;
		
		System.out.println(resposta);
		

	}

}
