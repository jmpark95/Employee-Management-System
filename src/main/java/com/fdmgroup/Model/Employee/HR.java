package com.fdmgroup.Model.Employee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("HR")
@Data
@NoArgsConstructor
public class HR extends Employee {
	
}


