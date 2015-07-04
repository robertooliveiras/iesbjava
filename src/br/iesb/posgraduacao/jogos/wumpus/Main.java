package br.iesb.posgraduacao.jogos.wumpus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static List<Espaco> tabuleiro = new LinkedList<Espaco>();
    public static int qtColumns = 4;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < qtColumns*qtColumns; i++) {
            tabuleiro.add(new Espaco());
            
            //o personagem sempre começa na primeira coluna da ultima linha
            if (i == 12) {
                tabuleiro.get(i).setTipo("P");
                tabuleiro.get(i).setFedorento(false);
                tabuleiro.get(i).setBrisa(false);
                tabuleiro.get(i).setVisible(true);
            }
        }
        
        for (int t = 0 ; t < tabuleiro.size(); t++) {
            tabuleiro.get(t).setVisible(true);
            System.out.print(tabuleiro.get(t).getImg());
            if (t == 3 || t == 7 || t == 11) {
                System.out.println("");
            } else {
                System.out.print(" ");
            }
        }

    }

}
