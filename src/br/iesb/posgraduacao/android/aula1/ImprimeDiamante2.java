package br.iesb.posgraduacao.android.aula1;

import java.util.Scanner;

public class ImprimeDiamante2 {

	public static void main(String[] args) {
		
		System.out.print("Informe um numero impar:");
		Scanner scan = new Scanner(System.in);
		int maximo = scan.nextInt();
		System.out.println("");
		
		//Parte de Cima - Logica Normal
		for (int i = 1; i < maximo; i++) 
		{
			if ( i%2 != 0)
			{
				int espacos = (maximo - i)/2;
				for (int y = 0; y < espacos; y++)
				{
					System.out.print(" ");
				}
				for (int j = 0 ; j < i; j++)
				{
						System.out.print("*"); 
				}
				System.out.println("");
			}
		}
		
		//Parte de Baixo - Logica Reversa
		for (int i = maximo; i > 0; i--) 
		{
			if ( i%2 != 0)
			{
				int espacos = (maximo - i)/2;
				for (int y = 0; y < espacos; y++)
				{
					System.out.print(" ");
				}
				for (int j = 0 ; j < i; j++)
				{
						System.out.print("*");
				}
				System.out.println("");
			}
		}
		

	}
	
}
