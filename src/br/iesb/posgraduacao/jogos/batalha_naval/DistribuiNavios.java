package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class DistribuiNavios {
	
	public DistribuiNavios(CampoBatalha campo){
	}

	public static void main(String[] args) {

	}	

	public ArrayList<NavioGuerra> criarNaviosGuerra(int qtNavios, int qtCanos, char orientacao){
		ArrayList<NavioGuerra> navios = new ArrayList<NavioGuerra>();
		char col = '0';
		char[] posicaoInicio = {'A','1'};
		for (Integer i = 0; i < qtNavios; i++) {
			navios.add(new NavioGuerra());
		}
		for (int i = 0; i < navios.size(); i++) {
			navios.get(i).setOrientacao(orientacao);
			navios.get(i).setQtCanos(qtCanos);
			navios.get(i).setTipo('G');
			navios.get(i).setPosicaoInicio(posicaoInicio);
			for (int j = 0; j < qtCanos; j++) {
				if(orientacao == 'V'){
					navios.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra(navios.get(i).linhas[j].charAt(0), '1'));
				}else{ //orientacao = H
					if(navios.get(i).colunas[j] == "10"){
						col = '0';
					}else{
						col = navios.get(i).colunas[j].charAt(0);
					}
					navios.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra('A', col));
				}	
			}
		}
		return navios;
	}
}
