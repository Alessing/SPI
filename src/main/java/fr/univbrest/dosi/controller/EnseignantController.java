package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.business.interfaces.EnseignantBusinessInterface;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@RestController
@RequestMapping("enseignant")
public class EnseignantController {

	@Autowired
	EnseignantBusinessInterface business;

	public EnseignantController() {
	}

	@RequestMapping(value = { "getbynom/{nom}" })
	public List<Enseignant> getenseignantbynom(@PathVariable("nom") String nom) {
		return Lists.newArrayList(business.FindbyNomEnseignant(nom));
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public List<Enseignant> getallenseignants() {
		return business.GetAllEnseignants();
	}
	

	@RequestMapping(value = { "/{code}" })
	public Enseignant getenseignantbycode(@PathVariable("code") Long code) {
		return (business.FindByCodeEnseignant(code));
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void updateEnseignant(@RequestBody Enseignant enseignant) {
		business.UpdateEnseignant(enseignant);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void ajouterEnseignant(@RequestBody Enseignant enseignant) {
		business.CreateEnseignant(enseignant);
	}

	@RequestMapping(value = "/{codeEnseignant}", method = RequestMethod.DELETE)
	public void supprimerformation(@PathVariable("codeEnseignant") Long codeEnseignant) {
		business.DeleteEnseignantParNumero(codeEnseignant);
	}

}
