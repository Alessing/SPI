package fr.univbrest.dosi.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.beans.Formation;

public interface EtudiantBusinessInterface {

	public boolean CreateEtudiant(Etudiant E);
	
	public List<Etudiant> getAllEtudiants();
	
	public void DeleteEtudiant(String id);
	
	public List<Etudiant> FindByuniversiteOrigine(String univ);
	
	public List<Etudiant> FindBynom(String nom);

	public Etudiant FindbynoEtudiant(String id);
	
	public Long CountEtudiants();


}
