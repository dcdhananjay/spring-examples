package com.example.JPAExample.controller;

import com.example.JPAExample.entity.Employee;
import com.example.JPAExample.service.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody Employee user) {
        Employee sevedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping(path = "/retrieve/{id}")
    public Employee retrieveUser(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.removeUser(id);
    }
}
