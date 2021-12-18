//package com.hackaton.eHealth.controller;
//
//import com.hackaton.eHealth.entities.Client;
//import com.hackaton.eHealth.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.UnknownHostException;
//
//@RestController
//@CrossOrigin("http://localhost:3000/")
//@RequestMapping("/api/client")
//public class UserController {
//
//    private final ClientRepository users;
//
//
//    @Autowired
//    public UserController (ClientRepository users) {
//        this.users = users;
//    }
//
    @CrossOrigin("http://localhost:3000/")
    @GetMapping("/get/{userId}")
    public ResponseEntity<Client> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(users.getAllById(userId), HttpStatus.OK);
    }
//
//    @GetMapping("/check/username/{username}")
//    public ResponseEntity<Object> isUserNameAlreadyRegistered(@PathVariable String username ) throws UnknownHostException {
////        var ip = InetAddress.getLocalHost();
////        var hostname = ip.getHostName();
////        var g = InetAddress.getByName("localhost");
////        var s = serverAddress;
//        if (users.existsClientsByName(username))
////            return new ResponseEntity<>("Already registered", HttpStatus.ALREADY_REPORTED);
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//
//        return new ResponseEntity<>("Accepted", HttpStatus.OK);
//    }
//
//    @GetMapping("/check/email/{email}")
//    public ResponseEntity<Object> isEmailAlreadyRegistered(@PathVariable String email ) {
//        if (users.existsClientsByMail(email))
//            return new ResponseEntity<>("Already registered", HttpStatus.ALREADY_REPORTED);
//
//        return new ResponseEntity<>("Accepted", HttpStatus.OK);
//    }
//
//    @CrossOrigin("http://localhost:3000/")
//    @PutMapping("/update/user")
//    public ResponseEntity<Object> updateUser(@RequestBody Client client) {
//        users.save(client);
//        return new ResponseEntity<>("Updated", HttpStatus.OK);
//    }
//}
//
