package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Expense;

@Repository
public interface ExpensesRepository  extends CrudRepository<Expense, Long>{

}
