package fr.univbrest.dosi.dao.interfaces;

import java.util.List;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Promotion;


public interface PromotionRepositoryCustom {
	
	public List<Promotion> FindByRespo(Long noenseignant);



}
