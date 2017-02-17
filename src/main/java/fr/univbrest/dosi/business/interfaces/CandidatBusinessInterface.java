package fr.univbrest.dosi.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Formation;

public interface CandidatBusinessInterface {

	public boolean CreateCandidat(Candidat C);
	
	public List<Candidat> GetAllCandidats();
		
	public List<Candidat> findByUniversiteOrigine(String univ);
	
	public List<Candidat> FindByNomandPrenom(String nom, String prenom);
	
	public Long CountCandidats();

	public void DeleteCandidatByNo(String nocandidat);
	

}
