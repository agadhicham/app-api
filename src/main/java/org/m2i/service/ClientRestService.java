package org.m2i.service;

import java.util.List;

import org.m2i.entities.Client;
import org.m2i.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;
	@RequestMapping(value="/clients", method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}
    @RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientMetier.getAllClients();
	}
	

}
