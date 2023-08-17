package com.fdmgroup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fdmgroup.Model.UserRole;
import com.fdmgroup.Repository.UserRoleRepository;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRoleRepository userRoleRepository;

    public DataLoader(UserRoleRepository userRoleRepository) {
		super();
		this.userRoleRepository = userRoleRepository;
	}


	public void run(ApplicationArguments args) {
        userRoleRepository.save(new UserRole("HR"));
        userRoleRepository.save(new UserRole("Trainee"));
        userRoleRepository.save(new UserRole("Trainer"));
        userRoleRepository.save(new UserRole("Account Manager"));
    }
}