package br.iesb.posgraduacao.android.aula1;

public class Aula1_2 {
	
	/**
	 * exemplo de padr�o Singleton
	 * o static determina que o atributo/metodo n�o pode ser instanticado
	 * sua chamada de fora nunca � com "new", ele � direto e o valor do atributo/metodo
	 * � distribuido para todos que o utilizam, ou seja, se mudar em um lugar,
	 * muda para todos. 	
	 */
	private static Aula1_2 instanciaA2;
	
	/**
	 * construtor da classe, mesmo nome da classe
	 */
	private Aula1_2(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Aula1_2 getInstancia() {
		if (instanciaA2 == null) {
			instanciaA2 = new Aula1_2();
		}
		return instanciaA2;
	}

}
