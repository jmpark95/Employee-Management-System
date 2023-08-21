package com.fdmgroup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
