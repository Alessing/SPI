package fr.univbrest.dosi.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.dao.interfaces.EtudiantRepositoryCustom;
import fr.univbrest.dosi.dao.interfaces.PromotionRepositoryCustom;

@Component
public class PromotionRepositoryImpl implements PromotionRepositoryCustom {

	 @PersistenceContext
	     private EntityManager entityManager;

	 @Override
	public List<Promotion> FindByRespo(Long id) {
		
		return Lists.newArrayList(this.entityManager.createQuery("Select P from Promotion P where P.enseignant.noEnseignant = :id ").setParameter("id", id).getResultList());		

	}

	 
	

}
