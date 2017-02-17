package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.dao.interfaces.EnseignantRepositoryCustom;

public interface EnseignantRepository extends CrudRepository<Enseignant, Long>, EnseignantRepositoryCustom {
	
	public List<Enseignant> findBynom(String nomenseignant);

}
