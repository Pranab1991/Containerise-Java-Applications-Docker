package com.example.dockerTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class DockerTestcontroller {
    
    private UserRepository userRepo;
    public DockerTestcontroller(UserRepository userRepo){
        this.userRepo=userRepo;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
       return new ResponseEntity<>(userRepo.findById(id).get(), HttpStatus.OK);
    }
}