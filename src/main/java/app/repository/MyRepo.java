package app.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import app.model.MyCustomer;

public class MyRepo implements MyCustomerRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MyCustomer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends MyCustomer> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<MyCustomer> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyCustomer findOne(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyCustomer customer = new MyCustomer();
		try{
			customer = session.get(MyCustomer.class, id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return customer;
	}

	@Override
	public <S extends MyCustomer> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyCustomer> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyCustomer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<MyCustomer> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
