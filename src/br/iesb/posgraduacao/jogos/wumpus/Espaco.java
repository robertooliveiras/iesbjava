package br.iesb.posgraduacao.jogos.wumpus;

public class Espaco {
    private boolean caminho = false;
    private boolean fedorento;
    private boolean brisa;
    private String tipo = "E";
    private String img;
    private boolean visible = false;

    public Espaco() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        if (visible) {
            switch (tipo) {
                case "O":
                    img = "ouro ";
                break;
                case "B":
                    img = "--B--";
                break;
                case "P":
                    img = "--P--";
                break;
                case "E":
                default:
                    if(isFedorento() && isBrisa()){
                        img = "-*-≈-";
                    } else if (isFedorento()) {
                        img = "--*--";
                    } else if(isBrisa()){
                        img = "--≈--";
                    } else {
                        img = "-----";
                    }
                break;
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


}
