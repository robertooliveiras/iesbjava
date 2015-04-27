package br.iesb.posgraduacao.android.aula1;

public class Aula1_4 {
	public enum TipoCafe{
		P(100,"pequeno"),
		M(200,"medio"),
		G(300,"grande");
		
		public String dsc;
		public int ml;

		TipoCafe(int ml, String dsc){
			this.ml = ml;
			this.dsc = dsc;
		}
		
	}
	public static void main(String[] args) {
		
	}
}
