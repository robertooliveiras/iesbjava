package br.iesb.posgraduacao.java.quebracabeca33;
/**
 * 
 * @author RobertoOliveira
 * ordem de complexidade
 */
public class Desafio1 {

//	public static void main(String[] args) {
//		
//		int[][] matriz = new int[3][3];
//		int[] controla = new int[8];
//		
//		boolean popula = true;
//		int j = 0;
//		
//		int x = (int) (Math.random() * 8);
//		x= x+1;
//		
//		while(j < 8){
//			popula = true;
//			if(x>0 && x<9){
//				for (int i = 0; i <= j; i++) {
//					if(controla[i] == x){
//						popula = false;
//						break;
//					}
//				}
//				if(popula){
//					int n = j;
//					controla[n] = x;
//					j++;
//				}
//				x = (int) (Math.random() * 8);
//				x= x+1;
//			}
//		}
//
//		matriz[0][0] = 5; //controla[0];
//		matriz[0][1] = 2; //controla[1];
//		matriz[0][2] = 7; //controla[2];
//
//		matriz[1][0] = 6; //controla[3];
//		matriz[1][1] = 8; //controla[4];
//		matriz[1][2] = 3; //controla[5];
//
//		matriz[2][0] = 1; //controla[6];
//		matriz[2][1] = 4; //controla[7];
//		matriz[2][2] = 0;
//		
//		
//		for (int k = 0; k < matriz.length; k++) {
//			for (int l = 0; l < matriz[k].length; l++) {
//				System.out.print(matriz[k][l]);				
//			}
//			System.out.println();
//		}
//		
//		System.out.println("\n");
//		
//		int b = 0; //branco
//		int tb = 1; //troca por branco
//		int f = 1; //fixo
//		int tf; //troca por fixo
//		
//		for (int k = 0; k < matriz.length; k++) {
//			for (int l = 0; l < matriz.length; l++) {
//				if(matriz[k][l] == 0){
//					System.out.println("A posição do 0 é L"+k+"C"+l);
//				}else if(matriz[k][l] == 1){
//					System.out.println("A posição do 1 é L"+k+"C"+l);
//				}
//			}
//			System.out.println();
//		}
//	}

	private int[][] matriz;
	private int[] vetorEmbaralhado;
	
	public Desafio1(){
		Desafio1 D = new Desafio1();
		D.setMatrizEmbaralhadaPadrao();
		
		for (int k = 0; k < matriz.length; k++) {
			for (int l = 0; l < matriz[k].length; l++) {
				System.out.print(matriz[k][l]);				
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		int b = 0; //branco
		int tb = 1; //troca por branco
		int f = 1; //fixo
		int tf; //troca por fixo
		
		for (int k = 0; k < this.matriz.length; k++) {
			for (int l = 0; l < this.matriz.length; l++) {
				if(this.matriz[k][l] == 0){
					System.out.println("A posição do 0 é L"+k+"C"+l);
				}else if(this.matriz[k][l] == 1){
					System.out.println("A posição do 1 é L"+k+"C"+l);
				}
								
			}
			System.out.println();
		}
	}
	
	public int[][] getMatrizEmbaralhada(){
		int[][] mze = new int[3][3];
		int[] controla = getVetorEmbaralhado();

		mze[0][0] = controla[0];
		mze[0][1] = controla[1];
		mze[0][2] = controla[2];

		mze[1][0] = controla[3];
		mze[1][1] = controla[4];
		mze[1][2] = controla[5];

		mze[2][0] = controla[6];
		mze[2][1] = controla[7];
		mze[2][2] = 0;
		
		return mze;
	}

	public void embaralhaMatriz(){
		int[] controla = getVetorEmbaralhado();

		this.matriz[0][0] = controla[0];
		this.matriz[0][1] = controla[1];
		this.matriz[0][2] = controla[2];

		this.matriz[1][0] = controla[3];
		this.matriz[1][1] = controla[4];
		this.matriz[1][2] = controla[5];

		this.matriz[2][0] = controla[6];
		this.matriz[2][1] = controla[7];
		this.matriz[2][2] = 0;
		
	}
	
	public void setMatrizEmbaralhadaPadrao() {
		int[][] mz = new int[3][3];

		mz[0][0] = 5;
		mz[0][1] = 2;
		mz[0][2] = 7;

		mz[1][0] = 6;
		mz[1][1] = 8;
		mz[1][2] = 3;

		mz[2][0] = 1;
		mz[2][1] = 4;
		mz[2][2] = 0;
		
		setMatriz(mz);
	}
	
	public int[][] getMatriz() {
		return matriz;
	}
	
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int[] getVetorEmbaralhado() {
		int[] vtEmbaralhado = new int[8];
		
		boolean popula = true;
		int j = 0;
		
		int x = (int) (Math.random() * 8);
		x= x+1;
		
		while(j < 8){
			popula = true;
			if(x>0 && x<9){
				for (int i = 0; i <= j; i++) {
					if(vtEmbaralhado[i] == x){
						popula = false;
						break;
					}
				}
				if(popula){
					int n = j;
					vtEmbaralhado[n] = x;
					j++;
				}
				x = (int) (Math.random() * 8);
				x= x+1;
			}
		}
		return vtEmbaralhado;
	}

	public void setVetorEmbaralhado(int[] vetorEmbaralhado) {
		this.vetorEmbaralhado = vetorEmbaralhado;
	}
}
