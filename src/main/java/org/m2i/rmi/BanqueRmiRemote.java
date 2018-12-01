package org.m2i.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.m2i.entities.Compte;

public interface BanqueRmiRemote extends Remote {
	
	public Compte saveCompte(Compte compte) throws RemoteException;
	public Compte getCompte(String code) throws RemoteException;
	public boolean retirer(String compte,double montant,Long codeEmp) throws RemoteException;
	public boolean verser(String compte, double montant, Long codeEmp) throws RemoteException;
	public boolean verment(String compte1,String compte2,double montant,Long codeEmp) throws RemoteException;
}
