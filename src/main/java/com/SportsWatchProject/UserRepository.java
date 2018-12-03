package com.SportsWatchProject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SportsWatchProject.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<TeamsEntity, Integer> {
	
	
public TeamsEntity findById(int id); 

public List<TeamsEntity> findAll();
}
