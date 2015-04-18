package br.iesb.posgraduacao.android.aula1;
/**
 * 
 * @author RobertoOliveira
 * ordem de complexidade
 */
public class Desafio1 {

	public static void main(String[] args) {
		
		int[][] matrizRef = new int[3][3];
		int[][] matriz = new int[3][3];
		int[] controla = new int[8];
		
		boolean popula = true;
		int j = 0;
		
		int x = (int) (Math.random() * 8);
		x= x+1;
		
		while(j < 8){
			popula = true;
			if(x>0 && x<9){
				for (int i = 0; i <= j; i++) {
					if(controla[i] == x){
						popula = false;
						break;
					}
				}
				if(popula){
					int n = j;
					controla[n] = x;
					j++;
				}
				x = (int) (Math.random() * 8);
				x= x+1;
			}
		}

		matriz[0][0] = 5; //controla[0];
		matriz[0][1] = 2; //controla[1];
		matriz[0][2] = 7; //controla[2];

		matriz[1][0] = 6; //controla[3];
		matriz[1][1] = 8; //controla[4];
		matriz[1][2] = 3; //controla[5];

		matriz[2][0] = 1; //controla[6];
		matriz[2][1] = 4; //controla[7];
		matriz[2][2] = 0;
		

		
		matrizRef[0][0] = 1; //controla[0];
		matrizRef[0][1] = 2; //controla[1];
		matrizRef[0][2] = 3; //controla[2];

		matrizRef[1][0] = 4; //controla[3];
		matrizRef[1][1] = 5; //controla[4];
		matrizRef[1][2] = 6; //controla[5];

		matrizRef[2][0] = 7; //controla[6];
		matrizRef[2][1] = 8; //controla[7];
		matrizRef[2][2] = 0;
		
		for (int k = 0; k < matriz.length; k++) {
			for (int l = 0; l < matriz[k].length; l++) {
				System.out.print(matriz[k][l]);				
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		int b = 0; //branco
		int tb = 1; //troca por branco
		int f = 8; //fixo
		int tf; //troca por fixo
		
		for (int k = 0; k < matriz.length; k++) {
			for (int l = 0; l < matriz.length; l++) {
				if(matriz[k][l] == b){
					System.out.println("A posição do 0 é L"+k+"C"+l);
				}else if(matriz[k][l] == f){
					System.out.println("A posição do "+f+" é L"+k+"C"+l);
				}
			}
			System.out.println();
		}
	}
}
