package com.fdmgroup.Model.Employee;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fdmgroup.Model.Stream.EClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Trainer")
@Data
@NoArgsConstructor
public class Trainer extends Employee {
//	@Column
//	@ManyToMany
//	@JoinTable(
//            name = "TRAINER_STREAM",
//            joinColumns = @JoinColumn(name = "trainer_id"),
//            inverseJoinColumns = @JoinColumn(name = "stream_id"))

	@ManyToMany(mappedBy = "trainers")
    @JsonBackReference
	private List<EClass> classes;
}
