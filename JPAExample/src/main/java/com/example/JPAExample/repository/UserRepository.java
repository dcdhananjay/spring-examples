package com.example.JPAExample.repository;

import com.example.JPAExample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Integer> {

}
