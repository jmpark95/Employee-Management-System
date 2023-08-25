package com.fdmgroup.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Employee.CreateEmployeeDTO;
import com.fdmgroup.Model.Employee.AccountManager;
import com.fdmgroup.Repository.AccountManagerRepository;
import com.fdmgroup.Repository.FDMRoleRepository;

@Service
public class AccountManagerService {
	private final AccountManagerRepository accountManagerRepository;
	private final FDMRoleRepository fdmRoleRepository;
	private final PasswordEncoder passwordEncoder;

	public AccountManagerService(AccountManagerRepository accountManagerRepository,
			FDMRoleRepository fdmRoleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.accountManagerRepository = accountManagerRepository;
		this.fdmRoleRepository = fdmRoleRepository;
		this.passwordEncoder = passwordEncoder;
	}



	public void deleteEmployee(int employeeId) {
		accountManagerRepository.deleteById(employeeId);	
	}
	

	public AccountManager createAccountManager(CreateEmployeeDTO createEmployeeDTO) {
		AccountManager newAccountManager = new AccountManager();
		
		newAccountManager.setEmail(createEmployeeDTO.getEmail());
		newAccountManager.setFirstName(createEmployeeDTO.getFirstName());	
		newAccountManager.setLastName(createEmployeeDTO.getLastName());
		newAccountManager.setSalary(createEmployeeDTO.getSalary());
		newAccountManager.setStartDate(createEmployeeDTO.getStartDate());
		newAccountManager.setPassword(passwordEncoder.encode(createEmployeeDTO.getEmail()));
		newAccountManager.setRole(fdmRoleRepository.findByRole(createEmployeeDTO.getRole()));

		return accountManagerRepository.save(newAccountManager);
	}





}
