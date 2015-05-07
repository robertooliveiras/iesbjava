package br.iesb.posgraduacao.jogos.batalha_naval;

public abstract class PedacoNavio implements InterfacePeca{
	private String forma = "~~~|";
	protected boolean visivel = false;
	private boolean atingido = false;
	private char linha;
	private char coluna;
	
	public boolean isAtingido() {
		return atingido;
	}

	public void setAtingido(boolean destruido) {
		this.atingido = destruido;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public char getLinha() {
		return linha;
	}

	public char getColuna() {
		return coluna;
	}
	public void setLinha(char linha) {
		this.linha = linha;
	}

	public void setColuna(char coluna) {
		this.coluna = coluna;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	public void setPosicao(char[] posicao) {
		this.setLinha(posicao[0]);
		this.setColuna(posicao[1]);
	}
	
//	public void setPosicaoPorIndice(int[] posicao) {
//		this.setLinha(posicao[0]);
//		this.setColuna(posicao[1]);
//	}
}
