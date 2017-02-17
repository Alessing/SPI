package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.dao.interfaces.FormationRepositoryCustom;

public interface FormationRepository extends CrudRepository<Formation, String>, FormationRepositoryCustom {
	
	public List<Formation> findBynomFormation(String NomFormation);

}
