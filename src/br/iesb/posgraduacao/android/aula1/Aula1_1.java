package br.iesb.posgraduacao.android.aula1;


public class Aula1_1 extends Aula1_3{
	
	/**
	 * exemplo de padr�o Singleton
	 * o static determina que o atributo/metodo n�o pode ser instanticado
	 * sua chamada de fora nunca � com "new", ele � direto e o valor do atributo/metodo
	 * � distribuido para todos que o utilizam, ou seja, se mudar em um lugar,
	 * muda para todos. 		
	 */
	private static Aula1_1 instanciaA1;
	
	/**
	 * Metodo construtor � o mesmo nome da classe
	 */
	private Aula1_1(){
		Aula1_2 x = Aula1_2.getInstancia();
	}

	public static void main(String[] args) {		
		Aula1_1 y = new Aula1_1();
		
		if(y instanceof Aula1_1){
			System.out.println("� do tipo Aula 1");
		}
		
		if(y instanceof Aula1_3){
			System.out.println("� do tipo Aula 3");
		}

	}

	public static Aula1_1 getInstancia() {
		if (instanciaA1 == null) {
			instanciaA1 = new Aula1_1();
		}
		return instanciaA1;
	}

	public void metodo(String[] x) {
		// TODO Auto-generated method stub
		
	}

}
