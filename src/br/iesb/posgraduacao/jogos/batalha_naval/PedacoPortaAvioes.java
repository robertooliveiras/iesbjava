package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoPortaAvioes extends PedacoNavio {

	private final String name = "Porta Aviões";
	
	@Override
	public void setAtingido(boolean atingir) {
		if(!super.isAtingido() && atingir){
			super.setVisivel(true);
			super.setForma("[P1]|");
			super.setAtingido(atingir);
		}else{
			if(super.isAtingido() && !atingir){
				throw new Error("Um destroço não pode ser recuperado nesse "
						+ "jogo!");
			}else{
				throw new Error("Esse pedaço do Porta Aviões já está "
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
				super.setForma("[P1]|");
			}else{
				super.setForma("~P1~|");
			}
		}else{
			super.setForma("~~~~|");
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
	    return name;
	}

}
