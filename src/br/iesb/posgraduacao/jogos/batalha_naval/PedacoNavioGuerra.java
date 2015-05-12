package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoNavioGuerra extends PedacoNavio {
	private char tipo = ' ';
	
	public PedacoNavioGuerra(char t){
		setTipo(t);
	}

	@Override
	public void setAtingido(boolean destruir) {
		if(!super.isAtingido() && destruir){
			super.setVisivel(true);
			super.setForma("xN"+this.getTipo()+"x|");
			super.setAtingido(destruir);
		}else{
			if(super.isAtingido() && !destruir){
				throw new Error("Um destroço não pode ser recuperado nesse "
						+ "jogo!");
			}else{
				throw new Error("Esse pedaço do Navio de Guerra já está "
						+ "destruído!");
			}
		}
	}

	@Override
	public String getForma() {
		return super.getForma();
	}

	@Override
	public void setVisivel(boolean visivel) {
		super.visivel = visivel;
		if (visivel) {
			if (super.isAtingido()) {
				super.setForma("xN"+this.getTipo()+"x|");
			}else{
				super.setForma("[N"+this.getTipo()+"]|");
			}
		}else{
			super.setForma("~~~~|");
		}
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
}
