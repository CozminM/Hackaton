//package com.hackaton.eHealth.repository;
//
//import com.hackaton.eHealth.entities.Client;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface ClientRepository extends JpaRepository<Client, Long> {
//
//    Optional<Client> findByMail(String mail);
//
//    Client getClientsById(Long userId);
//
//    Client getAllById(Long userId);
//
//    boolean existsClientsByName(String username);
//
//    boolean existsClientsByMail(String email);
//
//}
