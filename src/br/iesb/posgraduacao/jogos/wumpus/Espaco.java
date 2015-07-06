package br.iesb.posgraduacao.jogos.wumpus;

public class Espaco {
    private boolean caminho = false;
    private boolean percorrido = false;
    private boolean fedorento = false;
    private boolean brisa = false;
    private String tipo = "E";
    private String img = "-----";
    private boolean visible = false;

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        String c = "-";
        if(isPercorrido()) c = "¬";
        if (visible == true) {
            switch (tipo) {
                case "O":
                    img = "ouro"+c;
                break;
                case "B":
                    img = c+c +"B"+c+c;
                break;
                case "P":
                    if(isFedorento() && isBrisa()){
                        img = c+"*P≈"+c;
                    } else if (isFedorento()) {
                        img = c+"*P"+c+c;
                    } else if(isBrisa()){
                        img = c+c+"P≈"+c;
                    } else {
                        img = c+c+"P"+c+c;
                    }
                break;
                case "W":
                    img = c+c+"W"+c+c;
                break;
                case "E":
                    if(isFedorento() && isBrisa()){
                        img = c+"*-≈"+c;
                    } else if (isFedorento()) {
                        img = c+c+"*"+c+c;
                    } else if(isBrisa()){
                        img = c+c+"≈"+c+c;
                    } else {
                        img = c+c+c+c+c;
                    }
                break;
            }
        }else{
            if(tipo == "P"){
                img = c+c+"P"+c+c;
            }else{
                img = c+c+c+c+c;
            }
        }
        this.visible = visible;
    }
    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the brisa
     */
    public boolean isBrisa() {
        return brisa;
    }

    /**
     * @param brisa the brisa to set
     */
    public void setBrisa(boolean brisa) {
        this.brisa = brisa;
    }

    /**
     * @return the fedorento
     */
    public boolean isFedorento() {
        return fedorento;
    }

    /**
     * @param fedorento the fedorento to set
     */
    public void setFedorento(boolean fedor) {
        this.fedorento = fedor;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @return the caminho
     */
    public boolean isCaminho() {
        return caminho;
    }

    /**
     * @param caminho
     */
    public void setCaminho(boolean caminho) {
        this.caminho = caminho;
    }

    public boolean isPercorrido() {
        return percorrido;
    }

    public void setPercorrido(boolean percorrido) {
        this.percorrido = percorrido;
    }


}
