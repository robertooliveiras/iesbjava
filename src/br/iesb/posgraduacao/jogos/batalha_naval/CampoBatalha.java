/**
 * 
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

/**
 * @author roberto
 *
 */
public class CampoBatalha{
	private Peca[][] campo;
	public String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
	public String[] colunas = {"1","2","3","4","5","6","7","8","9","10"};
	public Character[] linhasChar = {'A','B','C','D','E','F','G','H','I','J'};
	public Character[] colunasChar = {'1','2','3','4','5','6','7','8','9','0'};
	
	public static void main(String[] args){
		
		CampoBatalha cb2 = new CampoBatalha();
		
		for (int i = 0; i < cb2.campo.length; i++) {
			System.out.print(cb2.linhas[i] + " ");
			for (int j = 0; j < cb2.campo[i].length; j++) {
				System.out.print(cb2.campo[i][j].getPecaTeste().getForma());
			}
			System.out.println();
		}
		for (int i = 0; i < cb2.campo.length; i++) {
			System.out.print("   " + cb2.colunas[i] );
		}
		System.out.println("\n");
		System.out.println("\n");
		
		String a = "C7";
		int L = cb2.getIndexOfLinhasChar(a.charAt(0));
		int C = cb2.getIndexOfColunasChar(a.charAt(1));
		System.out.println(L);
		System.out.println(C);
		cb2.campo[L][C].getPecaTeste().setAtingido(true);
		System.out.println(cb2.campo[L][C].getPecaTeste().getForma());
	}
	/**
	 * 
	 */
	public CampoBatalha() {
		Agua a;
		char[] posicao = new char[2];
		campo = new Peca[linhas.length][colunas.length];
		for (int i = 0; i < linhas.length; i++) {
			for (int j = 0; j < colunas.length; j++) {
				posicao[0] = linhasChar[i];
				posicao[1] = colunasChar[j];
				a = new Agua();
				a.setPosicao(posicao);

				Peca pt = new Peca();
				pt.setPecaTeste(a);
				pt.getPecaTeste().setPosicao(posicao);
				campo[i][j] = pt;
			}
		}
	}
	
	public int getIndexOfLinhasChar(char c){
		int index = -1;
		for (int i = 0; i < this.linhasChar.length; i++) {
			if(this.linhasChar[i] == c){
				index = i;
			}
		}
		return index;
	}
	
	public int getIndexOfColunasChar(char c){
		int index = -1;
		for (int i = 0; i < this.colunasChar.length; i++) {
			if(this.colunasChar[i] == c){
				index = i;
			}
		}
		return index;
	}
	
}
