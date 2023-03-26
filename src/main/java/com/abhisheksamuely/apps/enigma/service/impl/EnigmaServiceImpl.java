package com.abhisheksamuely.apps.enigma.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abhisheksamuely.apps.enigma.beans.PlugBoard;
import com.abhisheksamuely.apps.enigma.beans.Reflector;
import com.abhisheksamuely.apps.enigma.beans.Reflectors;
import com.abhisheksamuely.apps.enigma.beans.Rotor;
import com.abhisheksamuely.apps.enigma.beans.Rotors;
import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;
import com.abhisheksamuely.apps.enigma.configuration.EnigmaConstants;
import com.abhisheksamuely.apps.enigma.repository.EnigmaRepository;
import com.abhisheksamuely.apps.enigma.service.EnigmaService;
import com.abhisheksamuely.apps.enigma.util.EnigmaUtils;

@Service
public class EnigmaServiceImpl implements EnigmaService {
	
	private EnigmaRepository repository;
	private EnigmaConfiguration configuration;
	private EnigmaUtils utils;
	
	public EnigmaServiceImpl(EnigmaRepository repository, EnigmaConfiguration configuration, EnigmaUtils utils) {
		this.repository = repository;
		this.configuration = configuration;
		this.utils = utils;
	}

	Rotor rotor1 = null;
	Rotor rotor2 = null;
	Rotor rotor3 = null;
	Reflector reflector = null;
	PlugBoard plugBoard = null;
	
	
	@Override
	public String setConfiguration(List<Rotors> rotors) {
		
		return "settings updated!";
	}

	@Override
	public void initilize() {
		rotor1 = new Rotor(Rotors.ROTOR1,configuration, utils, 1);
		rotor2 = new Rotor(Rotors.ROTOR2,configuration, utils, 2);
		rotor3 = new Rotor(Rotors.ROTOR3,configuration, utils, 3);
		reflector = new Reflector(Reflectors.REFLECTORA, configuration, utils);
		//plugBoard = new PlugBoard(configuration, utils);
		
				
		rotor1.setNextRotor(null);
		rotor1.setPreviousRotor(rotor2);
		rotor2.setPreviousRotor(rotor1);
		rotor2.setNextRotor(rotor3);
		rotor3.setPreviousRotor(rotor2);
		rotor3.setNextRotor(null);
	}

	@Override
	public String encryptMessage(String message) {
		String[] messageArray = message.split("");
		String secreteMessage = "";
		
		for(String letter : messageArray) {
			if(letter.equals(" ")) {
				secreteMessage += " ";
			} else {
				//System.out.print("letter: "+letter+" ");
				Integer rotor1Backward = rotor1.getLetter(configuration.getNumbersToLetters().get(letter), rotor1);
				//System.out.print("Rotor1B: "+configuration.getEnglishLetters().get(rotor1Backward)+" letterCounter"+rotor1.getLetterCounter());
				Integer rotor2Backward = rotor2.getLetter(rotor1Backward, rotor2);
				//System.out.print(" Rotor2B: "+configuration.getEnglishLetters().get(rotor2Backward)+" letterCounter"+rotor1.getLetterCounter());
				Integer rotor3Backward = rotor3.getLetter(rotor2Backward, rotor3);
				//System.out.print(" Rotor3B: "+configuration.getEnglishLetters().get(rotor3Backward)+" letterCounter"+rotor1.getLetterCounter());
				Integer reflectorInput = reflector.getLetter(rotor3Backward, rotor3);
				//System.out.print(" reflector: "+configuration.getEnglishLetters().get(reflectorInput)+" letterCounter"+rotor1.getLetterCounter());
				Integer rotor3Forward = rotor3.getLetter(reflectorInput, rotor3);
				//System.out.print(" Rotor3F: "+configuration.getEnglishLetters().get(rotor3Forward)+" letterCounter"+rotor1.getLetterCounter());
				Integer rotor2Forward = rotor3.getLetter(rotor3Forward, rotor2);
				//System.out.print(" Rotor2F: "+configuration.getEnglishLetters().get(rotor2Forward)+" letterCounter"+rotor1.getLetterCounter());
				Integer rotor1Forward = rotor3.getLetter(rotor2Forward, rotor1);
				//System.out.print(" Rotor1F: "+configuration.getEnglishLetters().get(rotor1Forward)+" letterCounter"+rotor1.getLetterCounter());
				
				//System.out.println(letter +" -> "+rotor1Backward+ " -> "+rotor2Backward+" -> "+rotor3Backward+" -> "+rotor3Forward+" -> "+rotor2Forward+" -> "+rotor1Forward+" -> "+configuration.getEnglishLetters().get(rotor1Forward));
				secreteMessage += configuration.getEnglishLetters().get(rotor1Forward);
				//System.out.println();
			}
		}
		
		return secreteMessage;
	}

}
