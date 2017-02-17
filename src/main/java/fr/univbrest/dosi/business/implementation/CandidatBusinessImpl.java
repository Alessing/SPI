package fr.univbrest.dosi.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.interfaces.CandidatBusinessInterface;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class CandidatBusinessImpl implements CandidatBusinessInterface {
	
	private final CandidatRepository CandidatDAO;
	
	@Autowired
	public CandidatBusinessImpl(CandidatRepository  entrepot) {
		super();
		this.CandidatDAO = entrepot;
	}

	@Override
	public void DeleteCandidatByNo(String nocandidat) {
		CandidatDAO.delete(nocandidat);		
	}

	@Override
	public boolean CreateCandidat(Candidat C) {
		CandidatDAO.save(C);
		return true;
	}

	@Override
	public List<Candidat> GetAllCandidats() {
		
		return Lists.newArrayList(CandidatDAO.findAll());
	}

	@Override
	public List<Candidat> findByUniversiteOrigine(String univ) {
		return Lists.newArrayList(CandidatDAO.findByUniversiteOrigine(univ));
	}

	@Override
	public List<Candidat> FindByNomandPrenom(String nom, String prenom) {
		return Lists.newArrayList(CandidatDAO.FindByNomandPrenom(nom, prenom));
	}

	@Override
	public Long CountCandidats() {
		return CandidatDAO.count();
	}
}
