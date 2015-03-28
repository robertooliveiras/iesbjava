package br.iesb.graduacao.ads.lp.UIA;

public class Cliente extends Pessoa {

	private static Pessoa cliente;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setCliente(new Pessoa());
		cliente.contaAte(10);

	}

	/**
	 * @return the teste
	 */
	public static Pessoa getCliente() {
		return cliente;
	}

	/**
	 * @param teste the teste to set
	 */
	public static void setCliente(Pessoa cliente) {
		Cliente.cliente = cliente;
	}

}
