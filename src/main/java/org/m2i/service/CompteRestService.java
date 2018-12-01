package org.m2i.service;

import org.m2i.entities.Compte;
import org.m2i.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {
	
	@Autowired
	private CompteMetier compteMetier;

	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	//ici lors d'ajout d'un compte il ne connu pas de qu'il compte s'agit cc ou ce
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}

	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}

}
