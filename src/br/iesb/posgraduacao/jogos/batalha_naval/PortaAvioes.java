package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class PortaAvioes extends NavioGuerra {
	/**
	 * Direção do Porta Aviões determina se é
	 * D = Direita
	 * E = Esqueda
	 * C = Cima
	 * B = Baixo 
	 */
	private char direcao;
	private ArrayList<Character> direcoesValidas;
	private String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
	private ArrayList<PedacoPortaAvioes> pedacosPortaAvioes;

	public PortaAvioes() {
		direcoesValidas.add('D');
		direcoesValidas.add('E');
		direcoesValidas.add('C');
		direcoesValidas.add('B');
	}

	public char getDirecao() {
		return direcao;
	}

	public void setDirecao(char direcao) {
		if(direcoesValidas.indexOf(direcao) > 0){
			this.direcao = direcao;
		}else{
			throw new Error("E002 direção do Porta Aviões inválida");
		}
	}
	
	public void setPosicaoInicio(Character[] posicaoInicio, Integer tamanhoMatriz) {
		if (posicaoInicio.length == 2){
			if(tamanhoMatriz <= linhas.length){
				if(posicaoInicio[0].toString()+posicaoInicio[1].toString() != "A1" 
						&& posicaoInicio[0].toString()+posicaoInicio[1].toString() != "A"+tamanhoMatriz.toString()
						&& posicaoInicio[0].toString()+posicaoInicio[1].toString() != linhas[tamanhoMatriz]+"1"
						&& posicaoInicio[0].toString()+posicaoInicio[1].toString() != linhas[tamanhoMatriz]+tamanhoMatriz.toString()){
					char[] pinicial = {posicaoInicio[0],posicaoInicio[1]};
					super.setPosicaoInicio(pinicial);
				}else{
					throw new Error("Porta Avioes não pode ter posição inicial nos cantos da matriz.");
				}
			}else{
				throw new Error("Posição inicial maior que permitido na matriz.");
			}
		}else{
			throw new Error("Necessário informar linha e coluna da posição inicial.");
		}
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
		if(this.getTipo() == 'P'){
			this.pedacosPortaAvioes.add(pedacoPortaAvioes);
		}else{
			//throw new Error("Não é possível adicionar pedaços de Navio de Guerra no Porta Aviões");
		}
		
	}

}
