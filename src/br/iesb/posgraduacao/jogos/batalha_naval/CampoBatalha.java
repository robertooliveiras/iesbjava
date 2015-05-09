/**
 * 
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*** 
 * @author RobertoOliveira
 * @since 2015/05/04
 * Essa classe monta o campoDeBatalha de batalha do jogo batalha naval
 * Por padrão todas as peças do campoDeBatalha são do tipo Agua e podrão
 * ser configurados para o tipo Navio de Guerra de 1 a 4 canos
 * ou para o tipo Porta Aviões em pormato de T.
 *
 */
public class CampoBatalha {
	public List<String> posicoesValidas = new ArrayList<String>();
	public List<String> tiposNaviosValidos = new ArrayList<String>();
	public List<String> eixosValidas = new ArrayList<String>();
	public List<String> direcoesValidas = new ArrayList<String>();
	public List<String> tamanhosValidos = new ArrayList<String>();
	public String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
	public String[] colunas = {"1","2","3","4","5","6","7","8","9","10"};
	public Character[] linhasChar = {'A','B','C','D','E','F','G','H','I','J'};
	public Character[] colunasChar = {'1','2','3','4','5','6','7','8','9','0'};
	protected ArrayList<NavioGuerra> naviosGuerra = new ArrayList<NavioGuerra>();
	protected ArrayList<PortaAvioes> portaAvioes = new ArrayList<PortaAvioes>();
//	public ArrayList<ArrayList<Peca>> frota = new ArrayList<ArrayList<Peca>>();
	public Random rnd = new Random(System.currentTimeMillis());
	@SuppressWarnings("rawtypes")
	public Peca[][] campoDeBatalha;
	
	public static void main(String[] args) {
		
		CampoBatalha cb = new CampoBatalha(true);
		cb.imprimeCampoDeBatalha();
		System.out.println("\n");
		
//		Ataque do jogador
//		String a = "C7";
//		int L = cb.getIndexOfLinhasChar(a.charAt(0));
//		int C = cb.getIndexOfColunasChar(a.charAt(1));
//		System.out.println(L);
//		System.out.println(C);
//		cb.campo[L][C].getTPeca().setAtingido(true);
//		System.out.println(cb.campo[L][C].getTPeca().getForma());

//		Ataque do computador
		char[] cell;		
		cell = cb.getRandomicCellChar();
		cb.getPecaCampoBatalhaByPositionChar(cell).getTPeca().setAtingido(true);
		

		cb.imprimeCampoDeBatalha();
		System.out.println("\n");
		
		System.exit(0);
	}
	
	@SuppressWarnings("rawtypes")
	public Peca getPecaCampoBatalhaByPositionChar(char[] p) {
		int[] i = new int[2];
		i[0] = getIndexOfLinhasChar(p[0]);
		i[1] = getIndexOfColunasChar(p[1]);
		return this.campoDeBatalha[i[0]][i[1]];
	}
	
	/**
	 * Construtor da classe que chama o metodo initCampo para 
	 * criar o campo de batalha (grelha) com objetos Agua
	 */
	public CampoBatalha(boolean posicionarAleatoriamente) {
		initCampo();
		if(posicionarAleatoriamente) {
			posicionaPortaAvioesAleatoriamente();
			for (int i = 0; i < 4; i++) {
				posicionaNavioGuerraAleatoriamente(1);
			}
			for (int i = 0; i < 3; i++) {
				posicionaNavioGuerraAleatoriamente(2);
			}
			for (int i = 0; i < 2; i++) {
				posicionaNavioGuerraAleatoriamente(3);
			}
			posicionaNavioGuerraAleatoriamente(4);
		}else{
			boolean posicionamentoManualOk = false;
			do{
				posicionamentoManualOk = true;
			}while(!posicionamentoManualOk);
		}
	}
	
