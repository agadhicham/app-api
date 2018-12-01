package org.m2i.rmi;

import java.rmi.RemoteException;

import org.m2i.entities.Compte;
import org.m2i.metier.CompteMetier;
import org.m2i.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myrmiservice")
public class BanueRmiImplemantation implements BanqueRmiRemote{
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;
	

	@Override
	public Compte saveCompte(Compte compte) throws RemoteException {
		return compteMetier.saveCompte(compte);
	}

	@Override
	public Compte getCompte(String code) throws RemoteException {
		return compteMetier.getCompte(code);
	}

	@Override
	public boolean retirer(String compte, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.retirer(compte, montant, codeEmp);
	}

	@Override
	public boolean verser(String compte, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.verser(compte, montant, codeEmp);
	}

	@Override
	public boolean verment(String compte1, String compte2, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.verment(compte1, compte2, montant, codeEmp);
	}

}
