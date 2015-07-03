package br.iesb.posgraduacao.jogos.wumpus;

public class Espaco {
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
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
	if(visible){
	    switch (tipo) {
	    case "O":
		img = "ouro \n!1000\n*****";
		break;
	    case "B":
		img = "\n  B  \n";
		break;
	    case "P":
		img = "\n  P  \n";
		break;
	    case "E":
	    default:
		img = "\n";
		if(isFedorento()){
		    img = "fedor\n";
		}else{
		    img = "-----\n";
		}
		if(isBrisa()){
		    img = "brisa";
		}else{
		    img = "-----";
		}
		break;
	    }
	    
	}
	this.visible = visible;
    }

}
