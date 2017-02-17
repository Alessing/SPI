package fr.univbrest.dosi.business.stubs;

import java.util.ArrayList;
import java.util.List;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

//Permet de simuler une base de donnes
public class FormationRepositoryStub implements FormationRepository {

	List<Formation> formations;

	public FormationRepositoryStub() {
		formations = new ArrayList<Formation>();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return formations.size();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Formation entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Formation> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Formation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Formation> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findOne(String id) {
		// TODO Auto-generated method stub
		for(Formation f : formations){
			if(f.getCodeFormation().equals(id)){
				return f;
			}
		}
		return null;
	}

	@Override
	public <S extends Formation> S save(S entity) {
		formations.add(entity);
		return null;
	}

	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formation> findBynomFormation(String NomFormation) {
		// TODO Auto-generated method stub
		return null;
	}

}