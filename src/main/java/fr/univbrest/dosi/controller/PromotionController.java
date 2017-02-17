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
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.business.interfaces.PromotionBusinessInterface;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;

@RestController
@RequestMapping("promotion")
public class PromotionController {

	@Autowired
	PromotionBusinessInterface business;

	public PromotionController() {
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public List<Promotion> getallpromotions() {
		return business.getAllPromotions();
	}
	
	@RequestMapping(value = { "/getbyens/{id}" }, method = RequestMethod.GET)
	public List<Promotion> getbyenseignant(@PathVariable("id") Long id) {
		return business.FindByenseignant(id);
	}


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void ajouterFormation(@RequestBody Promotion promotion) {
		business.CreatePromotion(promotion);
	}

	@RequestMapping(value = "/{codeFormation}/{noanne}", method = RequestMethod.DELETE)
	public void supprimerpromotion(@PathVariable("codeFormation") String codeFormation, @PathVariable("noanne") String noanne) {
		
		Promotion key = new Promotion();	
		key.getId().setAnneeUniversitaire(noanne);
		key.getId().setCodeFormation(codeFormation);
		 
		business.DeletePromotion(key.getId());
	}

}
