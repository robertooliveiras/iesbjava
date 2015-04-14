package br.iesb.posgraduacao.android.aula1;

import java.util.Random;
import java.util.Vector;

public class Desafio1 {

	public static void main(String[] args) {
		int[][] matriz = new int[3][3];
		Random rnd = new Random(8);

		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[0][2] = 3;

		matriz[1][0] = 4;
		matriz[1][1] = 5;
		matriz[1][2] = 6;

		matriz[2][0] = 7;
		matriz[2][1] = 8;
		matriz[2][2] = 0;
		
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(matriz[i][j]) ;
			}
			System.out.println();
		}
		
	}

}
