package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class PortaAvioes extends NavioGuerra {
//	/**
//	 * Eixo do Porta Aviões determina se é
//	 * 0 = Horizontal (H)
//	 * 1 = Vertical (V)
//	 */
//	private int eixo;
	/**
	 * Direção do Porta Aviões determina se é
	 * SE EIXO FOR HORIZONTAL (H)
	 *    0 = para baixo (forma de T) 
	 *    1 = para cima  (forma de T invertido)
	 * SE EIXO FOR VERTICAL (V)
	 *    0 = para direita  (forma de H sem aste direita) 
	 *    1 = para esquerda (forma de H sem aste esquerda)
	 */
	private int direcao;
	private ArrayList<Integer> eixosValidos = new ArrayList<Integer>();
	private ArrayList<Integer> direcoesValidas = new ArrayList<Integer>();
	private ArrayList<PedacoPortaAvioes> pedacosPortaAvioes = new ArrayList<PedacoPortaAvioes>();

	public PortaAvioes() {
		eixosValidos.clear();
		direcoesValidas.clear();
		
		eixosValidos.add(0);
		eixosValidos.add(1);

		direcoesValidas.add(0);
		direcoesValidas.add(1);
	}

	public int getDirecao() {
		return this.direcao;
	}

	public char getDirecaoChar() {
		if(this.direcao == 0){
			return 'H';
		}else if(this.direcao == 1){
			return 'V';
		}else{
			return 'S'; //sem direçao configurada
		}
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}
	
	public void setPosicaoInicio(char[] posicaoInicio) {
			super.setPosicaoInicio(posicaoInicio);
	}
	
	public void setPosicaoInicio(int[] posicaoInicio) {
			super.setPosicaoInicio(posicaoInicio);
	}

	public ArrayList<PedacoPortaAvioes> getPedacosPortaAvioes() {
		return pedacosPortaAvioes;
	}

	public void setPedacosPortaAvioes(ArrayList<PedacoPortaAvioes> pedacosPortaAvioes) {
		if(this.getTipo() == 'P'){
			this.pedacosPortaAvioes = pedacosPortaAvioes;
		}else{
			//throw new Error("Não é possível adicionar pedaços de Navio de Guerra no Porta Aviões");
		}
		
	}

	public void addPedacoPortaAvioes(PedacoPortaAvioes pedacoPortaAvioes) {
		this.pedacosPortaAvioes.add(pedacoPortaAvioes);
	}

}
