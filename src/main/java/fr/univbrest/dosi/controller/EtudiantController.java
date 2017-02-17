package fr.univbrest.dosi.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Etudiant;
import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.business.interfaces.EtudiantBusinessInterface;
import fr.univbrest.dosi.repositories.EtudiantRepository;


@RestController
@RequestMapping("etudiant")

public class EtudiantController {

	@Autowired
	EtudiantBusinessInterface business;
	
	public EtudiantController()
	{
	}
	
	@RequestMapping(value={"/getbynometprenom/{prenom}"})
	public ArrayList<Etudiant> getcandidatbyNomandPrenom( @PathVariable("firstname") String prenom){
		return Lists.newArrayList(business.FindBynom(prenom)) ;
	}
	
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public List<Etudiant> getalletudiants(){
		return Lists.newArrayList(business.getAllEtudiants());
	}
	
	@RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
	public Etudiant getbyid(@PathVariable("id") String id){
		return (business.FindbynoEtudiant(id));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createEtudiant(@RequestBody Etudiant E) {
		business.CreateEtudiant(E);
	}

	@RequestMapping(value = "/{noEtudiant}", method = RequestMethod.DELETE)
	public void supprimerpromotion(@PathVariable("noEtudiant") String noEtudiant) {

		business.DeleteEtudiant(noEtudiant);
	}

	
	
	
}


