package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		
		Teste m = new Teste();
		ArrayList<NavioGuerra> n1cano = m.criarNaviosGuerra(4, 1,'V');
		for (int i = 0; i < n1cano.size(); i++) {
			System.out.print(n1cano.get(i).getOrientacao());
			System.out.print(n1cano.get(i).getQtCanos());
			System.out.print(n1cano.get(i).getTipo());
			System.out.print(n1cano.get(i).getPosicaoInicio()[0]);
			System.out.print(n1cano.get(i).getPosicaoInicio()[1]);
			ArrayList<PedacoNavioGuerra> p = n1cano.get(i).getPedacosNavioGuerra();
			System.out.print(p.size());
			System.out.print(" ");
			for (int j = 0; j < p.size(); j++) {
				System.out.print(p.get(j).isAtingido());
				System.out.print(p.get(j).isVisivel());
				System.out.print(p.get(j).getForma());
				System.out.print(p.get(j).getLinha());
				System.out.print(p.get(j).getColuna());
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

		ArrayList<NavioGuerra> n2cano = m.criarNaviosGuerra(3, 2,'V');
		for (int i = 0; i < n2cano.size(); i++) {
			System.out.print(n2cano.get(i).getOrientacao());
			System.out.print(n2cano.get(i).getQtCanos());
			System.out.print(n2cano.get(i).getTipo());
			System.out.print(n2cano.get(i).getPosicaoInicio()[0]);
			System.out.print(n2cano.get(i).getPosicaoInicio()[1]);
			ArrayList<PedacoNavioGuerra> p = n2cano.get(i).getPedacosNavioGuerra();
			System.out.print(p.size());
			System.out.print(" ");
			for (int j = 0; j < p.size(); j++) {
				System.out.print(p.get(j).isAtingido());
				System.out.print(p.get(j).isVisivel());
				System.out.print(p.get(j).getForma());
				System.out.print(p.get(j).getLinha());
				System.out.print(p.get(j).getColuna());
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

		ArrayList<NavioGuerra> n3cano = m.criarNaviosGuerra(2, 3,'V');
		for (int i = 0; i < n3cano.size(); i++) {
			System.out.print(n3cano.get(i).getOrientacao());
			System.out.print(n3cano.get(i).getQtCanos());
			System.out.print(n3cano.get(i).getTipo());
			System.out.print(n3cano.get(i).getPosicaoInicio()[0]);
			System.out.print(n3cano.get(i).getPosicaoInicio()[1]);
			ArrayList<PedacoNavioGuerra> p = n3cano.get(i).getPedacosNavioGuerra();
			System.out.print(p.size());
			System.out.print(" ");
			for (int j = 0; j < p.size(); j++) {
				System.out.print(p.get(j).isAtingido());
				System.out.print(p.get(j).isVisivel());
				System.out.print(p.get(j).getForma());
				System.out.print(p.get(j).getLinha());
				System.out.print(p.get(j).getColuna());
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

		ArrayList<NavioGuerra> n4cano = m.criarNaviosGuerra(1, 4,'V');
		for (int i = 0; i < n4cano.size(); i++) {
			System.out.print(n4cano.get(i).getOrientacao());
			System.out.print(n4cano.get(i).getQtCanos());
			System.out.print(n4cano.get(i).getTipo());
			System.out.print(n4cano.get(i).getPosicaoInicio()[0]);
			System.out.print(n4cano.get(i).getPosicaoInicio()[1]);
			ArrayList<PedacoNavioGuerra> p = n4cano.get(i).getPedacosNavioGuerra();
			System.out.print(p.size());
			System.out.print(" ");
			for (int j = 0; j < p.size(); j++) {
				System.out.print(p.get(j).isAtingido());
				System.out.print(p.get(j).isVisivel());
				System.out.print(p.get(j).getForma());
				System.out.print(p.get(j).getLinha());
				System.out.print(p.get(j).getColuna());
				System.out.print(" ");
			}
			System.out.println();
		}

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
					navios.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra());
				}else{ //orientacao = H
					if(navios.get(i).colunas[j] == "10"){
						col = '0';
					}else{
						col = navios.get(i).colunas[j].charAt(0);
					}
					navios.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra());
				}	
			}
		}
		return navios;
	}
}
