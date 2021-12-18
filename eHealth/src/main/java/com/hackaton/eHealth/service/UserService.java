//package com.hackaton.eHealth.service;
//
//import com.hackaton.eHealth.entities.Client;
//import com.hackaton.eHealth.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    private ClientRepository clientRepository;
//
//    @Autowired
//    public UserService(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }
//
//    public List<Client> getAllUsers() {
//        return clientRepository.findAll();
//    }
//
//    public void addUser(Client client) {
//        clientRepository.save(client);
//    }
//}
