package com.fdmgroup.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.FDMRole;

public interface FDMRoleRepository extends JpaRepository<FDMRole, Integer>{
	//@Query("SELECT r from Role r WHERE r.role = :role")
	FDMRole findByRole(String role);
}
