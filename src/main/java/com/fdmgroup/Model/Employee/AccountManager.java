package com.fdmgroup.Model.Employee;

import com.fdmgroup.Model.FDMRole;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("AccountManager")
@Data
@NoArgsConstructor
public class AccountManager extends Employee {
	@ManyToOne
	@JoinColumn(name = "FK_ROLE")
	private FDMRole role;
}
