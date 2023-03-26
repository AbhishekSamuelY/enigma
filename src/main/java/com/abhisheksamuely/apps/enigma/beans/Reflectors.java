package com.abhisheksamuely.apps.enigma.beans;

public enum Reflectors {

	REFLECTORA("reflectorA"), REFLECTORB("reflectorB"), REFLECTORC("reflectorC"), REFLECTORBTHIN("reflectorBThin"), REFLECTORCTHIN("reflectorCThin");

	private String reflector;
	
	Reflectors(String reflector) {
		this.reflector = reflector;
	}

	public String getReflector() {
		return reflector;
	}

	public void setReflector(String reflector) {
		this.reflector = reflector;
	}
	
}
