package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.dao.interfaces.FormationRepositoryCustom;
import fr.univbrest.dosi.dao.interfaces.PromotionRepositoryCustom;

public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK>, PromotionRepositoryCustom {
	
	public List<Promotion> findByenseignant(Enseignant E);

}
