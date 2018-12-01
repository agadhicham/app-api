package org.m2i.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.m2i.dao.CompteRepository;
import org.m2i.dao.EmployeeRepository;
import org.m2i.dao.OperationRepository;
import org.m2i.entities.Compte;
import org.m2i.entities.Employee;
import org.m2i.entities.Operation;
import org.m2i.entities.Retrait;
import org.m2i.entities.Versment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OperationImplementation implements OperationMetier{

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private OperationRepository operationRepository; 
	@Override
	@org.springframework.transaction.annotation.Transactional
	public boolean retirer(String compte, double montant, Long codeEmp) {
		Compte compte2=compteRepository.getOne(compte);
		if (compte2.getSolde()<montant) throw new RuntimeException("solde insufisant");
        Employee employee=employeeRepository.getOne(codeEmp);
        Operation operation=new Retrait();
        operation.setDateOperation(new Date());
        operation.setMontant(montant);
        operation.setCompte(compte2);
        operation.setEmployee(employee);
        operationRepository.save(operation);
        compte2.setSolde(compte2.getSolde()-montant);
		return true;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public boolean verser(String compte, double montant, Long codeEmp) {
		Compte compte2=compteRepository.getOne(compte);
		Employee employee=employeeRepository.getOne(codeEmp);
		Operation operation=new Versment();
		operation.setDateOperation(new Date());
		operation.setMontant(montant);
        operation.setCompte(compte2);
        operation.setEmployee(employee);
        operationRepository.save(operation);  
        compte2.setSolde(compte2.getSolde()+montant);
		return true;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public boolean verment(String compte1, String compte2, double montant, Long codeEmp) {
        retirer(compte1, montant, codeEmp);
        verser(compte2, montant, codeEmp);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public PageOperation getOperations(String codeCompte, int page, int size) {
		Page<Operation> ops=operationRepository.getOperations(codeCompte, new PageRequest(page, size));
		PageOperation pop=new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalePages(ops.getTotalPages());
		pop.setTotaleOperations((int)ops.getTotalElements());
		
		return pop;
	}

}
