package br.iesb.posgraduacao.jogos.batalha_naval;

public interface InterfacePeca {
	public boolean isAtingido();
	public void setAtingido(boolean atingido);
	public boolean isVisivel();
	public void setVisivel(boolean visivel);
	public char getLinha();
	public char getColuna();
	public void setPosicao(char[] posicao);
	public String getForma();
	public void setForma(String forma);
}
