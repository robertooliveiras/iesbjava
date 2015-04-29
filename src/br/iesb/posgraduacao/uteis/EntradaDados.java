package br.iesb.posgraduacao.uteis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.iesb.posgraduacao.jogos.batalhanaval.Tabuleiro;

public class EntradaDados {
	private static Tabuleiro[][] matriz;
	private int tamanho = 6;
	private String[] navioValido = {"1","2","3"};
	private int[][] tamanhoNavio = {{1,2},{2,3},{3,4}};
	private List<String> linhaValida = new ArrayList<String>();
	private List<String> colunaValida = new ArrayList<String>();
	private String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J"};
	private String[] inteiros = {"1","2","3","4","5","6","7","8","9","10"};
	private String[] orientacaoValida = {"V","H"};
	
	public EntradaDados(){
		Tabuleiro tj = new Tabuleiro();
		matriz = tj.criaTabuleiro(tamanho);
		for(int x=0;x<tamanho;x++){
			for(int y=0;y<tamanho;y++){
				matriz[x][y] = new Tabuleiro();
			}			 
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		EntradaDados e = new EntradaDados();
		
		for (int i = 0; i < matriz.length; i++) {
			for(int y=0;y<matriz[i].length;y++){
				System.out.print(matriz[i][y].piece);
			}
			System.out.println();
		}
		
		
		System.out.println("escreva algo:");
		String input = entrada.nextLine();
		while(!e.validaDadosInformados(input)){
			System.out.println("Opa, vc não está digitando certo!");
			System.out.println("escreva algo:");
			input = entrada.nextLine();
		}
		System.out.println("Beleeza, vc foi bem agora!");
	}

	/**
	 * Valida os dados da distribuição da frota
	 * @param String x
	 * @return boolean
	 */
	public boolean validaDadosInformados(String x){
		x = x.toUpperCase();
		char[] a = x.toCharArray();
		int b2;
		String col;
		//valida o tamanho da string digitada e guarda o local do espaço
		if(x.length() == 6){
			b2 = 4;
			col = a[3]+"";
		}else if(x.length() == 7){
			b2 = 5;
			col = ""+a[3]+a[4]+"";
		}else{
			return false;			
		}
		//valida o local dos espaços digitados
		if( a[1] != ' ' || a[b2] != ' '){
			return false;
		}
		
		//gera lista de linhas e colunas válidas
		for (int i = 0; i < tamanho; i++) {
			linhaValida.add(alfabeto[i].toString());
			colunaValida.add(inteiros[i].toString());
		}
		
		//inicializa variáveis de verificação
		boolean valida = false;
		boolean validaNavio = false;
		boolean validaLinha = false;
		boolean validaColuna = false;
		boolean validaOrientacao = false;
		boolean validaPosicao = false;
		
		//valida tipo de navio
		for (int i = 0; i < navioValido.length; i++) {
			if(navioValido[i].charAt(0)==a[0]){
				validaNavio = true;
				break;
			}
		}
		
		System.out.println((int)a[0]);
		//valida linha informada
		for (int i = 0; i < linhaValida.size(); i++) {
			if(linhaValida.get(i).charAt(0)==a[2]){
				validaLinha = true;
//				if(i <= (tamanho-1)-((int)a[0]+1)){
//					validaPosicao = true;
//				}
				break;
			}
		}
		
		//valida coluna informada
		for (int i = 0; i < colunaValida.size(); i++) {
			if(colunaValida.get(i).equals(col)){
				validaColuna = true;
				break;
			}
		}
		
		//valida orientação informada
//		for (int i = 0; i < orientacaoValida.length; i++) {
//			if(orientacaoValida[i].charAt(0) == a[b2+1]){
//				validaOrientacao = true;
//				break;
//			}
//		}
		if(a[b2+1] == 'V' || a[b2+1] == 'H'){
			validaOrientacao = true;
		}

		
		
		//valida posicao do navio quanto ao tamanho do tabuleiro
		//só pode ser vertical se a linha for maior ou igual ao tamanho do navio e se não houver navio ocupando o espaço
//		
		System.out.println(linhaValida.get(2));
//		if(a[b2+1] == 'V' && linhaValida.indexOf(linha) <= 1){
//			validaPosicao = true;
//		}
		//só pode ser horizontal se a coluna cor menor ou igual ao tamanho da matriz subtraído do tamanho do navio e se não houver navio ocupando o espaço
		
		//valida todas as variáveis de verificação
		if(validaNavio && validaLinha && validaColuna && validaOrientacao && validaPosicao){
			valida = true;
		}
		return valida;
	}

}
