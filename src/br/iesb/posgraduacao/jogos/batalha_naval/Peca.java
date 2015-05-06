package br.iesb.posgraduacao.jogos.batalha_naval;

public class Peca <T extends InterfacePeca>{
	private T peca;

	/**
	 * @return devolve o objeto do tipo genérico peca
	 */
	public T getTPeca() {
		return this.peca;
	}

	/**
	 * @param recebe um objeto do tipo genérico e preenche o atributo peca com sua instância
	 */
	public void setTPeca(T peca) {
		this.peca = peca;
	}
	
}
