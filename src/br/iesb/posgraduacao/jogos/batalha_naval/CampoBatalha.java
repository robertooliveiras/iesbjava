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
 * Essa classe monta o campo de batalha do jogo batalha naval
 * Por padrão todas as peças do campo são do tipo Agua e podrão
 * ser configurados para o tipo Navio de Guerra de 1 a 4 canos
 * ou para o tipo Porta Aviões em pormato de T.
 *
 */
public class CampoBatalha{
	public String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
	public String[] colunas = {"1","2","3","4","5","6","7","8","9","10"};
	public Character[] linhasChar = {'A','B','C','D','E','F','G','H','I','J'};
	public Character[] colunasChar = {'1','2','3','4','5','6','7','8','9','0'};
	protected Peca[][] campo;
	protected ArrayList<NavioGuerra> naviosGuerra = new ArrayList<NavioGuerra>();
	protected ArrayList<PortaAvioes> portaAvioes = new ArrayList<PortaAvioes>();
	public Random rnd = new Random(System.currentTimeMillis());
	
	/**
	 * Construtor da classe que chama o meto initCampo para criar a grelha vazia
	 */
	public CampoBatalha() {
		initCampo();
		posicionaPortaAvioesAleatoriamente();
	}
	
	/**
	 * Utilizada no construtor para preencher a grelha (representada pelo atributo campo)
	 * com peças do tipo Agua (usando generics). Após a criação da grelha, as peças serão distribuídas
	 * no tabuleiro conforme regra do requisito do exercício.
	 */
	private void initCampo(){
		Agua a;
		char[] posicao = new char[2];
		campo = new Peca[linhas.length][colunas.length];
		for (int i = 0; i < linhas.length; i++) {
			for (int j = 0; j < colunas.length; j++) {
				posicao[0] = linhasChar[i];
				posicao[1] = colunasChar[j];
				a = new Agua();
				a.setPosicao(posicao);

				Peca pt = new Peca();
				pt.setTPeca(a);
				pt.getTPeca().setPosicao(posicao);
				campo[i][j] = pt;
			}
		}
	}
	
