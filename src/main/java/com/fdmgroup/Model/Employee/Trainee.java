package com.fdmgroup.Model.Employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Model.Stream.Stream;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Trainee")
@Getter
@Setter
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
}