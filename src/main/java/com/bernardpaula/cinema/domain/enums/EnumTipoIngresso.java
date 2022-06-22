package com.bernardpaula.cinema.domain.enums;

public enum EnumTipoIngresso {

	MEIOIGRESSO(1, "Meio ingresso"),
	INGRESSOINTEIRO(2, "ingresso inteiro");
	
	
	private Integer cod;
	private String message;
	
	
	private EnumTipoIngresso(Integer cod, String message) {
		this.cod = cod;
		this.message = message;
	}

	
	public static EnumTipoIngresso toEnumGenero(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EnumTipoIngresso x : EnumTipoIngresso.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id válido" + cod);
	}
	

	public Integer getCod() {
		return cod;
	}


	public String getMessage() {
		return message;
	}
	
	
	
}
