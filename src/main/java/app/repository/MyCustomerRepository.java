package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.model.MyCustomer;

@RepositoryRestResource(collectionResourceRel = "customers", path="customers")
public interface MyCustomerRepository extends CrudRepository<MyCustomer, Long>{
	public List<MyCustomer> findAll();
	
    @Query("from mycustomer c where lower(c.name) like CONCAT('%', lower(:name), '%')")
    public Iterable<MyCustomer> findByName(@Param("name") String name);
    
}
