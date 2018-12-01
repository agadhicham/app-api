package org.m2i.metier;


public interface OperationMetier {
	public boolean retirer(String compte,double montant,Long codeEmp);
	public boolean verser(String compte, double montant, Long codeEmp);
	public boolean verment(String compte1,String compte2,double montant,Long codeEmp);
	public PageOperation getOperations (String codeCompte, int page, int size);

}
