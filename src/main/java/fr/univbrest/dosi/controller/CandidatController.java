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
import fr.univbrest.dosi.business.implementation.CandidatBusinessImpl;
import fr.univbrest.dosi.repositories.CandidatRepository;


@RestController
@RequestMapping("candidat")
public class CandidatController {

	@Autowired
	CandidatBusinessImpl business;
	
	public CandidatController()
	{
	}
	
	@RequestMapping(value={"/getbynometprenom/{name}/{firstname}"})
	public List<Candidat> getcandidatbyNomandPrenom(@PathVariable("name") String nom, @PathVariable("firstname") String prenom){
		return Lists.newArrayList(business.FindByNomandPrenom(nom,prenom)) ;
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public List<Candidat> getallcandidats(){
		return Lists.newArrayList(business.GetAllCandidats());
	}
	
	@RequestMapping(value={"/getbyUniv/{univ}"})
	public List<Candidat> getcandidatbyNomandPrenom(@PathVariable("univ") String univ){
		return Lists.newArrayList(business.findByUniversiteOrigine(univ)) ;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void ajouterCandidat(@RequestBody Candidat C) {
		business.CreateCandidat(C);
	}
	
	@RequestMapping(value = "/{noCandidat}", method = RequestMethod.DELETE)
	public void deletebycode(@PathVariable("codeCandidat") String noCandidat){
		 business.DeleteCandidatByNo(noCandidat);
	}
	
	
	
}


