package br.com.caio.futscore.enums;

public enum TipoCompeticaoEnum {
	
	NACIONAL("Nacional"),
	CONTINENTAL("Continental"),
	MUNDIAL("Mundial");
	
	private String competicao;
	
	TipoCompeticaoEnum(String competicao) {
		
		this.competicao = competicao;
		
	}

	public String getCompeticao() {
		
		return competicao;
	
	}
	
}
