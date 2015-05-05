package br.iesb.posgraduacao.uteis;

import java.util.ArrayList;

/**
 * 
 * @author RobertoOliveira
 * @since 2015/05/04
 * Essa classe trabalha com o código ANSI das letras para criar listas com o alfabeto
 *
 */
public class Alfabeto {
	public ArrayList<Character> maiusculoChar = new ArrayList<Character>();
	public ArrayList<Character> minusculoChar = new ArrayList<Character>();
	public ArrayList<Character> minusculoMaiusculoChar = new ArrayList<Character>();
	public ArrayList<String> maiusculoStr = new ArrayList<String>();
	public ArrayList<String> minusculoStr = new ArrayList<String>();
	public ArrayList<String> minusculoMaiusculoStr = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Alfabeto a = new Alfabeto();
		a.testes();
	}
	
	public Alfabeto(){
		initMaiusculoChar();
		initMaiusculoStr();
		initMinusculoChar();
		initMinusculoStr();
		initMinusculoMaiusculoStr();
		initMinusculoMaiusculoChar();
	}
	
	private final void testes(){
		for (char a = 'a'; (int)a <= 122; a++) {
			System.out.print(a);
		}
		System.out.println();
		for (Character a = 'a'; (int)a <= 122; a++) {
			System.out.print(a.toString());
		}
		System.out.println();

		char ax1 = 'a';
		String ax2 = "Z";
		Character ax3 = 'A';
		int ax4 = 90;
		System.out.println((int) ax1);
		System.out.println((int) ax2.charAt(0));
		System.out.println((int) ax3);
		System.out.println((char)ax4);
		Character ax5 = (char)ax4;
		System.out.println(ax5.toString());

		for (int i = 65; i <= 90; i++) {
			System.out.print((char)i);
		}
		for (int i = 97; i <= 122; i++) {
			System.out.print((char)i);
		}
		Alfabeto a = new Alfabeto();
		System.out.println();
		System.out.println(a.maiusculoChar.size());
		System.out.println(a.maiusculoChar.indexOf('Z'));
		System.out.println(a.maiusculoChar.get(25));
		
		System.out.println(a.minusculoMaiusculoStr.get(50));
		System.out.println(a.minusculoMaiusculoStr.get(51));
		
		System.out.println(a.minusculoMaiusculoChar.get(50));
		System.out.println(a.minusculoMaiusculoChar.get(51));
	}
	/**
	 *
	 */
	public void initMinusculoMaiusculoChar() {
		for (int i = 97; i <= 122; i++) {
			this.minusculoMaiusculoChar.add((char)i);
			this.minusculoMaiusculoChar.add((char)(i-32));
		}
	}
	/**
	 *
	 */
	public void initMinusculoMaiusculoStr() {
		Character a;
		for (int i = 97; i <= 122; i++) {
			a = (char)i;
			this.minusculoMaiusculoStr.add(a.toString());
			a = (char)(i-32);
			this.minusculoMaiusculoStr.add(a.toString());
		}
	}
	/**
	 *
	 */
	public void initMinusculoStr() {
		Character a;
		for (int i = 97; i <= 122; i++) {
			a = (char)i;
			this.minusculoStr.add(a.toString());
		}
	}

	/**
	 *
	 */
	public void initMinusculoChar() {
		for (int i = 97; i <= 122; i++) {
			this.minusculoChar.add((char)i);
		}
	}

	/**
	 *
	 */
	public void initMaiusculoChar() {
		for (int i = 65; i <= 90; i++) {
			this.maiusculoChar.add((char)i);
		}
	}
	/**
	 *
	 */
	public void initMaiusculoStr() {
		Character a;
		for (int i = 65; i <= 90; i++) {
			a = (char)i;
			this.maiusculoStr.add(a.toString());
		}
	}


}
