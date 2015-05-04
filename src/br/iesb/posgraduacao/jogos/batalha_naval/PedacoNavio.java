package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoNavio{
	private boolean visivel = false;
	private boolean atingido = false;
	private char linha;
	private char coluna;
	
	public PedacoNavio(char linha, char coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

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
}
