package com.fdmgroup.Repository.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByEmail(String email);
	
}
