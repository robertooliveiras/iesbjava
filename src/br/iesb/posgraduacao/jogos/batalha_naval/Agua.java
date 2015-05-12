/*
 * Agua
 * 
 * version 1.0
 * 
 * Copyrights IESB
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

/**
 * @author RobertoOliveira matrícula 1531030023
 * @since 2015-05-04
 *
 */

public class Agua implements InterfacePeca {
    private boolean visivel = true;
    private boolean atingido = false;
    private char linha;
    private char coluna;
    private String forma = "~~~~|";
    private ArrayList<String> id = new ArrayList<String>();

    @Override
	public boolean isAtingido() {
        return this.atingido;
    }

    @Override
	public void setAtingido(boolean atingido) {
        this.atingido = atingido;
        this.visivel = true;
        this.setForma("~§§~|");
    }

    @Override
	public boolean isVisivel() {
        return this.visivel;
    }

    @Override
	public void setVisivel(boolean visivel) {
        this.visivel = visivel;
        this.setForma("~~~~|");
        if (this.isAtingido()) {
            if (visivel) {
                this.setForma("~§§~|");
            } else {
                this.setForma("~~~~|");                
            }
        }
    }

    @Override
	public char getLinha() {
        return linha;
    }

    @Override
	public char getColuna() {
        return coluna;
    }
    
    @Override
	public void setPosicao(char[] posicao) {
        this.linha = posicao[0];
        this.coluna = posicao[1];
    }

    /**
     * @return the forma
     */
    @Override
	public String getForma() {
        return forma;
    }

    /**
     * @param forma the forma to set
     */
    @Override
	public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public ArrayList<String> getId() {
	return id;
    }

    public void setId(ArrayList<String> id) {
	this.id.clear();
	this.id = id;
    }

    public void addId(String id) {
	this.id.add(id);
    }

    @Override
    public void setLinha(char linha) {
	this.linha = linha;
    }

    @Override
    public void setColuna(char coluna) {
	this.coluna = coluna;
    }

}
