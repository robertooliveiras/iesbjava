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
	private ArrayList<Peca> peca = new ArrayList<Peca>();
	private String[][] grelha;
	public String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
	public String[] colunas = {"1","2","3","4","5","6","7","8","9","10"};
	public Character[] linhasChar = {'A','B','C','D','E','F','G','H','I','J'};
	public Character[] colunasChar = {'1','2','3','4','5','6','7','8','9','0'};
	
	public static void main(String[] args){
		CampoBatalha cb = new CampoBatalha();
		CampoBatalha cb2 = new CampoBatalha();
		for (int i = 0; i < cb.grelha.length; i++) {
			System.out.print(cb.linhas[i] + " ");
			for (int j = 0; j < cb.grelha[i].length; j++) {
				System.out.print(cb.grelha[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < cb.grelha.length; i++) {
			System.out.print("   " + cb.colunas[i] );
		}
		
		System.out.println("\n");
		for (int i = 0; i < cb2.grelha.length; i++) {
			for (int j = 0; j < cb2.grelha[i].length; j++) {
				System.out.print(cb2.peca.get(i*j));
			}
		}
		
	}
	/**
	 * 
	 */
	public CampoBatalha() {
		Agua a;
		Peca p;
		char[] posicao = new char[2];
		grelha = new String[linhas.length][colunas.length];
		for (int i = 0; i < linhas.length; i++) {
			for (int j = 0; j < colunas.length; j++) {
				grelha[i][j] = "~~~|";
				posicao[0] = linhasChar[i];
				posicao[1] = colunasChar[j];
				a = new Agua();
				a.setPosicao(posicao);
				p = new Peca<Agua>();
				p.adicionarPeca(a);
				this.peca.add(p);
			}
		}
	}
	
}
