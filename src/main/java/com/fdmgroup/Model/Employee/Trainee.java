package com.fdmgroup.Model.Employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdmgroup.Model.FDMRole;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Model.Stream.Stream;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Trainee")
@Data
@NoArgsConstructor
public class Trainee extends Employee {
	@ManyToOne
	@JoinColumn(name = "FK_STREAM")
    @JsonBackReference
	private Stream stream;
	
	@ManyToOne
	@JoinColumn(name="FK_CLASS")
    @JsonBackReference
	private EClass eclass;
	
	@ManyToOne
	@JoinColumn(name = "FK_ROLE")
	private FDMRole role;
}