package br.iesb.posgraduacao.jogos.wumpus;

import java.util.LinkedList;
import java.util.List;

public class Tabuleiro {
    
    private List<Espaco> tabuleiro = new LinkedList<Espaco>();
    private int qtColumns;
    private int tSize;
    private int tMaxId;

    public Tabuleiro(int qtLines) {
        
        this.qtColumns = qtLines;
        this.tSize = qtLines * qtLines;
        this.tMaxId = this.tSize - 1;
        
        for (int i = 0; i < this.tSize; i++) {
            this.tabuleiro.add(new Espaco());
            
            //o personagem sempre começa na primeira coluna da ultima linha
            if (i == qtColumns * (qtColumns-1)) {
                this.tabuleiro.get(i).setTipo("P");
                this.tabuleiro.get(i).setFedorento(false);
                this.tabuleiro.get(i).setBrisa(false);
                this.tabuleiro.get(i).setVisible(true);
            }
        }
        
        int quebra = 1;
        
        for (int t = 0 ; t < this.tabuleiro.size(); t++) {
            this.tabuleiro.get(t).setVisible(true);
            System.out.print(this.tabuleiro.get(t).getImg());
            if (t + 1 == qtColumns * quebra) {
                System.out.println("");
                quebra++;
            } else {
                System.out.print(" ");
            }
        }
    }
    
    /*
     * @return int id da posicao de destino
     * retorna -1 caso o movimento não seja válido 
     */
    public int getIdDestino(int origem, char d){
        int destino = -1;
        
        switch (d) {
            case 's': //subir
                if (origem - this.qtColumns >= 0) {
                    destino = origem - this.qtColumns; 
                }
                break;
            case 'd': //descer
                if (origem + this.qtColumns < this.tSize) {
                    destino = origem + this.qtColumns;
                }
                break;
            case 'f': //frente
                if (origem + 1 < this.tSize) {
                    destino = origem + 1;
                }
                break;
            case 't': //tras
                if (origem - 1 >= 0) {
                    destino = origem - 1;
                }
                break;
        }
        return destino;
    }

}
