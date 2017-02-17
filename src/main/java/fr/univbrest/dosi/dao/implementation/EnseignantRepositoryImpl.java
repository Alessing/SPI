package fr.univbrest.dosi.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.dao.interfaces.FormationRepositoryCustom;


public class EnseignantRepositoryImpl implements FormationRepositoryCustom {

	 @PersistenceContext
	     private EntityManager entityManager;

	
	

}
