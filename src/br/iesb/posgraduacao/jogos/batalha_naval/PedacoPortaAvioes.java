package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoPortaAvioes extends PedacoNavio {
	@Override
	public void setAtingido(boolean destruir) {
		if(!this.isAtingido() && destruir){
			this.setVisivel(true);
			this.setForma("[x]|");
			this.setAtingido(destruir);
		}else{
			if(this.isAtingido() && !destruir){
				throw new Error("Um destroço não pode ser recuperado nesse jogo!");
			}else{
				throw new Error("Esse pedaço do Porta Aviões já está destruído!");
			}
		}
	}

	@Override
	public String getForma() {
		return this.getForma();
	}

	@Override
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
		if (visivel) {
			if (this.isAtingido()) {
				this.setForma("[x]|");
			}else{
				this.setForma("[P]|");
			}
		}else{
			this.setForma("~~~|");
		}
	}
}
