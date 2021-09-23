package com.oussey.msgestiondesutilisateurs.services;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.repository.ClientRepository;
import com.oussey.msgestiondesutilisateurs.repository.RoleRepository;
import com.oussey.msgestiondesutilisateurs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientParId(Long id) {
        return clientRepository.findById(id).get();
    }
}
