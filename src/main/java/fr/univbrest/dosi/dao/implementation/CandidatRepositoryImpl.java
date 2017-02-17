package fr.univbrest.dosi.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.dao.interfaces.CandidatRepositoryCustom;

public class CandidatRepositoryImpl implements CandidatRepositoryCustom {

	 @PersistenceContext
	     private EntityManager entityManager;

	@Override
	public List<Candidat> FindByNomandPrenom(String name,String firstname) {
		
		return Lists.newArrayList(this.entityManager.createQuery("Select C from Candidat C where C.nom = :nom and C.prenom = :prenom").setParameter("nom", name).setParameter("prenom", firstname).getResultList());		

	}
	 
	

}
