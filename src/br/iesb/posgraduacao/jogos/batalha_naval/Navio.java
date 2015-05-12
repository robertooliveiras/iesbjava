/*
 * Navio
 * 
 * version 1.0
 * 
 * Copyrights IESB
 */
package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

/**
 * @version 1.0.0
 * @since 2015-04-30
 * @author RobertoOliveira matrícula 1531030023
 *
 */    
public class Navio {
    
    /**
     * Tipo de Navio:
     * G = Navio de Guerra
     * P = Porta Aviões
     */
    public String[] linhas = {"A","B","C","D","E","F","G","H","I","J"};
    public String[] colunas = {"1","2","3","4","5","6","7","8","9","0"};
    public Character[] linhasChar = {'A','B','C','D','E','F','G','H','I','J'};
    public Character[] colunasChar = {'1','2','3','4','5','6','7','8','9','0'};
    private char tipoNavio;
    private ArrayList<Character> tiposValidos = new ArrayList<Character>();
    
    Navio() {
        tiposValidos.add('G');
        tiposValidos.add('P');
    }

    public char getTipo() {
        return tipoNavio;
    }

    public void setTipo(char tipo) {
            this.tipoNavio = tipo;
    }
    
}
