package br.iesb.posgraduacao.jogos.batalha_naval;

public class Peca <TipoPeca extends InterfacePeca>{
	private TipoPeca peca;

	/**
	 * @return TipoPeca peca
	 * devolve o objeto do tipo genérico peca
	 */
	public TipoPeca getTPeca() {
		return this.peca;
	}

	/**
	 * @param recebe um objeto do tipo genérico e preenche o atributo peca com 
	 * sua instância
	 */
	public void setTPeca(TipoPeca peca) {
		this.peca = peca;
	}

	/**
	 * @param recebe um objeto do tipo genérico e preenche o atributo peca com 
	 * sua instância
	 */
	public String getTForma() {
		return this.peca.getForma();
	}

	public void setPosicao(char[] posicao) {
		this.peca.setPosicao(posicao);
	}
	
}
