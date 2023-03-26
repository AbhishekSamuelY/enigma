package com.abhisheksamuely.apps.enigma.beans;

public enum Rotors {
	ROTOR1("rotor1"), ROTOR2("rotor2"), ROTOR3("rotor3"), ROTOR4("rotor4"), ROTOR5("rotor5"), ROTOR6("rotor6"), ROTOR7("rotor7"), ROTOR8("rotor8");
	
	private String rotor;

	private Rotors(String rotor) {
		this.rotor = rotor;
	}

	public String getRotor() {
		return rotor;
	}

	public void setRotor(String rotor) {
		this.rotor = rotor;
	}
	
}
