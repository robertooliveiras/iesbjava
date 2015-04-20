package br.iesb.posgraduacao.android.aula1;
/**
 * 
 * @author RobertoOliveira
 * ordem de complexidade
 */
public class Desafio1 {

	public static void main(String[] args) {
		
		Desafio1 desafio = new Desafio1();
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
		
//		while(!desafio.comparaMatriz(matriz,matrizRef)){
//		}

		int branco = 0; //branco
		int tb = 1; //troca por branco
		int flexa = 1; //fixo
		int tf; //troca por fixo
		boolean moveBranco;
		int[] posicaoAlvo = new int[2];
		int[] posicaoBranco = new int[2];
		int[] posicaoFlexa = new int[2];
		int[] proximaPosicaoBranco = new int[2];
		
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz.length; coluna++) {
				System.out.print(matriz[linha][coluna]);		
				if(matriz[linha][coluna] == branco){
					posicaoBranco[0]= linha;
					posicaoBranco[1]= coluna;
				}else if(matriz[linha][coluna] == flexa){
					posicaoFlexa[0]= linha;
					posicaoFlexa[1]= coluna;
				}
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		System.out.println("A posição do 0 (branco) é L"+posicaoBranco[0]+"C"+posicaoBranco[1]);
		System.out.println("A posição do "+flexa+" (flexa) é L"+posicaoFlexa[0]+"C"+posicaoFlexa[1]);
		
		if(posicaoBranco[0] == posicaoFlexa[0]){
			System.out.println("branco e flexa na mesma linha");
			if(posicaoBranco[1] < posicaoFlexa[1]){
				System.out.println("branco em coluna à esquerda");
			}else if(posicaoBranco[1] > posicaoFlexa[1]){
				System.out.println("branco em coluna à direita");
				if(posicaoBranco[0] == 0){
					proximaPosicaoBranco[0] = posicaoBranco[0]+1;
					proximaPosicaoBranco[1] = posicaoBranco[1];
				}else{
					proximaPosicaoBranco[0] = posicaoBranco[0]-1;
					proximaPosicaoBranco[1] = posicaoBranco[1];
				}
			}
		}
		System.out.print("Branco tem que ir para L"+proximaPosicaoBranco[0]+"C"+proximaPosicaoBranco[1]);
		System.out.println(": "+matriz[proximaPosicaoBranco[0]][proximaPosicaoBranco[1]]);
		matriz = desafio.trocaPosicaoBranco(posicaoBranco[0], posicaoBranco[1], proximaPosicaoBranco[0], proximaPosicaoBranco[1], matriz);
		System.out.println("\n\n");
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz.length; coluna++) {
				System.out.print(matriz[linha][coluna]);		
				if(matriz[linha][coluna] == branco){
					posicaoBranco[0]= linha;
					posicaoBranco[1]= coluna;
				}else if(matriz[linha][coluna] == flexa){
					posicaoFlexa[0]= linha;
					posicaoFlexa[1]= coluna;
				}
			}
			System.out.println();
		}
		
	}
	
	public boolean comparaMatriz(int[][] m1, int[][]m2){
		if(m1.length != m2.length){
			return false;
		}
		for (int i = 0; i < m1.length; i++) {
			if(m1[i].length != m2[i].length){
				return false;
			}
			for (int j = 0; j < m1[i].length; j++) {
				if(m1[i][j] != m2[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public int[][] trocaPosicaoBranco(int lb, int cb, int plb, int pcb, int[][] matriz){
		matriz[lb][cb] = matriz[plb][pcb];
		matriz[plb][pcb] = 0;
		return matriz;
	}
}
