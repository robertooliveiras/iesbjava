package br.iesb.posgraduacao.android.aula1;
/**
 * 
 * @author RobertoOliveira
 * ordem de complexidade
 */
public class Desafio1 {

	public static void main(String[] args) {
		
		int[][] matriz = new int[3][3];
		int[] controla = new int[8];
		boolean popula = true;
		int j = 1;
		while(j < 4){
			int x = (int) (Math.random() * 8);
			if(x==0)x=1;
			System.out.println("x = "+x);
			for (int i = 0; i < j; i++) {
				System.out.println("i = "+controla[i]);
				if(controla[i] == x){
					popula = false;
				}
			}
			if(popula){
				int n = j-1;
				controla[n] = x;
				j++;
			}
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
