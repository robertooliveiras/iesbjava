package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoNavioGuerra extends PedacoNavio {
	
	private String forma = "[N]|";
	
	public PedacoNavioGuerra(char linha, char coluna) {
		super(linha, coluna);
	}


	public void setAtingido(boolean destruir) {
		if(!this.isAtingido() && destruir){
			this.setVisivel(true);
			this.setForma("[x]|");
			this.setAtingido(destruir);
		}else{
			if(this.isAtingido() && !destruir){
				throw new Error("Um destroço não pode ser recuperado nesse jogo!");
			}else{
				throw new Error("Esse pedaço do Navio de Guerra já está destruído!");
			}
		}
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	


}