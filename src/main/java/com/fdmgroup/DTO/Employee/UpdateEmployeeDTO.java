package com.fdmgroup.DTO.Employee;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEmployeeDTO {
	@Column(unique = true)
	@NotNull
	private int id;
	
	@Column(unique = true)
	@Size(min = 9)
	@Email
	@NotNull
	private String email;

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	
	@NotNull
	private int salary;
	
	@NotNull
	private Date startDate;
}

