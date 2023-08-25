package com.fdmgroup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.Employee.AccountManager;

public interface AccountManagerRepository extends JpaRepository<AccountManager, Integer>{

}
