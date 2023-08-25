package com.fdmgroup.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Employee.CreateEmployeeDTO;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Repository.EmployeeRepository;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.TraineeRepository;

@Service
public class TraineeService {
	private static final Logger logger = LoggerFactory.getLogger(TraineeService.class);
	private final TraineeRepository traineeRepository;
	private final FDMRoleRepository fdmRoleRepository;
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;

	public TraineeService(TraineeRepository traineeRepository, FDMRoleRepository fdmRoleRepository,
			EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
		super();
		this.traineeRepository = traineeRepository;
		this.fdmRoleRepository = fdmRoleRepository;
		this.employeeRepository = employeeRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public List<Trainee> getAllTraineesWithoutClassByStreamId(int streamId) {
		List<Trainee> allTrainees = traineeRepository.findAllByStreamId(streamId);
		List<Trainee> allTraineesWithNoClass = new ArrayList<>(); //trainees that are already part of a class will not be returned, as a trainee can only be in 1 class/cohort
		
		for (Trainee trainee : allTrainees) {
			if (trainee.getEclass() == null) {
				allTraineesWithNoClass.add(trainee);
			}
		}

		return allTraineesWithNoClass;
	}


	public Trainee createTrainee(CreateEmployeeDTO createEmployeeDTO) {
		Trainee newTrainee = new Trainee();
		
		newTrainee.setEmail(createEmployeeDTO.getEmail());
		newTrainee.setFirstName(createEmployeeDTO.getFirstName());	
		newTrainee.setLastName(createEmployeeDTO.getLastName());
		newTrainee.setSalary(createEmployeeDTO.getSalary());
		newTrainee.setStartDate(createEmployeeDTO.getStartDate());
		newTrainee.setPassword(passwordEncoder.encode(createEmployeeDTO.getEmail()));
		newTrainee.setRole(fdmRoleRepository.findByRole(createEmployeeDTO.getRole()));
		
		return traineeRepository.save(newTrainee);
	}



}
