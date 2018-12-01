package org.m2i.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.m2i.entities.Compte;
import org.m2i.metier.CompteMetier;
import org.m2i.metier.OperationMetier;
import org.m2i.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@WebService
public class OperationSoapService {

	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public Compte getCompte(@WebParam(name="code") String code) {
		return compteMetier.getCompte(code);
	}
	
	@WebMethod
	public boolean retirer(
			@WebParam(name="compte") String compte,
			@WebParam(name="montant") double montant,
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.retirer(compte, montant, codeEmp);
	}
	//par defaut il prend le meme nom de la methode
	@WebMethod(operationName="verser")
	public boolean verser(
			//aussi par defau il prend le meme nom de l'attribut
			 @WebParam(name="compte") String compte,
			 @WebParam(name="montant") double montant,
			 @WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.verser(compte, montant, codeEmp);
	}
	@WebMethod
	public boolean verment(
			@WebParam(name="compte1") String compte1,
			@WebParam(name="compte2") String compte2,
			@WebParam(name="montant") double montant,
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationMetier.verment(compte1, compte2, montant, codeEmp);
	}

	@WebMethod
	public PageOperation getOperations(
			@WebParam(name="codeCompte") String codeCompte,
			@WebParam(name="page") int page,
			@WebParam(name="size")int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}
	
	
}
