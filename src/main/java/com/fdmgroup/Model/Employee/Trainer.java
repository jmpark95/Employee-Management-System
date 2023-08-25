package com.fdmgroup.Model.Employee;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdmgroup.Model.FDMRole;
import com.fdmgroup.Model.Stream.EClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("Trainer")
@Data
@NoArgsConstructor
public class Trainer extends Employee {
	@ManyToMany(mappedBy = "trainers")
    @JsonBackReference
	private List<EClass> classes;
	
	@ManyToOne
	@JoinColumn(name = "FK_ROLE")
	private FDMRole role;
}
