package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public abstract class PedacoNavio implements InterfacePeca{
	private String forma = "~~~~|";
	protected boolean visivel = false;
	private boolean atingido = false;
	private char linha;
	private char coluna;
	private ArrayList<String> id;
	
	@Override
	public boolean isAtingido() {
		return atingido;
	}

	@Override
	public void setAtingido(boolean destruido) {
		this.atingido = destruido;
	}

	@Override
	public boolean isVisivel() {
		return visivel;
	}

	@Override
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	@Override
	public char getLinha() {
		return linha;
	}

	@Override
	public char getColuna() {
		return coluna;
	}
	
	public void setLinha(char linha) {
		this.linha = linha;
	}

	public void setColuna(char coluna) {
		this.coluna = coluna;
	}

	@Override
	public String getForma() {
		return forma;
	}

	@Override
	public void setForma(String forma) {
		this.forma = forma;
	}
	
	@Override
	public void setPosicao(char[] posicao) {
		this.setLinha(posicao[0]);
		this.setColuna(posicao[1]);
	}

	@Override
	public ArrayList<String> getId() {
		return id;
	}

	public void setId(ArrayList<String> id) {
		this.id = id;
	}

	public void addId(String id) {
		this.id.add(id);
	}
	
}
