package com.oussey.msgestiondesutilisateurs.services;

import com.oussey.msgestiondesutilisateurs.entities.Client;

import java.util.List;

public interface ClientService {
	Client addNewClient(Client client);
	Client updateClient(Client client);
	void deleteClient(Long id);
	List<Client> getAllClient();
	Client getClientParId(Long id);

}
