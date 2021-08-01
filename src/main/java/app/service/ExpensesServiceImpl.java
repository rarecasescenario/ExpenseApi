package app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.model.Expense;
import app.model.Expenses;
import app.model.Stores;
import app.model.T2Codes;
import app.repository.ExpenseRepository;
import app.repository.ExpensesRepository;
import app.repository.StoresRepository;
import app.repository.T2CodesRepository;

@Service
@Transactional
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	ExpenseRepository er;

	@Autowired
	ExpensesRepository expensesRepository;
	
	@Autowired
	private StoresRepository storesRepository;
	@Autowired
	private T2CodesRepository t2CodesRepository;
	
	@Override
	public List<Expenses> getExpenses() {
		return er.findAll();
	}
	
	@Override
	public Collection<Expenses> getExpenseById(Long id) {
		return er.findById(id);
	}

	@Override
	public Expense addExpense(Expense e) {
		return expensesRepository.save(e);
	}

	@Override
	public List<Stores> getAllStores() {
		return (List<Stores>) storesRepository.findAll();
	}

	@Override
	public List<T2Codes> getAllT2Codes() {
		return (List<T2Codes>) t2CodesRepository.findAll();
	}

	@Override
	public Stores addStore(Stores a) {
		return storesRepository.save(a);
	}

	@Override
	public T2Codes addCode(T2Codes o) {
		return t2CodesRepository.save(o);
	}

	@Override
	public Collection<T2Codes> getT2CodeById(Integer id) {
		return  (Collection<T2Codes>) t2CodesRepository.findAllByCode(id);
	}

	@Override
	public T2Codes findByCode(Integer o) {
		return t2CodesRepository.findOne(o);
	}

	@Override
	public boolean isT2CodeExists(T2Codes o) {
		
		Collection<T2Codes> fl = getT2CodeById(o.getCode());
		if(fl == null || fl.isEmpty()) {
			return false;
		}
		return true;
	}

	

	
}
