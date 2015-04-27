package br.iesb.posgraduacao.android.aula1;

import java.lang.reflect.Array;

public class Matriz123 {

	public static void main(String[] args) {
		int n = 6;
		int c = n;
		int q = 1;

		int[][] matriz = new int[n][n];
		int[][] matriz2 = new int[n][n];
		int[][] matriz3 = new int[n][n];
		int[][] matriz4 = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == 0 || i==5 || j == 0 || j == 5){
					matriz[i][j] = 1;				
					matriz2[i][j] = 3;				
				}else{
					if(i == 1 || i==4 || j == 1 || j == 4){
						matriz[i][j] = 2;
						matriz2[i][j] = 2;
					}else{
						matriz[i][j] = 3;
						matriz2[i][j] = 1;
					}
				}
			}			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(j>=i && j<=c){
					matriz3[i][j] = q;				
				}else{
					matriz3[i][j] = 2;
				}
			}			
		}
		

		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(j>=i && i<c/2){
					matriz4[i][j] = q;				
				}else if(i>=c/2){
					matriz4[i][j] = q+1;
				}else{
					matriz4[i][j] = q+2;
				}
			}			
		}


		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz[i][j]);				
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz2[i][j]);				
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz3[i][j]);				
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz4[i][j]);				
			}
			System.out.println();
		}
		
	}

}
