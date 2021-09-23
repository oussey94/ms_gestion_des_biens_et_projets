package com.oussey.msgestiondesutilisateurs.controllers;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.oussey.msgestiondesutilisateurs.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientRestController{
	@Autowired
	ClientService clientService;

    @GetMapping
	public List<Client> getAllClient(){
		return clientService.getAllClient();
	}

	@GetMapping("/{id}")
	public Client getClient(@PathVariable("id") Long id) {
    	return clientService.getClientParId(id);
	}

	@PostMapping
	public Client addClient(@RequestBody Client client) {
    	return clientService.addNewClient(client);
	}
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
    	clientService.deleteClient(id);
	}

	@PutMapping("/{id}")
	public Client updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
    	Client c=clientService.getClientParId(id);
    	c.setPrenom(client.getPrenom());
    	c.setNom(client.getNom());
    	c.setAge(client.getAge());
    	c.setEmail(client.getEmail());
    	c.setPassword(client.getPassword());
    	c.setTelephone1(client.getTelephone1());
    	c.setTelephone2(client.getTelephone2());
    	c.setAdresse(client.getAdresse());
    	c.setVille(client.getVille());
    	c.setUserName(client.getUserName());

    	return clientService.updateClient(client);
	}
}