	/**
	 * A distribuição aleatória contará com
	 * 4 navios de guerra com 1 cano 
	 * 3 navios de guerra com 2 canos (verticais ou horizontais)
	 * 2 navios de guerra com 3 canos (verticais ou horizontais)
	 * 1 navio de guerra com 4 canos (verticais ou horizontais)
	 * 1 porta aviões com 5 canos (em T) (base horizontal virado para direita ou esquerda; ou vertical e virado para cima ou para baixo)
	 */
	public void posicionaPortaAvioesAleatoriamente(){
		
		//posiciona o porta aviões
		char[] posicaoInicial = new char[2];
		int eixo; // 0 = horizontal; 1 = vertical
		int direcao; // 0 = direita(v) ou cima(h); 1 = esquerda(v) ou baixo(h)
		boolean posicaoPAok;
		do{
			posicaoPAok = true;
			posicaoInicial = getRandomicCellChar();
			eixo = getPositiveRandomNumber(2, this.rnd); // 0 = horizontal; 1 = vertical
			direcao = getPositiveRandomNumber(2, this.rnd); // 0 = direita(v) ou cima(h); 1 = esquerda(v) ou baixo(h)
			posicaoPAok = validaPosicaoInicialPA(posicaoInicial, eixo, direcao);
			if(posicaoPAok){
				posicaoPAok = validaDisponibilidadePosicaoPA(posicaoInicial, eixo, direcao);
			}
		}while(!posicaoPAok);
		
//		PedacoPortaAvioes mppa;
//		mppa = new PedacoPortaAvioes();
//		mppa.setPosicao(posicaoInicial);
//		mppa.setVisivel(true);
//		Peca<PedacoPortaAvioes> ppa = new Peca<PedacoPortaAvioes>();
//		ppa.setTPeca(mppa);
//		this.campo[getIndexOfLinhasChar(posicaoInicial[0])][getIndexOfColunasChar(posicaoInicial[1])] = ppa;
//		if(e == 0){//horizontal => direçao será baixo(0)=T ou cima(1)=T invertido
//			if(d == 0){
//				if(!(this.campo[p[0]+1][p[1]].getTPeca() instanceof Agua)
//					|| !(this.campo[p[0]+2][p[1]].getTPeca() instanceof Agua)
//					|| !(this.campo[p[0]][p[1]-1].getTPeca() instanceof Agua)
//					|| !(this.campo[p[0]][p[1]+1].getTPeca() instanceof Agua)){
//				}
//			}else{
//				if(!(this.campo[p[0]-1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]-2][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]-1].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]+1].getTPeca() instanceof Agua)){
//					}
//			}
//		}else{//vertical => direçao será direita(0)H sem aste direita ou esquerda(1) H sem aste esquerda
//			if(d == 0){
//				if(!(this.campo[p[0]-1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]+1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]+1].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]+2].getTPeca() instanceof Agua)){
//					}
//			}else{
//				if(!(this.campo[p[0]-1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]+1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]-1].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]-2].getTPeca() instanceof Agua)){
//					}
//			}
//		}
	}
	public boolean validaDisponibilidadePosicaoPA(char[] p, int e, int d){
		if(!(this.campo[getIndexOfLinhasChar(p[0])][getIndexOfColunasChar(p[1])].getTPeca() instanceof Agua)){
			return false;
		}
//		if(e == 0){//horizontal => direçao será baixo(0)=T ou cima(1)=T invertido
//			if(d == 0){
		//this.campo[getIndexOfLinhasChar(p[0]+1)][getIndexOfColunasChar(p[1])].getTPeca()
		//this.campo[getIndexOfLinhasChar(p[0]+2)][getIndexOfColunasChar(p[1])].getTPeca()
		//this.campo[getIndexOfLinhasChar(p[0])][getIndexOfColunasChar(p[1]-1)].getTPeca()
		//this.campo[getIndexOfLinhasChar(p[0])][getIndexOfColunasChar(p[1]+1)].getTPeca()
//				if(!(this.campo[p[0]+1][p[1]].getTPeca() instanceof Agua)
//					|| !(this.campo[p[0]+2][p[1]].getTPeca() instanceof Agua)
//					|| !(this.campo[p[0]][p[1]-1].getTPeca() instanceof Agua)
//					|| !(this.campo[p[0]][p[1]+1].getTPeca() instanceof Agua)){
//					return false;
//				}
//			}else{
//				if(!(this.campo[p[0]-1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]-2][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]-1].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]+1].getTPeca() instanceof Agua)){
//						return false;
//					}
//			}
//		}else{//vertical => direçao será direita(0)H sem aste direita ou esquerda(1) H sem aste esquerda
//			if(d == 0){
//				if(!(this.campo[p[0]-1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]+1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]+1].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]+2].getTPeca() instanceof Agua)){
//						return false;
//					}
//			}else{
//				if(!(this.campo[p[0]-1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]+1][p[1]].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]-1].getTPeca() instanceof Agua)
//						|| !(this.campo[p[0]][p[1]-2].getTPeca() instanceof Agua)){
//						return false;
//					}
//			}
//		}
		return true;
	}
	
