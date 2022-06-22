package com.bernardpaula.cinema.domain.enums;

public enum EnumCategoriaIngresso {

	INGRESSOFISICO(1, "Ingresso físico"),
	INGRESSOONLINE(2, "Ingresso online");
	
	
	private Integer cod;
	private String message;
	
	
	
	private EnumCategoriaIngresso(Integer cod, String message) {
		this.cod = cod;
		this.message = message;
	}

	public static EnumCategoriaIngresso toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EnumCategoriaIngresso x : EnumCategoriaIngresso.values()) {
			if(cod.equals(x.getCod())){
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
