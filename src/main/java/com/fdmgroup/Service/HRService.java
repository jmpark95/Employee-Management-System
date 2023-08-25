package com.fdmgroup.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Employee.CreateEmployeeDTO;
import com.fdmgroup.DTO.Employee.UpdateEmployeeDTO;
import com.fdmgroup.Model.Employee.HR;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.HRRepository;

import jakarta.validation.Valid;

@Service
public class HRService {
	private final HRRepository hrRepository;
	private final FDMRoleRepository fdmRoleRepository;
	private final PasswordEncoder passwordEncoder;

	public HRService(HRRepository hrRepository, FDMRoleRepository fdmRoleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.hrRepository = hrRepository;
		this.fdmRoleRepository = fdmRoleRepository;
		this.passwordEncoder = passwordEncoder;

	}
	
	


	public void deleteEmployee(int employeeId) {
		hrRepository.deleteById(employeeId);;
		
	}

	public HR createHR(CreateEmployeeDTO createEmployeeDTO) {
		HR newHR = new HR();
		
		newHR.setEmail(createEmployeeDTO.getEmail());
		newHR.setFirstName(createEmployeeDTO.getFirstName());	
		newHR.setLastName(createEmployeeDTO.getLastName());
		newHR.setSalary(createEmployeeDTO.getSalary());
		newHR.setStartDate(createEmployeeDTO.getStartDate());
		newHR.setPassword(passwordEncoder.encode(createEmployeeDTO.getEmail()));
		newHR.setRole(fdmRoleRepository.findByRole(createEmployeeDTO.getRole()));

		return hrRepository.save(newHR);
	}

}
