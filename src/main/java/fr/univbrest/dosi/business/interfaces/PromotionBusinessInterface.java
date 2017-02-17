package fr.univbrest.dosi.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;

public interface PromotionBusinessInterface {

	public boolean CreatePromotion(Promotion P);
	
	public List<Promotion> getAllPromotions();
	
	public Long CountPromotions();

	public void DeletePromotion(PromotionPK key);
	
	public void FindById(PromotionPK key);
	
	public List<Promotion> FindByenseignant(Long id);

}
