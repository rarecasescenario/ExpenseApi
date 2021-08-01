package app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import app.model.Expense;
import app.model.Expenses;
import app.model.Stores;
import app.model.T2Codes;

@Service
public interface ExpensesService {
	List<Expenses> getExpenses();
	Collection<Expenses> getExpenseById(Long id);
	
	Expense addExpense(Expense e);
	
	List<Stores> getAllStores();
	Stores addStore(Stores a);
	
	List<T2Codes> getAllT2Codes();
	Collection<T2Codes> getT2CodeById(Integer id);
	T2Codes findByCode(Integer o);
	
	T2Codes addCode(T2Codes o);
	
	boolean isT2CodeExists(T2Codes o);
}
