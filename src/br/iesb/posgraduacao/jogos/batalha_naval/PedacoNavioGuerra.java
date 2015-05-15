package br.iesb.posgraduacao.jogos.batalha_naval;

public class PedacoNavioGuerra extends PedacoNavio {
	private char tipo = ' ';
	private final String name = "Navio de Guerra";
	
	public PedacoNavioGuerra(char t){
		setTipo(t);
	}

	@Override
	public void setAtingido(boolean atingir) {
		if(!super.isAtingido() && atingir){
			super.setVisivel(true);
			super.setForma("[N"+this.getTipo()+"]|");
			super.setAtingido(atingir);
		}else{
			if(super.isAtingido() && !atingir){
				throw new Error("Um destroço não pode ser recuperado nesse "
						+ "jogo!");
			}else{
				throw new Error("Esse pedaço do Navio de Guerra já está "
						+ "destruído!");
			}
		}
	}

	@Override
	public String getId() {
	    return super.getId();
	}

	@Override
	public void setId(String id) {
	    super.setId(id);
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
				super.setForma("[N"+this.getTipo()+"]|");
			}else{
				super.setForma("~N"+this.getTipo()+"~|");
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

	/**
	 * @return the name
	 */
	public String getName() {
	    return name;
	}
}
