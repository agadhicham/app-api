package org.m2i.metier;

import java.util.List;

import org.m2i.dao.ClientRepository;
import org.m2i.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//cad que ce classe metier il s'agit d'un composant spring 
@Service
public class ClientImplementation implements ClientMetier{
    @Autowired
	private ClientRepository clientRepository; 
	@Override
	public Client saveClient(Client client) {
		
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

}
