package com.abhisheksamuely.apps.enigma.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhisheksamuely.apps.enigma.configuration.EnigmaConfiguration;
import com.abhisheksamuely.apps.enigma.util.EnigmaUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rotor {

	private EnigmaConfiguration configuration;
	private EnigmaUtils utils;

	private String rotorName;
	private Rotor previousRotor;
	private Rotor nextRotor;
	private Integer notch;
	private Integer letterCounter = 0;
	private boolean isForwardMoving;
	private Integer rotorPosition;
	private boolean hasMoved;

	private Map<Integer, Integer> rotorMapping = new HashMap<>();

	public Rotor(Rotors rotor, EnigmaConfiguration configuration, EnigmaUtils utils, Integer rotorPosition) {
		this.configuration = configuration;
		this.utils = utils;
		this.rotorPosition = rotorPosition;

		isForwardMoving = false;

		switch (rotor) {
		case ROTOR1:
			this.rotorMapping = configuration.getRotorOne();
			this.setRotorName(configuration.getRotorOneName());
			this.setNotch(configuration.getRotorOneNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR2:
			this.rotorMapping = configuration.getRotorTwo();
			this.setRotorName(configuration.getRotorTwoName());
			this.setNotch(configuration.getRotorTwoNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR3:
			this.rotorMapping = configuration.getRotorThree();
			this.setRotorName(configuration.getRotorThreeName());
			this.setNotch(configuration.getRotorThreeNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR4:
			this.rotorMapping = configuration.getRotorFour();
			this.setRotorName(configuration.getRotorFourName());
			this.setNotch(configuration.getRotorFourNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR5:
			this.rotorMapping = configuration.getRotorFive();
			this.setRotorName(configuration.getRotorFiveName());
			this.setNotch(configuration.getRotorFiveNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR6:
			this.rotorMapping = configuration.getRotorSix();
			this.setRotorName(configuration.getRotorSixName());
			this.setNotch(configuration.getRotorSixNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR7:
			this.rotorMapping = configuration.getRotorSeven();
			this.setRotorName(configuration.getRotorSevenName());
			this.setNotch(configuration.getRotorSevenNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		case ROTOR8:
			this.rotorMapping = configuration.getRotorEight();
			this.setRotorName(configuration.getRotorEightName());
			this.setNotch(configuration.getRotorEightNotch());
			utils.printMapping(rotor.toString(), rotorMapping);
			break;
		}
	}

	public void setPreviousRotor(Rotor previousRotor) {
		this.previousRotor = previousRotor;
	}

	public void setNextRotor(Rotor nextRotor) {
		this.nextRotor = nextRotor;
	}

	public Integer getLetter(Integer letter, Rotor rotor) {

		this.setLetterCounter(this.getLetterCounter() + 1);
		int letterFromRotor = this.rotorMapping.get(letter);
		

		if (letterFromRotor == this.notch && checkPreviousNotchMoved(letter)) {
			System.out.println("this.notch: "+this.notch+" this.rotorName: "+this.rotorName);
		}
			//System.out.println();
		/*
		 * System.out.println(); System.out.println(); System.out.println();
		 * System.out.println(letterFromRotor + " is notch"); System.out.println();
		 * System.out.println(); System.out.println(); System.out.println();
		 */
		this.rotorMapping = utils.reMapRotor(this.rotorMapping);

		/*
		 * notch setting
		 * 
		 * moving backward(R->R3->R2->R1) rotates notch?? how notch rotation changes
		 * other rotors??
		 */
		if (letter == notch && checkPreviousNotchMoved(letter)) {
			//System.out.print("  " + this.rotorName + " :: Letter:  " + letter + ", " + "notch moved "+ " isForwardMoving: " + isForwardMoving);
			rotorMapping = utils.reMapRotor(rotorMapping);
			previousRotor.rotorMapping = utils.reMapRotor(previousRotor.rotorMapping);
			rotorMapping = utils.reMapRotor(rotorMapping);
		}

		return letterFromRotor;
	}

	private boolean checkPreviousNotchMoved(Integer letter) {
		if (this.rotorPosition == 3) {
			if (this.previousRotor.hasMoved == true	&& letter == this.notch) {
				return true;
			}
		} else if (this.rotorPosition == 2 && letter == this.notch) {

		} else {
			if (this.previousRotor.hasMoved == true) {
				return true;
			}
		}
		return false;
	}

}
