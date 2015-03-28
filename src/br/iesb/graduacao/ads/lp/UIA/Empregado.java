package br.iesb.graduacao.ads.lp.UIA;

public class Empregado extends Pessoa {
	public static Pessoa empregado = new Pessoa();
	public String corCabelo; //visível a qualquer classe
	private double salario; //inacessável fora da classe
	protected int idCargo; //acessibilidade padrão

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		empregado.setNome("João");
		
		System.out.println(empregado.getNome()+"?\n\n");
		empregado.imprime("Pois não?\n\n");
		
		System.out.println("Conte até 8. \n\n");
		empregado.contaAte(8);
		
		System.out.println("\n\n\n");
		System.out.println("Some 9 e 20. \n\n");
		
		empregado.imprime("9 + 20 é igual a " + empregado.soma(9, 20));
		
	}

}
