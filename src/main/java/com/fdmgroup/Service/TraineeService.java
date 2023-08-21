package com.fdmgroup.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Repository.TraineeRepository;

@Service
public class TraineeService {
	private final TraineeRepository traineeRepository;

	public TraineeService(TraineeRepository traineeRepository) {
		super();
		this.traineeRepository = traineeRepository;
	}



	public List<Trainee> getAllTraineesByStreamId(int streamId) {
		List<Trainee> allTrainees = traineeRepository.findAllByStreamId(streamId);
		List<Trainee> allTraineesWithNoClass = new ArrayList<>(); //trainees that are already part of a class will not be returned, as a trainee can only be in 1 class/cohort
		
		for (Trainee trainee : allTrainees) {
			if (trainee.getEclass() == null) {
				allTraineesWithNoClass.add(trainee);
			}
		}
		
		return allTraineesWithNoClass;
	}

}
