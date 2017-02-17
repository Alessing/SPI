package fr.univbrest.dosi.dao.interfaces;

import fr.univbrest.dosi.beans.Etudiant;


public interface EtudiantRepositoryCustom {
	
	public Etudiant FindByNomandPrenom(String name,String firstname);

}
