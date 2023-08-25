package com.fdmgroup.Model.Employee;

import com.fdmgroup.Model.FDMRole;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("HR")
@Data
@NoArgsConstructor
public class HR extends Employee {
	@ManyToOne
	@JoinColumn(name = "FK_ROLE")
	private FDMRole role;
}


