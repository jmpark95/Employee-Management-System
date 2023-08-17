package com.fdmgroup.Model.User;

import org.springframework.stereotype.Component;

@Component
public class UserFactory {
	public User createUser(String role) {
		if (role.equals("Trainee")) {
			return new Trainee();
		} else if (role.equals("Trainer")) {
			return new Trainer();
		} else if (role.equals("Account Manager")) {
			return new AccountManager();
		} else {
			return new HR();
		}
	}
}
