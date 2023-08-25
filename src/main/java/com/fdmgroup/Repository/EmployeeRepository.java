package com.fdmgroup.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdmgroup.Model.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
