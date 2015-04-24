package br.iesb.posgraduacao.android.aula1;
/**
 * 
 * @author RobertoOliveira
 * ordem de complexidade
 */
public class Desafio1 {
	private int[][] matrizd;

	public static void main(String[] args) {
		
		Desafio1 desafio = new Desafio1();
		
		int[][] matriz = new int[3][3];
//		matriz = desafio.getMatrizEmbaralhada();
//		matriz = desafio.getMatrizPadrao(2);
		desafio.setMatrizd(desafio.getMatrizPadrao(2));
		matriz = desafio.getMatrizd();
		

		int branco = 0; //branco
		int tb = 1; //troca por branco
		int flexa = 1; //fixo
		int tf; //troca por fixo
		boolean moveBranco;
		int[] ultimaPosicaoBranco = new int[2];
		int[] posicaoAlvo = {0,0};
		int[] posicaoBranco = new int[2];
		int[] posicaoFlexa = new int[2];
		int[] proximaPosicaoBranco = new int[2];
		
		//imprime matrix e descobre posições
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
		
		//imprime saídas
//		System.out.println("\n");		
//		System.out.println("A posição do 0 (branco) é L"+posicaoBranco[0]+"C"+posicaoBranco[1]);
//		System.out.println("A posição do "+flexa+" (flexa) é L"+posicaoFlexa[0]+"C"+posicaoFlexa[1]);
		
		String movimento = "";
		/*
		 * A X X
		 * X X X
		 * 0 N X
		 * 
		 * A X X
		 * X X X
		 * X N 0
		 * 
		 * A X X
		 * 0 N X
		 * X X X
		 *  
		 * A X X
		 * X N 0
		 * X X X
		 * 
		 * 0 N X
		 * X X X    OK
		 * X X X
		 *  
		 * A N 0
		 * X X X
		 * X X X
		 * */
		if(posicaoBranco[0] == posicaoFlexa[0] && posicaoFlexa[1] == 1){
			if(posicaoAlvo[0] == posicaoBranco[0] && posicaoAlvo[1] == posicaoBranco[1]){
				matriz = desafio.trocaPosicaoBranco(posicaoBranco,posicaoFlexa, matriz);
				posicaoAlvo[1] = 1;
			}else{
				matriz = desafio.movePeca(posicaoBranco, "B", matriz);
			}
		}
		
		//descobre proxima posição
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
		}else{
			if(posicaoFlexa[1] != posicaoBranco[1]){
				if(posicaoBranco[0] == 0){
					matriz = desafio.movePeca(posicaoBranco, "C", matriz);
				}else{
					matriz = desafio.movePeca(posicaoBranco, "B", matriz);
				}
			}else{
				if(posicaoBranco[1] == 0){
					matriz = desafio.movePeca(posicaoBranco, "D", matriz);
				}else{
					matriz = desafio.movePeca(posicaoBranco, "E", matriz);
				}
			}
			System.out.println("branco e flexa em linha diferente");
		}
		
		//imprime saídas
//		System.out.print("Branco tem que ir para L"+proximaPosicaoBranco[0]+"C"+proximaPosicaoBranco[1]);
//		System.out.println(": "+matriz[proximaPosicaoBranco[0]][proximaPosicaoBranco[1]]);
		
		//realiza a troca de posição do branco
		if(!desafio.validaMatriz(matriz)) {
			matriz = desafio.trocaPosicaoBranco(posicaoBranco, proximaPosicaoBranco, matriz);
		}
		
		
		//reimprime a matriz
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
	
	public boolean validaMatriz(int[][] m1){
		int[][] m2 = {{1,2,3},{4,5,6},{7,8,0}};
		
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
	
	public int[][] trocaPosicaoBranco(int[] posicaoBranco, int[] proximaPosicaoBranco, int[][] matriz){
		matriz[posicaoBranco[0]][posicaoBranco[1]] = matriz[proximaPosicaoBranco[0]][proximaPosicaoBranco[1]];
		matriz[proximaPosicaoBranco[0]][proximaPosicaoBranco[1]] = 0;
		return matriz;
	}
	public int[][] movePeca(int[] posicao, String direcao, int[][] matriz){
		int valor = matriz[posicao[0]][posicao[1]];
		switch(direcao){
		case "C": //cima
			matriz[posicao[0]][posicao[1]] = matriz[posicao[0]-1][posicao[1]];
			matriz[posicao[0]-1][posicao[1]] = valor;
			break;
		case "B": //baixo
			matriz[posicao[0]][posicao[1]] = matriz[posicao[0]+1][posicao[1]];
			matriz[posicao[0]+1][posicao[1]] = valor;
			break;
		case "D": //direita
			matriz[posicao[0]][posicao[1]] = matriz[posicao[0]][posicao[1]+1];
			matriz[posicao[0]][posicao[1]+1] = valor;
			break;
		case "E": //esquerda
			matriz[posicao[0]][posicao[1]] = matriz[posicao[0]][posicao[1]-1];
			matriz[posicao[0]][posicao[1]-1] = valor;
			break;
		}
		
		return matriz;
	}
	
	public int[][] getMatrizPadrao(int tp){
		switch(tp){
		case 1:
			int[][] m1 = {{5,2,7},{6,8,3},{1,4,0}};
			return m1;
		case 2:
			int[][] m2 = {{5,2,7},{6,8,0},{1,4,3}};
			return m2;
		default:
			int[][] md = {{5,2,7},{6,8,3},{1,4,0}};
			return md;
		}
	}
	
	public int[][] getMatrizOrdenada(){
		int[][] matriz = {{1,2,3},{4,5,6},{7,8,0}};
		return matriz;
	}
	
	public int[][] getMatrizEmbaralhada(){
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
		
		matriz[0][0] = controla[0];
		matriz[0][1] = controla[1];
		matriz[0][2] = controla[2];

		matriz[1][0] = controla[3];
		matriz[1][1] = controla[4];
		matriz[1][2] = controla[5];

		matriz[2][0] = controla[6];
		matriz[2][1] = controla[7];
		matriz[2][2] = 0;
		
		return matriz;

	}

	public int[][] getMatrizd() {
		return matrizd;
	}

	public void setMatrizd(int[][] matrizd) {
		this.matrizd = matrizd;
	}
}
