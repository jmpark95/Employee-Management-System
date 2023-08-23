package com.fdmgroup.Model.Stream;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EClass {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "FK_STREAM")
	private Stream stream;
	
	@Column(nullable = false)
	private Date startDate;
	
	@Column(nullable = false)
	private Date endDate;
	
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "CLASS_TRAINER",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id"))
    @JsonManagedReference
	private List<Trainer> trainers = new ArrayList<>();
	
	@OneToMany //(mappedBy = "eclass", fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_CLASS")
    @JsonManagedReference
	private List<Trainee> trainees = new ArrayList<>();
	

	
	
	
	
//	public void addTrainee(Trainee trainee) {
//			this.trainees.add(trainee);
//			trainee.setEclass(this);
//	}
	
}

