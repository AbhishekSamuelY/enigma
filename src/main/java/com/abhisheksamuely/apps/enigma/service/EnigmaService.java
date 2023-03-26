package com.abhisheksamuely.apps.enigma.service;

import java.util.List;

import com.abhisheksamuely.apps.enigma.beans.Rotors;

public interface EnigmaService {

	String setConfiguration(List<Rotors> rotors);

	void initilize();

	String encryptMessage(String message);

}
