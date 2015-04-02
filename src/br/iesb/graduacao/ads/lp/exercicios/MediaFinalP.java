package br.iesb.graduacao.ads.lp.exercicios;

/**

* programa para cálculo da média e exiba a mensagem "Aprovado" ou "Reprovado" 

* @author eduardo rocha 

*/

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MediaFinalP {
	 /**
	  * @param args the command line arguments
	  */   
	public static void main(String[] args) {           
		String message = ("Bem vindo ao programa para Calcúlo da média! \n(Versão 1.0) \n\n Criado por Eduardo Rocha.");        JOptionPane.showMessageDialog(null, message);               
		Scanner entrada = new Scanner(System.in);               
		float M, n1, n2;               
		System.out.println("Informe sua nota N1: ");       
		n1 = entrada.nextFloat();               
		System.out.println("Informe sua nota N2: ");       
		n2 = entrada.nextFloat();                   
		//Calculo da Média               
		M = ( n1 + n2 ) / 2;       
		System.out.println("Sua média é = "+M);       
		if(M >= 6.0){           
			System.out.println("Aprovado");       
		} else {           
			System.out.println("Reprovado");       
		}   
	}    
}
