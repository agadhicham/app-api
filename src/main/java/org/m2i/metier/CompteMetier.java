package org.m2i.metier;

import org.m2i.entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte compte);
	public Compte getCompte(String code);

}
