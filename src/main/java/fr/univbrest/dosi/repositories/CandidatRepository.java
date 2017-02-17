package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.dao.interfaces.CandidatRepositoryCustom;

@Component
public interface CandidatRepository extends CrudRepository<Candidat, String>, CandidatRepositoryCustom {
	
	public List<Candidat> findByNom(String name);
	public List<Candidat> findByUniversiteOrigine(String universiteOrigine);

}
