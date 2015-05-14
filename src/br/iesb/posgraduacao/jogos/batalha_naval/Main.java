/*
 * Main
 * 
 * version 1.0
 * 
 * Copyrights IESB
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author RobertoOliveira matrícula 1531030023
 * @since 2015/05/04
 * Essa classe é a principal do pacote batalha_naval.
 * ela que será rodada para que o jogo aconteça
 *
 */
public class Main {
    public List<String> ataquesValidos = new ArrayList<String>();
    private Scanner entrada = new Scanner(System.in);
    
    public Main() {
        initValidadoresDeEntrada();
    }

    public static void main(String[] args) {
        Main m = new Main();
        int qtJogadas = 3;
        System.out.println("BEM VINDOS AO JOGO BATALHA NAVAL!"
        		+ "\n\nVejam as instruções:"
        		+ "\n\n1. Trata-se de um jogo para 2 jogadores; "
        		+ "\n2. Para atacar, informe linha+coluna. "
        		+ "ex.: F5;"
        		+ "\n2. Cada jogador fará "+qtJogadas+" jogada por round. "
        		+ "Caso seja informada uma posição já atingida, o "
        		+ "jogador perderá a jogada;"
        		+ "\n3. As frotas de ambos os jogadores serão "
        		+ "posicionadas aleatoriamente pelo computador. A "
        		+ "frota é composta das seguintes quantidades e tipos"
        		+ " de navios: "
        		+ "\n\t N = Navio de Guerra (sempre na vertical ou"
        		+ " horizontal):"
        		+ "\n\t\t 4 Navios de Guerra de 1 (um) canhão = N1;"
        		+ "\n\t\t 3 Navios de Guerra de 2 (dois) canhões = N2"
        		+ "\n\t\t 2 Navios de Guerra de 3 (tres) canhões = N3"
        		+ "\n\t\t 1 Navio de Guerra de 4 (quatro) canhões = N4"
        		+ "\n\t P = Porta Aviões (em forma de T que pode estar "
        		+ "invertido ou não, pode estar tombado pra esquerda "
        		+ "ou para a direita):"
        		+ "\n\t\t 1 Porta Aviões de 5 (cinco) canhões = P1"
        		+ "\n4. A cada jogada o sistema mostrará o resultado."
        		+ "\n5. Vencerá aquele que destruir toda a frota do"
        		+ " adversário.\n\n"
        		+ "QUE O JOGO COMEÇE!!"
        		+ "\n\n");
        
        CampoBatalha cb1 = new CampoBatalha(true);
        CampoBatalha cb2 = new CampoBatalha(true);
        
        // Imprimindo o tabuleiro com os campos de batalha
        m.imprimeTabuleiro(cb1, cb2);
        
        //iniciando o jogo
        m.jogar(cb1, cb2, qtJogadas);
        System.exit(0);

    }

    public void jogar(CampoBatalha cb1, CampoBatalha cb2, 
    		int qtJogadasPorRound) {
        do {
            jogada(1, cb1, cb2, qtJogadasPorRound);
            jogada(2, cb2, cb1, qtJogadasPorRound);
        } while(!this.verificaFrotaDestruida(cb1.getCampoDeBatalha()) 
        	&& !this.verificaFrotaDestruida(cb2.getCampoDeBatalha()));
    }
    
