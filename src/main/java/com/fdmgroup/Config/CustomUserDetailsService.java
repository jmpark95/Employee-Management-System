package com.fdmgroup.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fdmgroup.Model.Employee.Employee;
import com.fdmgroup.Repository.Employee.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	EmployeeRepository employeeRepository;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return employeeRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
	}
}
