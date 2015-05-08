package br.iesb.posgraduacao.jogos.batalha_naval;

public class Agua implements InterfacePeca {
	private boolean visivel = true;
	private boolean atingido = false;
	private char linha;
	private char coluna;
	private String forma = "~~~~|";

	public boolean isAtingido() {
		return this.atingido;
	}

	public void setAtingido(boolean atingido) {
		this.atingido = atingido;
		this.visivel = true;
		this.setForma("~§§~|");
	}

	public boolean isVisivel() {
		return this.visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
		this.setForma("~~~~|");
		if (this.isAtingido()) {
			if (visivel) {
				this.setForma("~§§~|");
			}else{
				this.setForma("~~~~|");				
			}
		}
	}

	public char getLinha() {
		return linha;
	}

	public char getColuna() {
		return coluna;
	}
	public void setPosicao(char[] posicao) {
		this.linha = posicao[0];
		this.coluna = posicao[1];
	}

	/**
	 * @return the forma
	 */
	public String getForma() {
		return forma;
	}

	/**
	 * @param forma the forma to set
	 */
	public void setForma(String forma) {
		this.forma = forma;
	}

}
