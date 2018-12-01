package org.m2i.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")
public class CompteEpargne extends Compte {
	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String codeCompte, double solde, Date dateCreation, double taux) {
		super(codeCompte, solde, dateCreation);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}



}
