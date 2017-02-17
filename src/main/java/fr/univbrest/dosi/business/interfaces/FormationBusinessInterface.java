package fr.univbrest.dosi.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Formation;

public interface FormationBusinessInterface {

	public boolean CreateFormation(Formation F);
	
	public List<Formation> GetAllFormations();
	
	public void DeleteFormation(Formation F);
	
	public void UpdateFormation(Formation F);
	
	public Formation FindByCodeFormation(String id);
	
	public List<Formation> FindbyNomFormation(String nom);
	
	public Long CountFormations();

	public void DeleteFormationParCode(String codeFormation);
	

}
