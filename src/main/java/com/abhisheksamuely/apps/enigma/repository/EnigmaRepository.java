package com.abhisheksamuely.apps.enigma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhisheksamuely.apps.enigma.beans.User;

@Repository
public interface EnigmaRepository extends CrudRepository<User, String> {

}
