package org.m2i.service;

import org.m2i.metier.OperationImplementation;
import org.m2i.metier.OperationMetier;
import org.m2i.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {

	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value="/operations", method=RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codeCompte, @RequestParam int page,@RequestParam int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}

	@RequestMapping(value="/retrait", method=RequestMethod.PUT)
	public boolean retirer(
			@RequestParam String compte, 
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return operationMetier.retirer(compte, montant, codeEmp);
	}

	@RequestMapping(name="/versement" ,method=RequestMethod.PUT)
	public boolean verser(@RequestParam String compte,@RequestParam double montant, @RequestParam Long codeEmp) {
		return operationMetier.verser(compte, montant, codeEmp);
	}

	@RequestMapping(value="/verment",method=RequestMethod.PUT)
	public boolean verment(@RequestParam String compte1, String compte2,@RequestParam double montant,@RequestParam Long codeEmp) {
		return operationMetier.verment(compte1, compte2, montant, codeEmp);
	}
	
	
}
