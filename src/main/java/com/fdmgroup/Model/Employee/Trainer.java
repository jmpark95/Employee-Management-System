package com.fdmgroup.Model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdmgroup.Model.FDMRole;
import com.fdmgroup.Model.Stream.EClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Trainer")
@Data
@NoArgsConstructor
public class Trainer extends Employee {
	@ManyToMany(mappedBy = "trainers", fetch = FetchType.EAGER)
    @JsonBackReference
	private List<EClass> classes;
	
	@ManyToOne
	@JoinColumn(name = "FK_ROLE")
	private FDMRole role;

}
