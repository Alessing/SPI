package fr.univbrest.dosi.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.dao.interfaces.EtudiantRepositoryCustom;

@Component
public class EtudiantRepositoryImpl implements EtudiantRepositoryCustom {

	 @PersistenceContext
	     private EntityManager entityManager;

	@Override
	public Etudiant FindByNomandPrenom(String name,String firstname) {
		
		return ((Etudiant) this.entityManager.createQuery("Select E from Etudiant E where E.nom = :nom and E.prenom = :prenom").setParameter("nom", name).setParameter("prenom", firstname).getResultList().get(0));		

	}
	 
	

}
