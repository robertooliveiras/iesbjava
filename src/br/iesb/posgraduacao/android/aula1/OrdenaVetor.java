package br.iesb.posgraduacao.android.aula1;

public class OrdenaVetor {

	/**
	 * @param args
	 * https://www.youtube.com/watch?v=bWCfxYbG8DQ
	 * http://www.sbgames.org/papers/sbgames07/short/3.pdf
	 */
	public static void main(String[] args) {
		int[] a = {2,4,1,5,3,7,6,8};
		int[] ord = new int[8];
		int m = a.length;
		int im = 0; 
		int lm = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int k = lm; k < a.length; k++) {
				if (m > a[k]) {
					m = a[k];
					im = k;
				}
			}
			ord[i] = m;
			lm++;
			
			System.out.print(ord[i]);
		}
	}
}
