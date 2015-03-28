package br.iesb.posgraduacao.android.aula1;

public class ClasseInterna {
	
	private int meuAtributoPai = 10;
	
	public static class Interna{

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
		
		public Interna(){
			Interna x = new Interna();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
