package fr.univbrest.dosi.dao.interfaces;

import java.util.List;

import fr.univbrest.dosi.beans.Candidat;


public interface CandidatRepositoryCustom {
	
	public List<Candidat> FindByNomandPrenom(String name,String firstname);


}