	/*
	 * Utilizada no construtor para preencher a grelha (representada pelo atributo campoDeBatalha)
	 * com peças do tipo Agua (usando generics). Após a criação da grelha, as peças serão distribuídas
	 * no tabuleiro conforme regra do requisito do exercício.
	 */
	private void initCampo() {
		Agua a;
		char[] posicao = new char[2];
		Peca<Agua> pt;
		campoDeBatalha = new Peca[linhas.length][colunas.length];
		for (int i = 0; i < linhas.length; i++) {
			for (int j = 0; j < colunas.length; j++) {
				posicao[0] = linhasChar[i];
				posicao[1] = colunasChar[j];
				a = new Agua();
				a.setPosicao(posicao);
				pt = new Peca<Agua>();
				pt.setTPeca(a);
				pt.getTPeca().setPosicao(posicao);
				campoDeBatalha[i][j] = pt;
			}
		}
		
		tiposNaviosValidos.add("P");
		tiposNaviosValidos.add("G");
		
		posicoesValidas.add("A1");
		//até
		posicoesValidas.add("J10");
		
		eixosValidas.add("V");
		eixosValidas.add("H");
		
		direcoesValidas = new ArrayList<String>();
		
		direcoesValidas.add("D"); //direita
		direcoesValidas.add("E"); //esquerda
		direcoesValidas.add("C"); //cima
		direcoesValidas.add("B"); //baixo
		
		tamanhosValidos.add("1");
		tamanhosValidos.add("2");
		tamanhosValidos.add("3");
		tamanhosValidos.add("4");
	}
	
	/*
	 * A distribuição aleatória dos navios de guerra contará com
	 * 4 navios de guerra com 1 cano 
	 * 3 navios de guerra com 2 canos (verticais ou horizontais)
	 * 2 navios de guerra com 3 canos (verticais ou horizontais)
	 * 1 navio de guerra com 4 canos (verticais ou horizontais)
	 */
	private void posicionaNavioGuerraAleatoriamente(int t) {
		char[] posicaoInicial = new char[2];
		int[] indexPosicaoInicial = new int[2];
		int eixo; // 0 = horizontal; 1 = vertical
		boolean posicaoPAok = false;
		while(!posicaoPAok) {
			posicaoInicial = getRandomicCellChar();
			eixo = getPositiveRandomNumber(2, this.rnd); // 0 = horizontal; 1 = vertical
//			System.out.println(posicaoInicial[0] + "" + posicaoInicial[1] + " " + eixo);
			if(validaPosicaoInicialNG(posicaoInicial, eixo, t)) {
				indexPosicaoInicial[0] = getIndexOfLinhasChar(posicaoInicial[0]);
				indexPosicaoInicial[1] = getIndexOfColunasChar(posicaoInicial[1]);
				posicaoPAok = validaDisponibilidadePosicaoNG(indexPosicaoInicial, eixo, t);
				if(posicaoPAok) {
					posicionaNavioGuerra(indexPosicaoInicial, eixo, t);
				}
			}
		}
	}
	
