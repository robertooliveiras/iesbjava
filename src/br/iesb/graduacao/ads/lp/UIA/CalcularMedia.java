package br.iesb.graduacao.ads.lp.UIA;

public class CalcularMedia {
	public float m;

	/**
	 * @param args
	 */
	CalcularMedia(float a, float b) {
		m = (a + b)/2;
	}
	
	public static void main (String[] args){
		CalcularMedia media = new CalcularMedia(10 , 20);
		System.out.println("a média entre 10 e 20 é: " + media.m);
	}

}
