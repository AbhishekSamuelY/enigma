package com.abhisheksamuely.apps.enigma.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Configuration {
	private List<Rotors> rotors = new ArrayList<>();
	
}
