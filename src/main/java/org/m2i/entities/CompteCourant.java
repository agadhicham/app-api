package org.m2i.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
//pour specifier le type de compte pour le classe dirivé :cas de utilser resfulltapi
@DiscriminatorValue("CC")
//pour specifier le type de compte pour le classe dirivé :cas de utilser soapapi
@XmlType(name = "CC")
public class CompteCourant extends Compte {
	private double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}

	public CompteCourant(String codeCompte, double solde, double decouvert) {
		super(codeCompte, solde);
		this.decouvert = decouvert;
	}

	public CompteCourant(String codeCompte, double solde, Date dateCreation, double decouvert) {
		super(codeCompte, solde, dateCreation);
		this.decouvert = decouvert;
	}

}
