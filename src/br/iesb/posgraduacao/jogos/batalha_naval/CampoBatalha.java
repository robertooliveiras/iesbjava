/**
 * @author RobertoOliveira
 * @since 2015/05/04
 * Batalha Naval com Porta Avioes em "T" + Navios de Guerra com 1 a 4 canos
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
	public List<String> posicoesNavioGuerraValidas = new ArrayList<String>();
	public List<String> posicoesPortaAvioesValidas = new ArrayList<String>();
	public String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
	public String[] colunas = {"1","2","3","4","5","6","7","8","9","10"};
	public Character[] linhasChar = {'A','B','C','D','E','F','G','H','I','J'};
	public Character[] colunasChar = {'1','2','3','4','5','6','7','8','9','0'};
	protected ArrayList<NavioGuerra> naviosGuerra = new ArrayList<NavioGuerra>();
	protected ArrayList<PortaAvioes> portaAvioes = new ArrayList<PortaAvioes>();
//	public ArrayList<ArrayList<Peca>> frota = new ArrayList<ArrayList<Peca>>();
	public Random rnd = new Random(System.currentTimeMillis());
	@SuppressWarnings("rawtypes")
	private Peca[][] campoDeBatalha;
	protected Scanner entrada = new Scanner(System.in);
	
	@SuppressWarnings("rawtypes")
	public Peca getPecaCampoBatalhaByPositionChar(char[] p) {
		int[] i = new int[2];
		i[0] = getIndexOfLinhasChar(p[0]);
		i[1] = getIndexOfColunasChar(p[1]);
		return this.campoDeBatalha[i[0]][i[1]];
	}
	
	public Peca[][] getCampoDeBatalha(){
		return this.campoDeBatalha;
	}
	
	/**
	 * Construtor da classe que chama o metodo initCampo para 
	 * criar o campo de batalha (grelha) com objetos Agua
	 */
	public CampoBatalha(boolean aleatoriamente) {
		initCampo();
		initValidadoresDeEntrada();
		posicionarFrota(aleatoriamente);
	}
	
	public void posicionarFrota(boolean aleatoriamente) {

		if(aleatoriamente) {
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
			boolean posicionamentoManualOk;
			String e;
			
			int tentativas = 0;
			for (int i = 0; i < 1; i++) {
				posicionamentoManualOk = false;
				do{
					if(tentativas == 0){
						System.out.println("informe a posição do Porta Aviões P1 ("+(i+1)+"/1):");
					}else{
						System.out.println("Atenção! Opção inválida.\n"
								+ "informe a posição do Porta Aviões P1 ("+(i+1)+"/1):");
					}
					e = entrada.nextLine();
					while(posicoesPortaAvioesValidas.indexOf(e) < 0){
						System.out.println("Atenção! Opção inválida.\n"
											+ "informe a posição do Porta Aviões P1 ("+(i+1)+"/1):");
						e = entrada.nextLine();
					}
					posicionamentoManualOk = posicionaPortaAvioesManualmente(e);
					tentativas++;
				}while(!posicionamentoManualOk);
				imprimeCampoDeBatalha();
				tentativas = 0;
			}
			
			tentativas = 0;
			for (int i = 0; i < 4; i++) {
				posicionamentoManualOk = false;
				do{
					if(tentativas == 0){
						System.out.println("informe a posição Navio de Guerra de 1 cano N1 ("+(i+1)+"/4):");
					}else{
						System.out.println("Atenção! Opção inválida.\n"
								+ "informe a posição Navio de Guerra de 1 cano N1 ("+(i+1)+"/4):");
					}
					e = entrada.nextLine();
					while(posicoesNavioGuerraValidas.indexOf(e) < 0){
						System.out.println("Atenção! Opção inválida.\n"
											+ "informe a posição Navio de Guerra de 1 cano N1 ("+(i+1)+"/4):");
						e = entrada.nextLine();
					}
					posicionamentoManualOk = posicionaNavioGuerraManualmente(1, e);
					tentativas++;
				}while(!posicionamentoManualOk);
				imprimeCampoDeBatalha();
				tentativas = 0;
			}

			tentativas = 0;
			for (int i = 0; i < 3; i++) {
				posicionamentoManualOk = false;
				do{
					if(tentativas == 0){
						System.out.println("informe a posição Navio de Guerra de 2 cano N2 ("+(i+1)+"/3):");
					}else{
						System.out.println("Atenção! Opção inválida.\n"
								+ "informe a posição Navio de Guerra de 2 cano N2 ("+(i+1)+"/3):");
					}
					e = entrada.nextLine();
					while(posicoesNavioGuerraValidas.indexOf(e) < 0){
						System.out.println("Atenção! Opção inválida.\n"
											+ "informe a posição Navio de Guerra de 2 cano N2 ("+(i+1)+"/3):");
						e = entrada.nextLine();
					}
					posicionamentoManualOk = posicionaNavioGuerraManualmente(2, e);
					tentativas++;
				}while(!posicionamentoManualOk);
				imprimeCampoDeBatalha();
				tentativas = 0;
			}

			tentativas = 0;
			for (int i = 0; i < 2; i++) {
				posicionamentoManualOk = false;
				do{
					if(tentativas == 0){
						System.out.println("informe a posição Navio de Guerra de 3 cano N3 ("+(i+1)+"/2):");
					}else{
						System.out.println("Atenção! Opção inválida.\n"
								+ "informe a posição Navio de Guerra de 3 cano N3 ("+(i+1)+"/2):");
					}
					e = entrada.nextLine();
					while(posicoesNavioGuerraValidas.indexOf(e) < 0){
						System.out.println("Atenção! Opção inválida.\n"
											+ "informe a posição Navio de Guerra de 3 cano N3 ("+(i+1)+"/2):");
						e = entrada.nextLine();
					}
					posicionamentoManualOk = posicionaNavioGuerraManualmente(3, e);
					tentativas++;
				}while(!posicionamentoManualOk);
				imprimeCampoDeBatalha();
				tentativas = 0;
			}

			tentativas = 0;
			for (int i = 0; i < 1; i++) {
				posicionamentoManualOk = false;
				do{
					if(tentativas == 0){
						System.out.println("informe a posição Navio de Guerra de 4 cano N4 ("+(i+1)+"/1):");
					}else{
						System.out.println("Atenção! Opção inválida.\n"
								+ "informe a posição Navio de Guerra de 4 cano N4 ("+(i+1)+"/1):");
					}
					e = entrada.nextLine();
					while(posicoesNavioGuerraValidas.indexOf(e) < 0){
						System.out.println("Atenção! Opção inválida.\n"
											+ "informe a posição Navio de Guerra de 4 cano N4 ("+(i+1)+"/1):");
						e = entrada.nextLine();
					}
					posicionamentoManualOk = posicionaNavioGuerraManualmente(4, e);
					tentativas++;
				}while(!posicionamentoManualOk);
				imprimeCampoDeBatalha();
				tentativas = 0;
			}
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
	}
	
	private void initValidadoresDeEntrada() {
		
		for (char i = 'a', j='A'; i <= 'j'; i++, j++) {
			for (Integer c = 1; c <= 10; c++) {
				posicoesNavioGuerraValidas.add(""+i+""+c.toString()+" v");
				posicoesNavioGuerraValidas.add(""+i+""+c.toString()+" V");
				posicoesNavioGuerraValidas.add(""+i+""+c.toString()+" h");
				posicoesNavioGuerraValidas.add(""+i+""+c.toString()+" H");
				posicoesNavioGuerraValidas.add(j +""+c.toString()+" v");
				posicoesNavioGuerraValidas.add(j +""+c.toString()+" V");
				posicoesNavioGuerraValidas.add(j +""+c.toString()+" h");
				posicoesNavioGuerraValidas.add(j +""+c.toString()+" H");
				

				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" v d");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" v e");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" V D");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" V E");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" h c");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" h b");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" H C");
				posicoesPortaAvioesValidas.add(""+i+""+c.toString()+" H B");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" v d");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" v e");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" V D");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" V E");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" h c");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" h b");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" H C");
				posicoesPortaAvioesValidas.add(j +""+c.toString()+" H B");
			}
		}
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
			if(validaPosicaoInicialNG(posicaoInicial, eixo, t)) {
				indexPosicaoInicial[0] = getIndexOfLinhasChar(posicaoInicial[0]);
				indexPosicaoInicial[1] = getIndexOfColunasChar(posicaoInicial[1]);
				posicaoPAok = validaDisponibilidadePosicaoNG(indexPosicaoInicial, eixo, t, true);
				if(posicaoPAok) {
					posicionaNavioGuerra(indexPosicaoInicial, eixo, t);
				}
			}
		}
	}

	private boolean posicionaNavioGuerraManualmente(int t, String posicao) {
		char[] p = new char[5];
		//ex.: a1 v    ou    j10 h
		p = posicao.toUpperCase().toCharArray();
		
		char[] posicaoInicial = new char[2];
		posicaoInicial[0] = p[0];
		if (posicao.length() == 4) {
			posicaoInicial[1] = p[1];
		}else{
			posicaoInicial[1] = p[2];
		}
		int[] indexPosicaoInicial = new int[2];
		indexPosicaoInicial[0] = getIndexOfLinhasChar(posicaoInicial[0]);
		indexPosicaoInicial[1] = getIndexOfColunasChar(posicaoInicial[1]);
		
		int eixo; // 0 = horizontal; 1 = vertical		
		if(p[posicao.length()-1] == 'h' || p[posicao.length()-1] == 'H'){
			eixo = 0; //horizontal
		}else{
			eixo = 1; //vertical
		}

		if(!validaPosicaoInicialNG(posicaoInicial, eixo, t)) {
			return false;
		}
		if(!validaDisponibilidadePosicaoNG(indexPosicaoInicial, eixo, t, false)){
			return false;
		}
		posicionaNavioGuerra(indexPosicaoInicial, eixo, t);
		return true;
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
	
	private boolean posicionaPortaAvioesManualmente(String posicao) {
		char[] p = new char[5];
		//ex.: a1 v d    ou    j10 h b
		p = posicao.toUpperCase().toCharArray();

		char[] posicaoInicial = new char[2];
		posicaoInicial[0] = p[0];
		if (posicao.length() == 6) {
			posicaoInicial[1] = p[1];
		}else{
			posicaoInicial[1] = p[2];
		}
		int[] indexPosicaoInicial = new int[2];
		indexPosicaoInicial[0] = getIndexOfLinhasChar(posicaoInicial[0]);
		indexPosicaoInicial[1] = getIndexOfColunasChar(posicaoInicial[1]);
		
		int eixo; // 0 = horizontal; 1 = vertical		
		if(p[posicao.length()-3] == 'h' || p[posicao.length()-3] == 'H'){
			eixo = 0; //horizontal
		}else{
			eixo = 1; //vertical
		}
		
		int direcao; // 0 = horizontal; 1 = vertical		
		if(p[posicao.length()-1] == 'd' || p[posicao.length()-1] == 'D'
			|| p[posicao.length()-1] == 'c' || p[posicao.length()-1] == 'C'){
			direcao = 0; //Direita ou Cima (direções equivalentes a 0 para eixo horizontal ou vertical )
		}else{
			direcao = 1; //Esquerd ou Baixo
		}

		if(!validaPosicaoInicialPA(posicaoInicial, eixo, direcao)) {
			return false;
		}
		if(!validaDisponibilidadePosicaoPA(indexPosicaoInicial, eixo, direcao)){
			return false;
		}
		posicionaPortaAvioes(indexPosicaoInicial, eixo, direcao);
		return true;
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
	
	public boolean validaDisponibilidadePosicaoNG(int[] p, int e, int t, boolean espalhado) {
		int l = p[0];
		int c = p[1];
		if(e == 0) {//horizontal => direçao direita
			if(c-1 >= 0 && espalhado) {
				if(!(this.campoDeBatalha[l][c-1].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			for (int i = 0; i < t; i++) {
				if(c>9) return false;
				if(l-1 >= 0 && espalhado) {
					if(!(this.campoDeBatalha[l-1][c].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(l+1 < linhas.length && espalhado) {
					if(!(this.campoDeBatalha[l+1][c].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(!(this.campoDeBatalha[l][c++].getTPeca() instanceof Agua)) {
					return false;
				}
				
			}
			if(c < colunas.length && espalhado) {
				if(!(this.campoDeBatalha[l][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			
		} else {//vertical => direçao baixo

			if(l-1 >= 0 && espalhado) {
				if(!(this.campoDeBatalha[l-1][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			for (int i = 0; i < t; i++) {
				if(c-1 >= 0 && espalhado) {
					if(!(this.campoDeBatalha[l][c-1].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(c+1 < colunas.length && espalhado) {
					if(!(this.campoDeBatalha[l][c+1].getTPeca() instanceof Agua)) {
						return false;
					}
				}
				if(!(this.campoDeBatalha[l++][c].getTPeca() instanceof Agua)) {
					return false;
				}
			}
			if(l < linhas.length && espalhado) {
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
