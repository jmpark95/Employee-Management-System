package com.fdmgroup.DTO.Employee;

import lombok.Data;

@Data
public class UpdatePasswordDTO {
	private int employeeID;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
}
