package br.iesb.posgraduacao.android.aula1;

import java.util.Scanner;

public class MatrizAsterisco {

	public static void main(String[] args) {
		
		int n;
		boolean continuar = true;
		String[][] matriz;
		int centro;
		int cd;
		int ce;
		
		Scanner entrada = new Scanner(System.in);
		do{
			System.out.println("digite um numero impar:");
			n = entrada.nextInt();
			if((n % 2) == 0){
				System.out.println("numero invalido");
			}else{
				continuar = false;
				System.out.println();
				matriz = new String[n][n];
				centro = (n-1)/2;
				cd = centro;
				ce = centro;

				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz.length; j++) {
						if(j >= ce && j <= cd){
							matriz[i][j] = "*";
						}else{
							matriz[i][j] = " ";
						}
					}	
					if(i < centro){
						cd++;
						ce--;
					}else if(i>=centro){
						cd--;
						ce++;
					}
				}
				
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz.length; j++) {
						System.out.print(matriz[i][j]);				
					}
					System.out.println();
				}
				
			}
			
		}while(continuar);
		
		

	}

}
