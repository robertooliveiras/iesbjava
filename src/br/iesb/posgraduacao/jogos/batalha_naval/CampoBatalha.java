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
		
		String a = "C7";
		int L = cb.getIndexOfLinhasChar(a.charAt(0));
		int C = cb.getIndexOfColunasChar(a.charAt(1));
		System.out.println(L);
		System.out.println(C);
		cb.campo[L][C].getTPeca().setAtingido(true);
		System.out.println(cb.campo[L][C].getTPeca().getForma());
		String[] cell = cb.getRandomicCell();
		System.out.print(cell[0] + " " + cell[1]);
	}
	/**
	 * 
	 */
	public CampoBatalha() {
		initCampo();
		
	}
	
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
					this.naviosGuerra.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra(this.naviosGuerra.get(i).linhas[j].charAt(0), '1'));
				}else{ //orientacao = H
					if(this.naviosGuerra.get(i).colunas[j] == "10"){
						col = '0';
					}else{
						col = this.naviosGuerra.get(i).colunas[j].charAt(0);
					}
					this.naviosGuerra.get(i).addPedacoNavioGuerra(new PedacoNavioGuerra('A', col));
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
	
	public int getPositiveRandomNumber(int s, Random rnd){
		List<Integer> aceitos = new ArrayList<Integer>();
		for (int z = 0; z < s; z++) {
			aceitos.add(z);
		}
		int n = rnd.nextInt(s);
		while(n < 0){
			n = rnd.nextInt(s);
		}
		return aceitos.get(n);
	}
	
}
