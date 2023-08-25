package com.fdmgroup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.Employee.HR;

public interface HRRepository extends JpaRepository<HR, Integer>{

}
