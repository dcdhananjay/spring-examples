package com.example.JPAExample.service;

import com.example.JPAExample.entity.Employee;
import com.example.JPAExample.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Employee saveUser(Employee user) {
        return repo.save(user);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public Employee findOne(int id) {
        return repo.findById(id).orElse(null);
    }

    public void removeUser(int id) {
        repo.deleteById(id);
    }
}