	public boolean validaPosicaoInicialPA(char[] p, int e, int d){
		if(e == 0){ //horizontal => direçao será baixo(0)=T ou cima(1)=T invertido
			if(getIndexOfColunasChar(p[1]) == 0 || getIndexOfColunasChar(p[1]) == colunas.length - 1){//coluna 0 ou última coluna
				return false;
			}
			if(d == 0){// baixo (parece um T invertido). não pode linha A(0) nem B(1)
				if(getIndexOfLinhasChar(p[0]) - 2 < 0){//passou do limite da linha
					return false;
				}
			 }else{ // cima (parece um T). não pode linha I(9) nem J(10)
				if(getIndexOfLinhasChar(p[0]) + 2 > linhas.length - 1){//passou do limite da linha
					return false;
				}
			}
		}else{//vertical => direçao será direita(0) ou esquerda(1)
			if(getIndexOfLinhasChar(p[0]) == 0 || getIndexOfLinhasChar(p[0]) == linhas.length - 1){//linha 0 ou última linha
				return false;
			}
			if(d == 0){ // direita (parece um H sem aste da direita). não pode coluna 9 nem 10
				if(getIndexOfColunasChar(p[1]) + 2 > colunas.length - 1){//passou do limite da coluna
					return false;
				}
			}else{ // baixo (parece um H sem aste da esquerda). não pode coluna 1 nem 2
				if(getIndexOfColunasChar(p[1]) - 2 < 0){//passou do limite da coluna
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		
		CampoBatalha cb = new CampoBatalha();
		
		for (int i = 0; i < cb.campo.length; i++) {
			System.out.print(cb.linhas[i] + " ");
			for (int j = 0; j < cb.campo[i].length; j++) {
				System.out.print(cb.campo[i][j].getTPeca().getForma());
			}
			System.out.println();
		}
		for (int i = 0; i < cb.campo.length; i++) {
			System.out.print("   " + cb.colunas[i] );
		}
		System.out.println("\n");
		System.out.println("\n");
		System.out.println(!(cb.campo[0][0].getTPeca() instanceof Agua));
		
//		String a = "C7";
//		int L = cb.getIndexOfLinhasChar(a.charAt(0));
//		int C = cb.getIndexOfColunasChar(a.charAt(1));
//		System.out.println(L);
//		System.out.println(C);
//		cb.campo[L][C].getTPeca().setAtingido(true);
//		System.out.println(cb.campo[L][C].getTPeca().getForma());

		char[] cell;
		
		cell = cb.getRandomicCellChar();
		System.out.println(cell[0] + " " + cell[1]);
		System.out.println(cb.getIndexOfLinhasChar(cell[0]) + " " + cb.getIndexOfColunasChar(cell[1]));
		cb.campo[cb.getIndexOfLinhasChar(cell[0])][cb.getIndexOfColunasChar(cell[1])].getTPeca().setAtingido(true);
//		Agua ag = new Agua();
//		ag.setPosicao(cell);
//		ag.setAtingido(true);
////		ag.setVisivel(false);
//		Peca<Agua> pa = new Peca<Agua>();
//		pa.setTPeca(ag);
//		cb.campo[cb.getIndexOfLinhasChar(cell[0])][cb.getIndexOfColunasChar(cell[1])] = pa;
		
		
		cell = cb.getRandomicCellChar();
//		System.out.println(cell[0] + " " + cell[1]);
//		System.out.println(cb.getIndexOfLinhasChar(cell[0]) + " " + cb.getIndexOfColunasChar(cell[1]));
		PedacoNavioGuerra mpng = new PedacoNavioGuerra();
		mpng.setPosicao(cell);
//		mpng.setVisivel(true);
		mpng.setPosicao(cell);
//		mpng.setAtingido(true);
		Peca<PedacoNavioGuerra> png = new Peca<PedacoNavioGuerra>();
		png.setTPeca(mpng);
		cb.campo[cb.getIndexOfLinhasChar(cell[0])][cb.getIndexOfColunasChar(cell[1])] = png;
		
		cell = cb.getRandomicCellChar();
		System.out.println(cell[0] + " " + cell[1]);
		System.out.println(cb.getIndexOfLinhasChar(cell[0]) + " " + cb.getIndexOfColunasChar(cell[1]));
		PedacoPortaAvioes mppa = new PedacoPortaAvioes();
		mppa.setPosicao(cell);
//		mppa.setVisivel(true);
		mppa.setPosicao(cell);
		Peca<PedacoPortaAvioes> ppa = new Peca<PedacoPortaAvioes>();
		ppa.setTPeca(mppa);
		cb.campo[cb.getIndexOfLinhasChar(cell[0])][cb.getIndexOfColunasChar(cell[1])] = ppa;
		

		for (int i = 0; i < cb.campo.length; i++) {
			System.out.print(cb.linhas[i] + " ");
			for (int j = 0; j < cb.campo[i].length; j++) {
				System.out.print(cb.campo[i][j].getTPeca().getForma());
			}
			System.out.println();
		}
		for (int i = 0; i < cb.campo.length; i++) {
			System.out.print("   " + cb.colunas[i] );
		}
		System.out.println("\n");
		System.out.println("\n");
		
		System.exit(0);
	}
	
	public int getIndexOfLinhas(String c){
		int index = -1;
		for (int i = 0; i < this.linhas.length; i++) {
			if(this.linhas[i] == c){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int getIndexOfColunas(String c){
		int index = -1;
		for (int i = 0; i < this.colunas.length; i++) {
			if(this.colunas[i] == c){
				index = i;
				break;
			}
		}
		return index;
	}	
	
	public int getIndexOfLinhasChar(char c){
		int index = -1;
		for (int i = 0; i < this.linhasChar.length; i++) {
			if(this.linhasChar[i] == c){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int getIndexOfColunasChar(char c){
		int index = -1;
		for (int i = 0; i < this.colunasChar.length; i++) {
			if(this.colunasChar[i] == c){
				index = i;
				break;
			}
		}
		return index;
	}	

	public void criarNaviosGuerra(int qtNavios, int qtCanos, char orientacao){
		char col = '0';
		char[] posicaoInicio = {'A','1'};
		for (Integer i = 0; i < qtNavios; i++) {
			this.naviosGuerra.add(new NavioGuerra());
		}
		for (int i = 0; i < this.naviosGuerra.size(); i++) {
			this.naviosGuerra.get(i).setOrientacao(orientacao);
			this.naviosGuerra.get(i).setQtCanos(qtCanos);
			this.naviosGuerra.get(i).setTipo('G');
			this.naviosGuerra.get(i).setPosicaoInicio(posicaoInicio);
			for (int j = 0; j < qtCanos; j++) {
				if(orientacao == 'V'){
					this.naviosGuerra.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra());
					//this.naviosGuerra.get(i).linhas[j].charAt(0), '1'
				}else{ //orientacao = H
					if(this.naviosGuerra.get(i).colunas[j] == "10"){
						col = '0';
					}else{
						col = this.naviosGuerra.get(i).colunas[j].charAt(0);
					}
					this.naviosGuerra.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra());
					//'A', col
				}	
			}
		}
	}
	
	public String[] getRandomicCell(){
		int Lr = this.getPositiveRandomNumber(10,this.rnd);
		int Cr = this.getPositiveRandomNumber(10,this.rnd);
		String[] p = new String[2];
		p[0] = this.linhas[Lr];
		p[1] = this.colunas[Cr];
		return p;
	}
	
	public char[] getRandomicCellChar(){
		int Lr = this.getPositiveRandomNumber(10,this.rnd);
		int Cr = this.getPositiveRandomNumber(10,this.rnd);
		char[] p = new char[2];
		p[0] = this.linhasChar[Lr];
		p[1] = this.colunasChar[Cr];
		return p;
	}
	
	public int getPositiveRandomNumber(int s, Random rnd){
		int n = rnd.nextInt(s);
		List<Integer> aceitos = new ArrayList<Integer>();
		for (int z = 0; z < s; z++) {
			aceitos.add(z);
		}
		while(n < 0){
			n = rnd.nextInt(s);
		}
		return aceitos.get(n);
	}
	
}
