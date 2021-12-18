//package com.hackaton.eHealth.security;
//
//import com.hackaton.eHealth.entities.Client;
//import com.hackaton.eHealth.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Collectors;
//
//@Component
//public class CustomClientDetailsService implements UserDetailsService{
//
//    private final ClientRepository users;
//
//    @Autowired
//    public CustomClientDetailsService(ClientRepository users) {
//        this.users = users;
//    }
//
//    /**
//     * Loads the user from the DB and converts it to Spring Security's internal User o object
//     */
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Client client = users.findByMail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Email: " + email + " not found"));
//
//        return new User(client.getMail(), client.getPassword(), client.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//    }
//}
//
