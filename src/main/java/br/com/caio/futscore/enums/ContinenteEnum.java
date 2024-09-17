package br.com.caio.futscore.enums;

public enum ContinenteEnum {

	AMERICA_DO_SUL("América do Sul"),
	AMERICA_CENTRAL("América Central"),
	AMERICA_DO_NORTE("América do Norte"),
	ASIA("Ásia"),
	AFRICA("África"),
	EUROPA("Europa"),
	OCEANIA("Oceania"),
	ANTARTIDA("Antártida");
	
	private String continente;
	
	ContinenteEnum(String continente){
		
		this.continente = continente;
		
	}

	public String getContinente() {
		return continente;
	}

}
