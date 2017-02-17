package fr.univbrest.dosi.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.interfaces.EnseignantBusinessInterface;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class EnseignantBusinessImpl implements EnseignantBusinessInterface {
	
	private final EnseignantRepository EnseignantDAO;
	
	@Autowired
	public EnseignantBusinessImpl(EnseignantRepository  entrepot) {
		super();
		this.EnseignantDAO = entrepot;
	}

	@Override
	public boolean CreateEnseignant(Enseignant E) {
		if(EnseignantDAO.findOne(E.getNoEnseignant()) != null)
			return false;
		
		EnseignantDAO.save(E);
		
		return true;
	}

	@Override
	public List<Enseignant> GetAllEnseignants() {
		return  Lists.newArrayList(EnseignantDAO.findAll());
	}

	@Override
	public void DeleteEnseignant(Enseignant F) {
		
	}

	@Override
	public void UpdateEnseignant(Enseignant E) {
		EnseignantDAO.save(E);
	}

	@Override
	public Enseignant FindByCodeEnseignant(Long id) {
		
		return EnseignantDAO.findOne(id);
	}

	@Override
	public List<Enseignant> FindbyNomEnseignant(String nom) {
		return Lists.newArrayList(EnseignantDAO.findBynom(nom));
	}

	@Override
	public Long CountEnseignants() {
		return EnseignantDAO.count();
	}

	@Override
	public void DeleteEnseignantParNumero(Long noEnseignant) {
		EnseignantDAO.delete(noEnseignant);	
		
	}

	
}
