package br.iesb.graduacao.ads.lp.UIA;

public class Pessoa {
	private static String nome;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void contaAte( int limite ){
		for(int i = 1; i <= limite; i++){
			this.imprime(""+i);
		}
	}
	
	public int soma( int a, int b ){		
		int s = a + b;
		return s;
	}
	
	public void imprime( String texto ){
		System.out.println(this.getNome() +  " fala: " + texto);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		Pessoa.nome = nome;
	}

}
