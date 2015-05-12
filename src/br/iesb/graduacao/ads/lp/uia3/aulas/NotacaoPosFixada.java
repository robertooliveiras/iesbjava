package br.iesb.graduacao.ads.lp.uia3.aulas;

import java.util.Scanner;

public class NotacaoPosFixada {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in); 
	System.out.println("informe a notação pós fixada:");
	String input = scanner.nextLine();
	StringBuffer numBuffer = new StringBuffer();
	Pilhas p = new Pilhas();
	for (int i = 0; i < input.length(); i++) {
	    char c = input.charAt(i);

	    if (Character.isDigit(c) || c == ',' || c == '.') {
		numBuffer.append(c);
	    } else {
		if (numBuffer.length() > 0) {
		    try {
			float numero = Float.parseFloat(numBuffer.toString());
			//trecho de código que falta que empilha o número na pilha
			numBuffer.append(numero);
		    } catch (NumberFormatException nfe) {
			System.out.println("ERRO de sintaxe!");
			return;
		    } finally {
			numBuffer = new StringBuffer();
		    }
		}
		//Trecho de código que falta que deve tratar os operandos!
		System.out.println(numBuffer.length());
	    }
	}
	//Trecho de código que falta que desempilha o número que ficou na pilha 
	//e exibe o resultado do cálculo
//	p.desempilhar();
	System.out.println(p.isPilhaVazia());
    }

}
