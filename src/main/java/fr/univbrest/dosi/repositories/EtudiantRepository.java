package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.dao.interfaces.EtudiantRepositoryCustom;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, String>, EtudiantRepositoryCustom {
	
	public Etudiant findByNom(String name);
	public List<Etudiant> findByUniversiteOrigine(String universiteOrigine);

}
