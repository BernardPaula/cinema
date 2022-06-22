package com.bernardpaula.cinema.domain.enums;

public enum EnumGeneroFilme {

	ACAO(1, "ação"),
	AVENTURA(2, "aventura"),
	SUSPENSE(3, "suspense"),
	COMEDIA(4, "comedia"),
	DRAMA(5, "drama");
	
	
	private Integer cod;
	private String message;
	
	
	private EnumGeneroFilme(Integer cod, String message) {
		this.cod = cod;
		this.message = message;
	}


	public Integer getCod() {
		return cod;
	}


	public String getMessage() {
		return message;
	}
	
	
	public static EnumGeneroFilme toEnumTipo(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EnumGeneroFilme x : EnumGeneroFilme.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id válido" + cod);
	}
	
}
