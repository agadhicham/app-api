package org.m2i.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPE",discriminatorType=DiscriminatorType.STRING,length=2)

//il faut que les deux classe hériter connu par le json donc on va ajouter un proprite appel type pour avour si un compte cc ou ce
//car le classe compte possede des classe dérivé
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
              include=JsonTypeInfo.As.PROPERTY,
              property="type")
//declaration des types dérivés
//dans l'affichage de resultat pour s'avoir les types des comptes qui sont dirivé soit cc ou ce :cas de resfulltapi

@JsonSubTypes({
	         @Type(name="CC", value=CompteCourant.class),
	         @Type(name="CE", value=CompteEpargne.class)
              })
@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})
//dans l'affichage de resultat pour s'avoir les types des comptes qui sont dirivé soit cc ou ce :cas de soapapi
//@XmlSeeAlso({CompteCourant.class,CompteEpargne.class})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Compte implements Serializable {
	@Id
	private String codeCompte;
	private double solde;
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Client client;
	@ManyToOne
	@JoinColumn(name="CODE_EMPLOE")
	private Employee employee;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String codeCompte, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.solde = solde;
	}
	@JsonIgnore
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	//annotation pour restfullapi
	@JsonIgnore
	//annotation pour soap
	@XmlTransient
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	public Compte(String codeCompte, double solde, Date dateCreation) {
		super();
		this.codeCompte = codeCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}

}
