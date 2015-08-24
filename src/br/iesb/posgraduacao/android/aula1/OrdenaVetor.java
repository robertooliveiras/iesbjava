package br.iesb.posgraduacao.android.aula1;

public class OrdenaVetor {

	public static void main(String[] args) {
		int[] a = {2,4,1,5,3,7,6,8};
		int j; 
		int valor;
		
		for(int n = 0; n < a.length; n++){
		    System.out.format("%8d˚ | ", n + 1);
		}
		System.out.println("");
		for(int n = 0; n < a.length; n++){
		    System.out.format("%8d  | ", a[n]);
		}
		System.out.println("\n\n");
		
		for (int i = 1; i < a.length; i++) {
		    	valor = a[i];
		    	j = i-1;
			while (j >= 0 && a[j] > valor) {
			    a[j+1] = a[j];
			    j = j-1;
			}
			a[j+1] = valor;
		}
		
		for(int n = 0; n < a.length; n++){
		    System.out.format("%8d˚ | ", n + 1);
		}
		System.out.println("");
		for(int n = 0; n < a.length; n++){
		    System.out.format("%8d  | ", a[n]);
		}
		System.out.println("\n\n");
	}
}
