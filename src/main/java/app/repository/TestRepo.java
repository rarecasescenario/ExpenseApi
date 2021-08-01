package app.repository;

import app.model.T2Codes;

public class TestRepo implements T2CodesRepository {

	@Override
	public <S extends T2Codes> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T2Codes> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
	public Iterable<T2Codes> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void delete(T2Codes entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends T2Codes> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public T2Codes findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<T2Codes> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<T2Codes> findAllByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}
}
