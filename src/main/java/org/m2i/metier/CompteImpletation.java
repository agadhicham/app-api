package org.m2i.metier;

import java.util.Date;

import org.m2i.dao.CompteRepository;
import org.m2i.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteImpletation implements CompteMetier{

	@Autowired
	private CompteRepository compteRepository;
	@Override
	public Compte saveCompte(Compte compte) {
		//compte.setDateCreation(new Date());
		return compteRepository.save(compte);
	}

	@Override
	public Compte getCompte(String code) {
		return compteRepository.getOne(code);
	}

}
