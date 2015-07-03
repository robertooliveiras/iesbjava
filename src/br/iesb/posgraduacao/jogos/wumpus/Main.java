package br.iesb.posgraduacao.jogos.wumpus;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView;

public class Main {
    
    public List<Espaco> tabuleiro = new ArrayList<Espaco>();
    public int qtColumns = 4;
    
    public Main(){
	for (int i = 0; i < qtColumns*qtColumns; i++) {
	    tabuleiro.add(new Espaco());
	    
	    //o personagem sempre começa na primeira coluna da ultima linha
	    if((i+1) == qtColumns){
		tabuleiro.get(i).setTipo("P");
		tabuleiro.get(i).setFedorento(false);
		tabuleiro.get(i).setBrisa(false);
		tabuleiro.get(i).setVisible(true);
	    }
	}
	
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//	foreach (tabuleiro tabuleiro : peca) {
//	    System.out.println();
//	}

    }

}
