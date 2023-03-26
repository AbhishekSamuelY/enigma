package com.abhisheksamuely.apps.enigma.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;
import com.abhisheksamuely.apps.enigma.util.EnigmaUtils;

public class Reflector {

	private EnigmaConfiguration configuration;
	private EnigmaUtils utils;

	private Map<Integer, Integer> reflectorMapping = new HashMap<>();

	public Reflector(Reflectors reflectors, EnigmaConfiguration configuration, EnigmaUtils utils) {
		this.configuration = configuration;
		this.utils = utils;

		switch (reflectors) {
		case REFLECTORA:
			this.reflectorMapping = configuration.getReflectorA();
			utils.printMapping(reflectors.toString(), reflectorMapping);
			break;
		case REFLECTORB:
			this.reflectorMapping = configuration.getReflectorA();
			utils.printMapping(reflectors.toString(), reflectorMapping);
			break;
		case REFLECTORC:
			this.reflectorMapping = configuration.getReflectorA();
			utils.printMapping(reflectors.toString(), reflectorMapping);
			break;
		case REFLECTORBTHIN:
			this.reflectorMapping = configuration.getReflectorA();
			utils.printMapping(reflectors.toString(), reflectorMapping);
			break;
		case REFLECTORCTHIN:
			this.reflectorMapping = configuration.getReflectorA();
			utils.printMapping(reflectors.toString(), reflectorMapping);
			break;
		}
	}

	public Integer getLetter(Integer letter, Rotor rotor) {
		// TODO: set for all rotors
		rotor.setForwardMoving(true);
		return reflectorMapping.get(letter);
	}

}
