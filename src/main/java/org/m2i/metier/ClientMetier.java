package org.m2i.metier;

import java.util.List;

import org.m2i.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client client);
	public List<Client> getAllClients();

}
