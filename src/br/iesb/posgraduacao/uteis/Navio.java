/**
 * 
 */
package br.iesb.posgraduacao.uteis;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @since 2015-04-30
 * @author Roberto
 * IESB - Pósgraduação em Desenvolvimento de Aplicativos Móveis - Java
 * José Roberto de Oliveira Silva Filho - 1531030023
 *
 */
public class Navio {
	
	private Character tipo;
	private Character orientacao;
	private int qtCanos;
	private Character linha;
	private Character coluna;
	private String[][] localizacao;
	private boolean situacao;
	private ArrayList<Character> linhasC = new ArrayList<Character>();
	private ArrayList<String> linhasS = new ArrayList<String>();
	private Character[] alfabetoC = {'A','B','C','D','E','F','G','H','I','J'};
	private Character[] colunasC = {'1','2','3','4','5','6','7','8','9','0'};
	private String[] alfabetoS = {"A","B","C","D","E","F","G","H","I","J"};
	private String[] colunasS = {"1","2","3","4","5","6","7","8","9","10"};
	/**
	 * 
	 */
	public static void main (String[] args){
		Navio n = new Navio('N','V',3,"A2");
		System.out.println(n.linhasC.indexOf('K'));
		
	}
	public Navio(Character t, Character o, int q, String posicaoInicial) {
		for (int i = 0; i < alfabetoS.length; i++) {
			linhasS.add(alfabetoS[i]);
			linhasC.add(alfabetoC[i]);
		}
		tipo = t;
		orientacao = o;
		qtCanos = q;
//		localizacao[0][0] = posicaoInicial;
		if (orientacao == 'V'){
		}else{ //é horizontal
		}
		
	}
	public char getTipo() {
		return tipo;
	}
	public char getOrientacao() {
		return orientacao;
	}
	public int getQtCanos() {
		return qtCanos;
	}
}
