package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class NavioGuerra extends Navio {
	
	ArrayList<PedacoNavioGuerra> pedacosNavioGuerra = new ArrayList<PedacoNavioGuerra>();
	ArrayList<PedacoPortaAvioes> pedacosPortaAvioes = new ArrayList<PedacoPortaAvioes>();
	/**
	 * Quantidade de canos do navio 
	 * pode ser de 1 a 4 canos
	 */
	private int qtCanos = 1;
	/**
	 * Posição do pedaço inicial do navio
	 * ajuda a determinar a posição dos outros pedaços
	 * considerando a quantidade de canos
	 */
	private char[] posicaoInicio = new char[2];
	/**
	 * Determina a posição no eixo 
	 * V = Vertical = 0
	 * H = Horizontal = 1
	 */
	private char orientacao = 'V';
	
	public int getQtCanos() {
		return qtCanos;
	}
	
	public void setQtCanos(int tamanho) {
			this.qtCanos = tamanho;
	}
	
	public char[] getPosicaoInicio() {
		return posicaoInicio;
	}
	
	public void setPosicaoInicio(char[] posicaoInicio) {
			this.posicaoInicio = posicaoInicio;
	}
	
	public void setPosicaoInicio(int[] posicaoInicio) {
			this.posicaoInicio[0] = linhasChar[posicaoInicio[0]];
			this.posicaoInicio[1] = colunasChar[posicaoInicio[1]];
	}

	public char getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(char orientacao) {
		this.orientacao = orientacao;
	}

	public void setOrientacao(int orientacao) {
		if(orientacao == 0){
			this.orientacao = 'H';
		}else if(orientacao == 1){
			this.orientacao = 'V';
		}
		
	}

	
	public ArrayList<PedacoNavioGuerra> getPedacosNavioGuerra() {
			return pedacosNavioGuerra;
	}

	public void setPedacosNavioGuerra(ArrayList<PedacoNavioGuerra> pedacosNavioGuerra) {
		if(this.getTipo() == 'G'){
			this.pedacosNavioGuerra = pedacosNavioGuerra;
		}else{
			throw new Error("Não é possível adicionar pedaços de Porta Aviões no Navio de Guerra");
		}
	}

	public void addPedacoNavioGuerra(PedacoNavioGuerra pedacoNavioGuerra) {
		if(this.getTipo() == 'G'){
			this.pedacosNavioGuerra.add(pedacoNavioGuerra);
		}else{
			//throw new Error("Não é possível adicionar pedaços de Porta Aviões no Navio de Guerra");
		}
	}
}
