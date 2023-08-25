package com.fdmgroup.Model.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {
	public static Employee createEmployee(String role) {
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