    public void jogada(int jogador, CampoBatalha origem, 
    		CampoBatalha alvo, int qtJogadasPorRound) {
        String[] input = new String[qtJogadasPorRound];
        int L;
        int C;

        //      Ataque do jogador
        //--------------------------
        System.out.println("\n");
        
        //começar looping
        for (int i = 0; i < input.length; i++) {
            System.out.println("Jogador "+jogador+", informe seu "
            					+ (i+1)+"º ataque:");
	        input[i] = this.entrada.nextLine();
	        while(this.ataquesValidos.indexOf(input[i]) < 0) {
	            System.out.println("Atenção! Opção inválida.\n"
	                                + "Jogador "+jogador+", informe seu "
	                                + (i+1)+"º ataque:");
	            input[i] = this.entrada.nextLine();
	        }
        }
        
        for (int i = 0; i < input.length; i++) {
	        L = alvo.getIndexOfLinhasChar(input[i].toUpperCase().toCharArray()[0]);
	        if (input[i].toCharArray().length == 2) {
	            C = alvo.getIndexOfColunasChar(input[i].toUpperCase()
	            		.toCharArray()[1]);
	        } else {
	            C = alvo.getIndexOfColunasChar(input[i].toUpperCase()
	            		.toCharArray()[2]);
	        }
	        System.out.println((i+1) + "º ataque: " + input[i].toUpperCase());
	        if(alvo.getCampoDeBatalha()[L][C].getTPeca().isAtingido()) {
	            System.out.println((i+1)+"ª Jogada ruim!! O Jogador "
	            				+jogador+" acertou "
	            				+ "num destroço. perdeu a chance nessa jogada");
	        } else {
	            alvo.getCampoDeBatalha()[L][C].getTPeca().setAtingido(true);
	            if (alvo.getCampoDeBatalha()[L][C].getTPeca() instanceof Agua) {
	                System.out.println((i+1)+"ª Jogada deu ÁGUA!!! o Jogador "
	                					+jogador+" errou!");
	            } else {
	                System.out.println((i+1)+"ª Jogada deu TIRO!!! o Jogador "
	                					+jogador+" acertou um "
	                					+ "objeto da Frota do adversário!");
	                if(this.verificaFrotaDestruida(alvo.getCampoDeBatalha())) {
	                	if (jogador == 1) {
	                        this.imprimeTabuleiro(origem, alvo);
	                    } else {
	                        this.imprimeTabuleiro(alvo, origem);
	                    }
	                    System.out.println("\n\nO JOGADOR "+jogador+" "
	                    		+ "DESTRUIU TODA A FROTA DO ADVERSÁRIO!");
	                    System.out.println("*****************************");
	                    System.out.println("VITÓRIA DO JOGADOR "+jogador+""
	                    		+ "!!!!");
	                    System.out.println("*****************************\n\n");
	                    System.exit(0);
	                }
	            }
	        }
        }
        if (jogador == 1) {
            this.imprimeTabuleiro(origem, alvo);
        } else {
            this.imprimeTabuleiro(alvo, origem);
        }
    }
    
    private void initValidadoresDeEntrada() {
        
        for (char i = 'a', j='A'; i <= 'j'; i++, j++) {
            for (Integer c = 1; c <= 10; c++) {
                ataquesValidos.add(""+i+""+c.toString());
                ataquesValidos.add(j +""+c.toString());
            }
        }
    }
    
    public void imprimeTabuleiro(CampoBatalha c1, CampoBatalha c2) {
        System.out.println();
        System.out.println("                      JOGADOR 1"
        		+ "                             "
                + "                        JOGADOR 2");
        
        for (int i = 0; i < c1.getCampoDeBatalha().length; i++) {
            System.out.print(c1.linhas[i] + " ");
            for (int j = 0; j < c1.getCampoDeBatalha()[i].length; j++) {
                System.out.print(c1.getCampoDeBatalha()[i][j].getTPeca()
                		.getForma());
            }
            System.out.print("          ");
            System.out.print(c2.linhas[i] + " ");
            for (int j = 0; j < c2.getCampoDeBatalha()[i].length; j++) {
                System.out.print(c2.getCampoDeBatalha()[i][j].getTPeca()
                		.getForma());
            }
            System.out.println();
        }
        for (int i = 0; i < c1.getCampoDeBatalha().length; i++) {
            System.out.print("    " + c1.colunas[i] );
        }
        System.out.print("          ");
        for (int i = 0; i < c2.getCampoDeBatalha().length; i++) {
            System.out.print("    " + c2.colunas[i] );
        }
        System.out.println();
    }
    
    @SuppressWarnings("rawtypes")
	public boolean verificaFrotaDestruida(Peca[][] p) {
        boolean destruido = true;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                if(!(p[i][j].getTPeca() instanceof Agua)) {
                    if(!p[i][j].getTPeca().isAtingido()) {
                        destruido = false;
                        break;
                    }
                }
            }
            if(!destruido) {
                break;
            }
        }
        return destruido;
    }

}
