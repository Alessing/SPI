package fr.univbrest.dosi.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.business.interfaces.CandidatBusinessInterface;
import fr.univbrest.dosi.business.interfaces.EtudiantBusinessInterface;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;
import fr.univbrest.dosi.repositories.EtudiantRepository;

@Component
public class EtudiantBusinessImpl implements EtudiantBusinessInterface {
	
	private final EtudiantRepository EtudiantDAO;
	
	@Autowired
	public EtudiantBusinessImpl(EtudiantRepository  entrepot) {
		super();
		this.EtudiantDAO = entrepot;
	}

	@Override
	public boolean CreateEtudiant(Etudiant P) {
		EtudiantDAO.save(P);
		return true;
	}

	@Override
	public List<Etudiant> getAllEtudiants() {

		return Lists.newArrayList(EtudiantDAO.findAll());
	}

	@Override
	public Long CountEtudiants() {

		return EtudiantDAO.count();
	}

	@Override
	public void DeleteEtudiant(String id) {
		
		EtudiantDAO.delete(id);
	}

	@Override
	public List<Etudiant> FindByuniversiteOrigine(String univ) {
		return Lists.newArrayList(EtudiantDAO.findByUniversiteOrigine(univ));
	}

	@Override
	public Etudiant FindbynoEtudiant(String id) {
		return EtudiantDAO.findOne(id);
	}

	@Override
	public List<Etudiant> FindBynom(String nom) {
		return Lists.newArrayList(EtudiantDAO.findByNom(nom));
	}

	
}
