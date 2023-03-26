package com.abhisheksamuely.apps.enigma;

import com.abhisheksamuely.apps.enigma.beans.Reflector;
import com.abhisheksamuely.apps.enigma.beans.Reflectors;
import com.abhisheksamuely.apps.enigma.beans.Rotor;
import com.abhisheksamuely.apps.enigma.beans.Rotors;
import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;
import com.abhisheksamuely.apps.enigma.util.EnigmaUtils;

public class Enigma {

	private Rotor rotor1 = null;
	private Rotor rotor2 = null;
	private Rotor rotor3 = null;
	private Reflector reflector = null;
	private EnigmaConfiguration configuration;
	private EnigmaUtils utils;

	public Enigma(Rotors rotorOne, Rotors rotorTwo, Rotors rotorThree, Reflectors reflectorA, boolean isDefaultSetting, EnigmaConfiguration configuration) {
		this.configuration=configuration;
		if (isDefaultSetting) {
			defaultSettings(rotorOne, rotorTwo, rotorThree, reflectorA, configuration);
		} else {
			customSettings(rotorOne, rotorTwo, rotorThree, reflectorA, configuration);
		}
	}

	public void defaultSettings(Rotors rotorOne, Rotors rotorTwo, Rotors rotorThree, Reflectors reflectorA, EnigmaConfiguration configuration) {

		rotor1 = new Rotor(rotorOne,configuration, utils, 3);
		rotor2 = new Rotor(rotorTwo,configuration, utils, 2);
		rotor3 = new Rotor(rotorThree,configuration, utils, 1);
		reflector = new Reflector(reflectorA, configuration, utils);
		
		rotor1.setPreviousRotor(null);
		rotor1.setNextRotor(rotor2);
		rotor2.setPreviousRotor(rotor1);
		rotor2.setNextRotor(rotor3);
		rotor3.setPreviousRotor(rotor2);
		rotor3.setNextRotor(null);
	}

	public void customSettings(Rotors rotorOne, Rotors rotorTwo, Rotors rotorThree, Reflectors reflector, EnigmaConfiguration configuration) {
		rotor1 = new Rotor(rotorOne,configuration, utils, 3);
		rotor2 = new Rotor(rotorTwo,configuration, utils, 2);
		rotor3 = new Rotor(rotorThree,configuration, utils, 1);
		
		rotor1.setPreviousRotor(null);
		rotor1.setNextRotor(rotor2);
		rotor2.setPreviousRotor(rotor1);
		rotor2.setNextRotor(rotor3);
		rotor3.setPreviousRotor(rotor2);
		rotor3.setNextRotor(null);
	}

}
