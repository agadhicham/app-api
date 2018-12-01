package org.m2i.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity

public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long codeEmploye;
	private String nomEmploye;
	//est une relation reflixive
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Employee employeSup;
	@ManyToMany
	@JoinTable(name="EMPL_GR")
	private Collection<Groupe> groupes;
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	//pour ne pas afficher l'objet de jointure en format json
	//mais le probleme c'est lors de lajout il genere un null au corps de la requette http post
	//pour cela il faut ajouter @jsonsetter avant seter de l'objet quia une relation 
	@JsonIgnore
	public Employee getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employee employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
    @JsonSetter
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}

}
