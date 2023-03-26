package com.abhisheksamuely.apps.enigma.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
public class User {

	@Id
	private String id;
}
