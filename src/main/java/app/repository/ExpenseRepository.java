package app.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Expenses;

@Repository
public interface ExpenseRepository extends CrudRepository<Expenses, Long>{
	
	public List<Expenses> findAll();
	
	@Query("select ex from Expenses ex where ex.expenseId = :id")
	//public Collection<Expenses> findById(@Param("id") Long id);
	public Optional<Expenses> findById(@Param("id") Long id);
}
