package br.com.caio.futscore.enums;

public enum FormatoCompeticaoEnum {

	PONTOS_CORRIDOS("Pontos Corridos"),
	MATA_MATA("Mata-Mata"),
	PONTOS_CORRIDOS_MATA_MATA("Pontos Corridos + Mata-Mata");
	
	private String formato;
	
	FormatoCompeticaoEnum(String formato) {
		
		this.formato = formato;
		
	}

	public String getFormato() {
		return formato;
	}
	
}
