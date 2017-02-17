package fr.univbrest.dosi.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Enseignant;

public interface EnseignantBusinessInterface {

	public boolean CreateEnseignant(Enseignant F);
	
	public List<Enseignant> GetAllEnseignants();
	
	public void DeleteEnseignant(Enseignant F);
	
	public void UpdateEnseignant(Enseignant F);
	
	public Enseignant FindByCodeEnseignant(Long id);
	
	public List<Enseignant> FindbyNomEnseignant(String nom);
	
	public Long CountEnseignants();

	public void DeleteEnseignantParNumero(Long noEnseignant );
	
	

}
