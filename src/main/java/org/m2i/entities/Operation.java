package org.m2i.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="V", value=Versment.class),
	@Type(name="R", value=Retrait.class)
})

@XmlSeeAlso({Retrait.class,Versment.class})
public class  Operation implements Serializable{
	@Id
	@GeneratedValue
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_COMPTE")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="CODE_Employ")
	private Employee employee;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@JsonIgnore
	@XmlTransient
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	//ignorer les donnes relationnele avec opertin 
	//ignorer les donner de compte pour opertaion cas de :restfullapi
	@JsonIgnore
	//ignorer les donner de compte pour opertaion cas de :saopapi
	@XmlTransient
	public Employee getEmployee() {
		return employee;
	}
	@JsonSetter
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	
	

}
