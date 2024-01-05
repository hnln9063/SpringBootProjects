package com.hnln.springbootmongodbtutorial.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hnln.springbootmongodbtutorial.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
	// Get expense record with name field
	@Query("{'name':?0}")
	Optional<Expense> findByName(String name);
	
	/*
	 * For suppose if you want to find expense by name and amount
	 * 
	 * Query annotation would be @Query("{'name' : ?0, 'amount':?1}")
	 * name would be the first parameter and amount will be the second parameter
	 * */
	
}
