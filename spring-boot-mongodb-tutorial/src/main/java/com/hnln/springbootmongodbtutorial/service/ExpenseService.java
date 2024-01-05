package com.hnln.springbootmongodbtutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hnln.springbootmongodbtutorial.model.Expense;
import com.hnln.springbootmongodbtutorial.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// we will pass expense from the controller
	public void addExpense(Expense expense) {
		// call the insert method of expense repository and pass the expense
		expenseRepository.insert(expense);
		
	}
	
	// Read the response from the database and update it
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId()).
				orElseThrow(()->new RuntimeException (String.format("cannot find expense by Id %s", expense.getId())));
		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());
		
		expenseRepository.save(expense);
	}
	
	// We will return a list of expenses
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();	
	}
	
	// We just return an expense
	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name).
				orElseThrow(()-> new RuntimeException (String.format("Cannot find expense by name %s", name)));
	}
	
	// Deleting an expense by id
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}

}
