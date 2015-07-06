package br.iesb.posgraduacao.jogos.wumpus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    
    public Character[] direcoes = {'f','t','s','d'};
    public Random rnd = new Random(System.currentTimeMillis());
    private int qtColumns;
    private int tSize;
    private int inicialPosition;
    private int qtWumpus = 1;
    private int qtHoles = 3;
    private boolean gameOver = false;
    private boolean youWin = false;
    private List<Espaco> tabuleiro = new LinkedList<Espaco>();
    private Scanner entrada = new Scanner(System.in);

    public Tabuleiro(int qtLines) {
        this.qtColumns = qtLines;
        this.tSize = qtLines * qtLines;
        this.inicialPosition = this.tSize - qtLines;
        populateTabuleiro(this.tSize);
        setPersonPosition(this.inicialPosition);
        setGoldPath();
        placeObject("W",qtWumpus);
        placeObject("B",qtHoles);
        printTabuleiro();
    }
    
    public void jogar(){
        int pAtual = inicialPosition;
        int pAnterior = inicialPosition;
        int pontuacao = 0;
        int qtMovimentos = 0;
        do{
            System.out.println("Faça o movimento: ");
            char input = this.entrada.nextLine().charAt(0);
            if( isValidMove(input)){
                qtMovimentos++;
                pAnterior = pAtual;
                pAtual = getIdDestino(pAtual, input);
                pontuacao = pontuacao - 20;
                this.tabuleiro.get(pAtual).setPercorrido(true);
                this.tabuleiro.get(pAnterior).setPercorrido(true);
                if(this.tabuleiro.get(pAtual).getTipo() == "O"){
                    this.youWin = true;
                } else if(this.tabuleiro.get(pAtual).getTipo() != "E"){
                    this.gameOver = true;
                }else{
                    this.tabuleiro.get(pAtual).setTipo("P");
                    this.tabuleiro.get(pAnterior).setTipo("E");
                    System.out.println("proximo movimento:");
                }
                this.tabuleiro.get(pAtual).setVisible(true);
                this.tabuleiro.get(pAnterior).setVisible(true);
                System.out.println(pontuacao);
            } else{
                System.out.println("Digite um valor válido: ");
                continue;
            }
            printTabuleiro();
        }while(!gameOver && !youWin);
        
        if(youWin){
            System.out.println("PARABÉNS!!! Achou o Ouro e ganhou 1000 pontos!!!"
                    + "\nVocê fez "+qtMovimentos+" movimentos e perdeu"
                    + " "+pontuacao+" pontos."
                    + "\nTOTAL: ");
            System.out.print(pontuacao += 1000);
            
        }else{
            System.out.println("caiu na Trap... encontrou um ");
            if(this.tabuleiro.get(pAtual).getTipo().equalsIgnoreCase("B")){
                System.out.print("Buraco");
            }else{
                System.out.print("Wumpus");
            }
            System.out.println("Você fez "+qtMovimentos+" movimentos e perdeu"
                    + " "+pontuacao+"."
                    + "\nTOTAL: ");
            System.out.print(pontuacao);
        }
        setTabuleiroVisible();
        printTabuleiro();
    }
    
    public void setTabuleiroVisible(){
        for (int i = 0; i < tabuleiro.size(); i++) {
            tabuleiro.get(i).setVisible(true);
        }
    }
    
    public boolean isValidMove(char d){
        // TODO Validar o destino também. aqui está validando apenas o comando digitado
        for (int i = 0; i < direcoes.length; i++) {
            if(d == direcoes[i]){
                return true;
            }
        }
        return false;
    }
    
    public void placeObject(String type, int qt){
        int id;
        for (int i = 0; i < qt; i++) {
            do{
                id = getPositiveRandomNumber(this.tSize, this.rnd);
            }while(!isValidToPlaceObject(id));
            this.tabuleiro.get(id).setTipo(type);
            for (int j = 0; j < direcoes.length; j++) {
                if(isValidSensorPosition(id, direcoes[j])){
                    if(type == "B") {
                        this.tabuleiro.get(getIdDestino(id, direcoes[j])).setBrisa(true);
                    }else if(type == "W") {
                        this.tabuleiro.get(getIdDestino(id, direcoes[j])).setFedorento(true);
                    }
                }    
            }
        }
    }
    
    public boolean isValidToPlaceObject(int id){
        if(this.tabuleiro.get(id).isCaminho() || 
                !this.tabuleiro.get(id).getTipo().equalsIgnoreCase("E") ||
                this.tabuleiro.get(id).isBrisa() ||
                this.tabuleiro.get(id).isFedorento()
                ){
            return false;
        } else {
            return true;
        }
    }
    
    public boolean isValidSensorPosition(int o, char d){
        if(getIdDestino(o, d) >= 0 && getIdDestino(o, d) < this.tSize && 
                (!isInLastColumn(o) || d != 'f') && 
                (!isInFirstColumn(o) || d != 't')){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean isInLastColumn(int id){
        if(id%this.qtColumns == 3){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isInFirstColumn(int id){
        if(id == 0 || id%this.qtColumns == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void setGoldPath(){
        int steps = getRandomicAmountOfSteps(6, 1);
        char cDirection = 'v';
        int iDirection;
        int pos = this.inicialPosition;
        this.tabuleiro.get(pos).setCaminho(true);
        this.tabuleiro.get(getIdDestino(pos, 's')).setCaminho(true);
        this.tabuleiro.get(getIdDestino(pos, 'f')).setCaminho(true);
        for (int i = steps; i >= 1; i--) {
            if(pos > this.qtColumns && isInLastColumn(pos)){
                cDirection = 's';
            }else if(pos < this.qtColumns - 2){
                cDirection = 'f';
            }else{
                iDirection = getPositiveRandomNumber(2, this.rnd);
                if(iDirection == 0){
                    cDirection = 'f';
                }else if(iDirection == 1){
                    cDirection = 's';
                }
            }
            pos = getIdDestino(pos, cDirection);
            
            this.tabuleiro.get(pos).setCaminho(true);
        }
        this.tabuleiro.get(pos).setTipo("O");
    }
    
    public int getRandomicAmountOfSteps(int maxSteps, int minSteps){
        int s;
        do{
            s = getPositiveRandomNumber(maxSteps, this.rnd);
        } while(s < minSteps);
        return s+1;
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
    
    public void populateTabuleiro (int size) {
        for (int i = 0; i < size; i++) {
            this.tabuleiro.add(new Espaco());
        }
    }
    
    public void printTabuleiro(){
        System.out.println("\n");
        if(!this.tabuleiro.isEmpty()){
            int quebra = 1;
            for (int t = 0 ; t < this.tabuleiro.size(); t++) {
                System.out.print(this.tabuleiro.get(t).getImg());
                if (t + 1 == qtColumns * quebra) {
                    System.out.println("");
                    quebra++;
                } else {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.println("Tabuleiro vazio.");
        }
    }
    
    public void setPersonPosition (int id) {
        if(!this.tabuleiro.isEmpty() & id >=0 & id <= this.tabuleiro.size()){
            this.tabuleiro.get(id).setTipo("P");
            this.tabuleiro.get(id).setVisible(true);
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
    
    @Deprecated
    public void placeHoles(){
        int h;
        for (int i = 0; i < qtHoles; i++) {
            do{
                h = getPositiveRandomNumber(this.tSize, this.rnd);
            }while(!isValidToPlaceObject(h));
            this.tabuleiro.get(h).setTipo("B");
            for (int j = 0; j < direcoes.length; j++) {
                if(isValidSensorPosition(h, direcoes[j])){
                    this.tabuleiro.get(getIdDestino(h, direcoes[j])).setBrisa(true);
                }    
            }
        }
        
    }
    
    @Deprecated
    public void placeWumpus(){
        int w;
        for (int i = 0; i < qtWumpus; i++) {
            do{
                w = getPositiveRandomNumber(this.tSize, this.rnd);
            }while(!isValidToPlaceObject(w));
            this.tabuleiro.get(w).setTipo("W");
            for (int j = 0; j < direcoes.length; j++) {
                if(isValidSensorPosition(w, direcoes[j])){
                    this.tabuleiro.get(getIdDestino(w, direcoes[j])).setFedorento(true);
                }    
            }
        }
        
    }
    

}
