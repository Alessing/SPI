package fr.univbrest.dosi.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.business.interfaces.CandidatBusinessInterface;
import fr.univbrest.dosi.business.interfaces.PromotionBusinessInterface;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Component
public class PromotionBusinessImpl implements PromotionBusinessInterface {
	
	private final PromotionRepository PromotionDAO;
	
	@Autowired
	public PromotionBusinessImpl(PromotionRepository  entrepot) {
		super();
		this.PromotionDAO = entrepot;
	}

	@Override
	public boolean CreatePromotion(Promotion P) {
		PromotionDAO.save(P);
		return true;
	}

	@Override
	public List<Promotion> getAllPromotions() {

		return Lists.newArrayList(PromotionDAO.findAll());
	}

	@Override
	public Long CountPromotions() {

		return PromotionDAO.count();
	}

	@Override
	public void DeletePromotion(PromotionPK key) {
		
		PromotionDAO.delete(key);
	}

	@Override
	public void FindById(PromotionPK key) {

		PromotionDAO.findOne(key);
	}

	@Override
	public List<Promotion> FindByenseignant(Long id) {
		return PromotionDAO.FindByRespo(id);
	}

	
}
