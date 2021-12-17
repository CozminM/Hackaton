package com.hackaton.eHealth.controller;

import com.hackaton.eHealth.entities.User;
import com.hackaton.eHealth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/client")
public class UserController {

    private final UserRepository users;


    @Autowired
    public UserController (UserRepository users) {
        this.users = users;
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(users.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/check/username/{username}")
    public ResponseEntity<Object> isUserNameAlreadyRegistered(@PathVariable String username ) throws UnknownHostException {
//        var ip = InetAddress.getLocalHost();
//        var hostname = ip.getHostName();
//        var g = InetAddress.getByName("localhost");
//        var s = serverAddress;
        if (users.existsUserByName(username))
//            return new ResponseEntity<>("Already registered", HttpStatus.ALREADY_REPORTED);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>("Accepted", HttpStatus.OK);
    }

    @GetMapping("/check/email/{email}")
    public ResponseEntity<Object> isEmailAlreadyRegistered(@PathVariable String email ) {
        if (users.existsUserByMail(email))
            return new ResponseEntity<>("Already registered", HttpStatus.ALREADY_REPORTED);

        return new ResponseEntity<>("Accepted", HttpStatus.OK);
    }
}

