package br.iesb.posgraduacao.android.aula1;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Desafio1 {

	public static void main(String[] args) {
		int[][] matriz = new int[3][3];
		String[] numbers = new String[8];
		int tmp;
		Random rnd = new Random(8);
		for (int i = 0; i <= numbers.length; i++) {
			do{
				tmp = rnd.nextInt(8);
				System.out.println(tmp);
				if(!Arrays.asList(numbers).contains(tmp+"")){
					numbers[i] = tmp+"";
				}
			}while(!Arrays.asList(numbers).contains(tmp+""));
		}
		
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
		
		
		
		if(!Arrays.asList(numbers).contains("1")){
			System.out.println("tem");
		}
		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[0][2] = 3;

		matriz[1][0] = 4;
		matriz[1][1] = 5;
		matriz[1][2] = 6;

		matriz[2][0] = 7;
		matriz[2][1] = 8;
		matriz[2][2] = 0;
		
		
//		for(int i = 0; i < 3; i++){
//			for(int j = 0; j < 3; j++){
//				System.out.print(matriz[i][j]) ;
//			}
//			System.out.println();
//		}
		
	}

}
