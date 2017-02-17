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
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.interfaces.FormationBusinessInterface;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;

@RestController
@RequestMapping("formation")
public class FormationController {

	@Autowired
	FormationBusinessInterface business;

	public FormationController() {
	}

	@RequestMapping(value = { "getbynom/{nom}" })
	public List<Formation> getformationbynom(@PathVariable("nom") String nom) {
		return Lists.newArrayList(business.FindbyNomFormation(nom));
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public List<Formation> getallcandidats() {
		return business.GetAllFormations();
	}
	

	@RequestMapping(value = { "/{code}" })
	public Formation getformationbycode(@PathVariable("code") String code) {
		return (business.FindByCodeFormation(code));
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void updateFormation(@RequestBody Formation formation) {
		business.UpdateFormation(formation);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void ajouterFormation(@RequestBody Formation formation) {
		business.CreateFormation(formation);
	}

	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.DELETE)
	public void supprimerformation(@PathVariable("codeFormation") String codeFormation) {
		business.DeleteFormationParCode(codeFormation);
	}

}
