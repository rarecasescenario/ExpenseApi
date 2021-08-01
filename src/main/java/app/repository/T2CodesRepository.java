package app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import app.model.T2Codes;

public interface T2CodesRepository extends CrudRepository<T2Codes, Integer>{

	   @Query("from T2Codes t where t.code= :code")
	    public Iterable<T2Codes> findAllByCode(@Param("code") Integer code);
	
}
