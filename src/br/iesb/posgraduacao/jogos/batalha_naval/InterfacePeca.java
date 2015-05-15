/*
 * InterfacePeca
 * 
 * version 1.0
 * 
 * Copyrights IESB
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

/**
 * 
 * @author RobertoOliveira matrícula 1531030023
 * todas as peças que podem compor o tabuleiro
 * deverão implementar essa interface
 *
 */
public interface InterfacePeca {
	public boolean isAtingido();
	public void setAtingido(boolean atingido);
	public boolean isVisivel();
	public void setVisivel(boolean visivel);
	public char getLinha();
	public char getColuna();
	public void setLinha(char linha);
	public void setColuna(char coluna);
	public void setPosicao(char[] posicao);
	public String getForma();
	public void setForma(String forma);
	public ArrayList<String> getDescription();
	public void setDescription(ArrayList<String> description);
	public void addDescription(String description);
	public String getId();
	public void setId(String id);
	public String getName();
}
