package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoPortaAvioes extends PedacoNavio {
	@Override
	public void setAtingido(boolean destruir) {
		if(!super.isAtingido() && destruir){
			super.setVisivel(true);
			super.setForma("[x]|");
			super.setAtingido(destruir);
		}else{
			if(super.isAtingido() && !destruir){
				throw new Error("Um destroço não pode ser recuperado nesse jogo!");
			}else{
				throw new Error("Esse pedaço do Porta Aviões já está destruído!");
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
				super.setForma("[x]|");
			}else{
				super.setForma("[P]|");
			}
		}else{
			super.setForma("~~~|");
		}
	}
}
