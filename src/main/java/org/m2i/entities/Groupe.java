package org.m2i.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
@Entity
@Table(name="GROUPES")
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long codeGroup;
	private String nomGroupe;
    @ManyToMany(mappedBy="groupes")
	private Collection<Employee> employees;
	public Long getCodeGroup() {
		return codeGroup;
	}
	public void setCodeGroup(Long codeGroup) {
		this.codeGroup = codeGroup;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	
	}
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

}