	/**
	 * A distribuição aleatória do porta aviões contará com
	 * 1 porta aviões com 5 canos (em T) (base horizontal virado para direita ou esquerda; ou vertical e virado para cima ou para baixo)
	 */
	private void posicionaPortaAvioesAleatoriamente() {
		//posiciona o porta aviões
		char[] posicaoInicial = new char[2];
		int[] indexPosicaoInicial = new int[2];
		int eixo; // 0 = horizontal; 1 = vertical
		int direcao; // 0 = direita(v) ou cima(h); 1 = esquerda(v) ou baixo(h)
		boolean posicaoPAok = false;
		while(!posicaoPAok) {
			posicaoInicial = getRandomicCellChar();
			eixo = getPositiveRandomNumber(2, this.rnd); // 0 = horizontal; 1 = vertical
			direcao = getPositiveRandomNumber(2, this.rnd); // 0 = direita(v) ou cima(h); 1 = esquerda(v) ou baixo(h)
			if(validaPosicaoInicialPA(posicaoInicial, eixo, direcao)) {
				indexPosicaoInicial[0] = getIndexOfLinhasChar(posicaoInicial[0]);
				indexPosicaoInicial[1] = getIndexOfColunasChar(posicaoInicial[1]);
				posicaoPAok = validaDisponibilidadePosicaoPA(indexPosicaoInicial, eixo, direcao);
				if(posicaoPAok) {
					posicionaPortaAvioes(indexPosicaoInicial, eixo, direcao);
				}
			}
		}
	}
	public void posicionaNavioGuerra(int[] p, int e, Integer t) {
		PedacoNavioGuerra mpng;
		Peca<PedacoNavioGuerra> png;
		ArrayList<Peca<PedacoNavioGuerra>> pecasNavioGuerra = new ArrayList<Peca<PedacoNavioGuerra>>();
		for (int i = 0; i < t; i++) {
			mpng = new PedacoNavioGuerra(t.toString().charAt(0));
			mpng.setPosicao(getCharValuesByIndex(p));
			mpng.setVisivel(true);
			png = new Peca<PedacoNavioGuerra>();
			png.setTPeca(mpng);
			pecasNavioGuerra.add(png);
		}
		
		NavioGuerra ng = new NavioGuerra();
		ng.setTipo('G');
		ng.setOrientacao(e);
		ng.setPosicaoInicio(p);
		ng.setQtCanos(t);
		
		int l = p[0];
		int c = p[1];
		for (int i = 0; i < pecasNavioGuerra.size(); i++) {
			ng.addPedacoNavioGuerra(pecasNavioGuerra.get(i).getTPeca());
			if(e == 0) {//horizontal => direçao direita
				this.campoDeBatalha[l][c++] = pecasNavioGuerra.get(i);//posicao inicial
			} else {//vertical => direçao baixo
				this.campoDeBatalha[l++][c] = pecasNavioGuerra.get(i);//posicao inicial
			}
		}
		this.naviosGuerra.add(ng);
	}
	public void posicionaPortaAvioes(int[] p, int e, int d) {
		PedacoPortaAvioes mppa;
		Peca<PedacoPortaAvioes> ppa;
		ArrayList<Peca<PedacoPortaAvioes>> pecasPortaAvioes = new ArrayList<Peca<PedacoPortaAvioes>>();
		for (int i = 0; i < 5; i++) {
			mppa = new PedacoPortaAvioes();
			mppa.setPosicao(getCharValuesByIndex(p));
			mppa.setVisivel(true);
			ppa = new Peca<PedacoPortaAvioes>();
			ppa.setTPeca(mppa);
			pecasPortaAvioes.add(ppa);
		}
		
		this.campoDeBatalha[p[0]][p[1]] = pecasPortaAvioes.get(0);//posicao inicial
		
		if(e == 0) {//horizontal => direçao será baixo(0)=T ou cima(1)=T invertido
			if(d == 0) {
				this.campoDeBatalha[p[0]+1][p[1]] = pecasPortaAvioes.get(1);
				this.campoDeBatalha[p[0]+2][p[1]] = pecasPortaAvioes.get(2);
				this.campoDeBatalha[p[0]][p[1]-1] = pecasPortaAvioes.get(3);
				this.campoDeBatalha[p[0]][p[1]+1] = pecasPortaAvioes.get(4);
			} else {
				this.campoDeBatalha[p[0]-1][p[1]] = pecasPortaAvioes.get(1);
				this.campoDeBatalha[p[0]-2][p[1]] = pecasPortaAvioes.get(2);
				this.campoDeBatalha[p[0]][p[1]-1] = pecasPortaAvioes.get(3);
				this.campoDeBatalha[p[0]][p[1]+1] = pecasPortaAvioes.get(4);
			}
		} else {//vertical => direçao será direita(0)H sem aste direita ou esquerda(1) H sem aste esquerda
			if(d == 0) {
				this.campoDeBatalha[p[0]-1][p[1]] = pecasPortaAvioes.get(1);
				this.campoDeBatalha[p[0]+1][p[1]] = pecasPortaAvioes.get(2);
				this.campoDeBatalha[p[0]][p[1]+1] = pecasPortaAvioes.get(3);
				this.campoDeBatalha[p[0]][p[1]+2] = pecasPortaAvioes.get(4);
			} else {
				this.campoDeBatalha[p[0]-1][p[1]] = pecasPortaAvioes.get(1);
				this.campoDeBatalha[p[0]+1][p[1]] = pecasPortaAvioes.get(2);
				this.campoDeBatalha[p[0]][p[1]-1] = pecasPortaAvioes.get(3);
				this.campoDeBatalha[p[0]][p[1]-2] = pecasPortaAvioes.get(4);
			}
		}
		
		PortaAvioes pa = new PortaAvioes();
		pa.setTipo('P');
		pa.setOrientacao(e);
		pa.setPosicaoInicio(p);
		pa.setQtCanos(5);
		pa.setDirecao(d);

		for (int i = 0; i < pecasPortaAvioes.size(); i++) {
			pa.addPedacoPortaAvioes(pecasPortaAvioes.get(i).getTPeca());
		}
		this.portaAvioes.add(pa);
		
	}
	public boolean validaDisponibilidadePosicaoNG(int[] p, int e, int t) {
		int l = p[0];
		int c = p[1];
		if(e == 0) {//horizontal => direçao direita
			if(c-1 >= 0) {
				if(!(this.campoDeBatalha[l][c-1].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			for (int i = 0; i < t; i++) {
				if(c>9) return false;
				if(l-1 >= 0) {
					if(!(this.campoDeBatalha[l-1][c].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(l+1 < linhas.length) {
					if(!(this.campoDeBatalha[l+1][c].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(!(this.campoDeBatalha[l][c++].getTPeca() instanceof Agua)) {
					return false;
				}
				
			}
			if(c < colunas.length) {
				if(!(this.campoDeBatalha[l][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			
		} else {//vertical => direçao baixo

			if(l-1 >= 0) {
				if(!(this.campoDeBatalha[l-1][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			for (int i = 0; i < t; i++) {
				if(c-1 >= 0) {
					if(!(this.campoDeBatalha[l][c-1].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(c+1 < colunas.length) {
					if(!(this.campoDeBatalha[l][c+1].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(!(this.campoDeBatalha[l++][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			if(l < linhas.length) {
				if(!(this.campoDeBatalha[l][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean validaDisponibilidadePosicaoPA(int[] p, int e, int d) {
		if(!(this.campoDeBatalha[p[0]][p[1]].getTPeca() instanceof Agua)) {
			return false;
		}
		if(e == 0) {//horizontal => direçao 
			if(d == 0) {
				if(!(this.campoDeBatalha[p[0]+1][p[1]].getTPeca() instanceof Agua)
					|| !(this.campoDeBatalha[p[0]+2][p[1]].getTPeca() instanceof Agua)
					|| !(this.campoDeBatalha[p[0]][p[1]-1].getTPeca() instanceof Agua)
					|| !(this.campoDeBatalha[p[0]][p[1]+1].getTPeca() instanceof Agua)) {
					return false;
				}
			} else {
				if(!(this.campoDeBatalha[p[0]-1][p[1]].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]-2][p[1]].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]][p[1]-1].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]][p[1]+1].getTPeca() instanceof Agua)) {
						return false;
					}
			}
		} else {//vertical => direçao será direita(0)H sem aste direita ou esquerda(1) H sem aste esquerda
			if(d == 0) {
				if(!(this.campoDeBatalha[p[0]-1][p[1]].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]+1][p[1]].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]][p[1]+1].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]][p[1]+2].getTPeca() instanceof Agua)) {
						return false;
					}
			} else {
				if(!(this.campoDeBatalha[p[0]-1][p[1]].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]+1][p[1]].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]][p[1]-1].getTPeca() instanceof Agua)
						|| !(this.campoDeBatalha[p[0]][p[1]-2].getTPeca() instanceof Agua)) {
						return false;
					}
			}
		}
		return true;
	}
	
	public boolean validaPosicaoInicialNG(char[] p, int e, int t) {
		if(getIndexOfLinhasChar(p[0]) == -1 || getIndexOfColunasChar(p[1]) == - 1) {//index não encontrado
			return false;
		}
		
		if(!(this.campoDeBatalha[getIndexOfLinhasChar(p[0])][getIndexOfColunasChar(p[1])].getTPeca() instanceof Agua)) {
			return false;
		}
		
		if(e == 0) { //horizontal => direçao será baixo(0)=T ou cima(1)=T invertido
			if(getIndexOfLinhasChar(p[1])+t > colunas.length - 1) {//index não encontrado
				return false;
			}
		} else {//vertical => direçao será direita(0) ou esquerda(1)
			if(getIndexOfLinhasChar(p[0])+t > linhas.length - 1) {//index não encontrado
				return false;
			}
		}
		return true;
	}
	
	public boolean validaPosicaoInicialPA(char[] p, int e, int d) {
		if(getIndexOfLinhasChar(p[0]) == -1 || getIndexOfColunasChar(p[1]) == - 1) {//index não encontrado
			return false;
		}
		if(getIndexOfLinhasChar(p[0]) == 0 && getIndexOfColunasChar(p[1]) == 0) {//A1
			return false;
		}
		if(getIndexOfLinhasChar(p[0]) == linhas.length - 1 && getIndexOfColunasChar(p[1]) == colunas.length - 1) {//J10
			return false;
		}
		if(getIndexOfLinhasChar(p[0]) == 0 && getIndexOfColunasChar(p[1]) == colunas.length - 1) {//A10
			return false;
		}
		if(getIndexOfLinhasChar(p[0]) == linhas.length - 1 && getIndexOfColunasChar(p[1]) == 0) {//J1
			return false;
		}
		if(e == 0) { //horizontal => direçao será baixo(0)=T ou cima(1)=T invertido
			if(getIndexOfColunasChar(p[1]) == 0 || getIndexOfColunasChar(p[1]) == colunas.length - 1) {//coluna 0 ou última coluna
				return false;
			}
			if(d == 0) {// baixo (parece um T invertido). não pode linha A(0) nem B(1)
				if(getIndexOfLinhasChar(p[0]) - 2 < 0 ) {//passou do limite da linha
					return false;
				}
				if(getIndexOfLinhasChar(p[0]) + 2 > linhas.length - 1 ) {//passou do limite da linha
					return false;
				}
			 } else { // cima (parece um T). não pode linha I(9) nem J(10)
				if(getIndexOfLinhasChar(p[0]) + 2 > linhas.length - 1 ) {//passou do limite da linha
					return false;
				}
				if(getIndexOfLinhasChar(p[0]) - 1 < 0 || getIndexOfLinhasChar(p[0]) + 1 > colunas.length - 1 ) {//passou do limite da linha
					return false;
				}
				if(getIndexOfLinhasChar(p[0]) - 2 < 0 || getIndexOfLinhasChar(p[0]) + 2 > colunas.length - 1 ) {//passou do limite da linha
					return false;
				}
			}
		} else {//vertical => direçao será direita(0) ou esquerda(1)
			if(getIndexOfLinhasChar(p[0]) == 0 || getIndexOfLinhasChar(p[0]) == linhas.length - 1) {//linha 0 ou última linha
				return false;
			}
			if(d == 0) { // direita (parece um H sem aste da direita). não pode coluna 9 nem 10
				if(getIndexOfColunasChar(p[1]) + 2 > colunas.length - 1 ) {//passou do limite da coluna
					return false;
				}
			} else { // baixo (parece um H sem aste da esquerda). não pode coluna 1 nem 2
				if(getIndexOfColunasChar(p[1]) - 2 < 0 ) {//passou do limite da coluna
					return false;
				}
			}
		}
		return true;
	}
	
	public void imprimeCampoDeBatalha() {
		System.out.println();
		for (int i = 0; i < this.campoDeBatalha.length; i++) {
			System.out.print(this.linhas[i] + " ");
			for (int j = 0; j < this.campoDeBatalha[i].length; j++) {
				System.out.print(this.campoDeBatalha[i][j].getTPeca().getForma());
			}
			System.out.println();
		}
		for (int i = 0; i < this.campoDeBatalha.length; i++) {
			System.out.print("    " + this.colunas[i] );
		}
		System.out.println();
	}
	
	public char[] getCharValuesByIndex(int[] p) {
		char[] v = new char[2];
		v[0] = linhasChar[p[0]];
		v[1] = colunasChar[p[1]];
		return v;
	}
	
	public String[] getStrValuesByIndex(int[] p) {
		String[] v = new String[2];
		v[0] = linhas[p[0]];
		v[1] = colunas[p[1]];
		return v;
	}
	
	public int getIndexOfLinhas(String c) {
		int index = -1;
		for (int i = 0; i < this.linhas.length; i++) {
			if(this.linhas[i] == c) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int getIndexOfColunas(String c) {
		int index = -1;
		for (int i = 0; i < this.colunas.length; i++) {
			if(this.colunas[i] == c) {
				index = i;
				break;
			}
		}
		return index;
	}	
	
	public int getIndexOfLinhasChar(char c) {
		int index = -1;
		for (int i = 0; i < this.linhasChar.length; i++) {
			if(this.linhasChar[i] == c) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int getIndexOfColunasChar(char c) {
		int index = -1;
		for (int i = 0; i < this.colunasChar.length; i++) {
			if(this.colunasChar[i] == c) {
				index = i;
				break;
			}
		}
		return index;
	}	

//	public void criarNaviosGuerra(int qtNavios, int qtCanos, char orientacao) {
//		char col = '0';
//		char[] posicaoInicio = {'A','1'};
//		for (Integer i = 0; i < qtNavios; i++) {
//			this.naviosGuerra.add(new NavioGuerra());
//		}
//		for (int i = 0; i < this.naviosGuerra.size(); i++) {
//			this.naviosGuerra.get(i).setOrientacao(orientacao);
//			this.naviosGuerra.get(i).setQtCanos(qtCanos);
//			this.naviosGuerra.get(i).setTipo('G');
//			this.naviosGuerra.get(i).setPosicaoInicio(posicaoInicio);
//			for (int j = 0; j < qtCanos; j++) {
//				if(orientacao == 'V') {
//					this.naviosGuerra.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra());
//				} else { //orientacao = H
//					if(this.naviosGuerra.get(i).colunas[j] == "10") {
//						col = '0';
//					} else {
//						col = this.naviosGuerra.get(i).colunas[j].charAt(0);
//					}
//					this.naviosGuerra.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra());
//				}	
//			}
//		}
//	}
	
	public String[] getRandomicCell() {
		int Lr = this.getPositiveRandomNumber(10,this.rnd);
		int Cr = this.getPositiveRandomNumber(10,this.rnd);
		String[] p = new String[2];
		p[0] = this.linhas[Lr];
		p[1] = this.colunas[Cr];
		return p;
	}
	
	public char[] getRandomicCellChar() {
		int Lr = this.getPositiveRandomNumber(10,this.rnd);
		int Cr = this.getPositiveRandomNumber(10,this.rnd);
		char[] p = new char[2];
		p[0] = this.linhasChar[Lr];
		p[1] = this.colunasChar[Cr];
		return p;
	}
	
	public int getPositiveRandomNumber(int s, Random rnd) {
		int n = rnd.nextInt(s);
		List<Integer> aceitos = new ArrayList<Integer>();
		for (int z = 0; z < s; z++) {
			aceitos.add(z);
		}
		while(n < 0) {
			n = rnd.nextInt(s);
		}
		return aceitos.get(n);
	}
	
}
