package org.m2i.metier;

import java.io.Serializable;
import java.util.List;

import org.m2i.entities.Operation;

public class PageOperation implements Serializable{
	private List<Operation> operations;
	private int page;
	private int nombreOperations;
	private int totalePages;
	private int totaleOperations;
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public int getTotalePages() {
		return totalePages;
	}
	public void setTotalePages(int totalePages) {
		this.totalePages = totalePages;
	}
	public int getTotaleOperations() {
		return totaleOperations;
	}
	public void setTotaleOperations(int totaleOperations) {
		this.totaleOperations = totaleOperations;
	}
	

}
