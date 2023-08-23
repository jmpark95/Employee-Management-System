package com.fdmgroup;

import java.sql.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.Model.FDMRole;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Model.Stream.Stream;
import com.fdmgroup.Repository.EClassRepository;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.StreamRepository;
import com.fdmgroup.Repository.TraineeRepository;
import com.fdmgroup.Repository.TrainerRepository;


@Component
public class DataLoader implements ApplicationRunner {
	private final FDMRoleRepository fdmRoleRepository;
	private final StreamRepository streamRepository;
	private final EClassRepository eClassRepository;
	private final TrainerRepository trainerRepository;
	private final TraineeRepository traineeRepository;
	public DataLoader(FDMRoleRepository fdmRoleRepository, StreamRepository streamRepository,
			EClassRepository eClassRepository, TrainerRepository trainerRepository,
			TraineeRepository traineeRepository) {
		super();
		this.fdmRoleRepository = fdmRoleRepository;
		this.streamRepository = streamRepository;
		this.eClassRepository = eClassRepository;
		this.trainerRepository = trainerRepository;
		this.traineeRepository = traineeRepository;
	}

	public void run(ApplicationArguments args) {
		saveFDMRoles();
		saveStreams();
		saveEmployees();
		saveClasses();
		
		Trainee trainee = traineeRepository.findById(1).get();
		Trainee trainee5 = traineeRepository.findById(5).get();
		EClass eClass = eClassRepository.findById(1).get();
		
		trainee.setEclass(eClass);
		trainee5.setEclass(eClass);
		
		traineeRepository.save(trainee);
		traineeRepository.save(trainee5);

////		saveLeaveRequests();
	}

	public void saveFDMRoles() {
		fdmRoleRepository.save(new FDMRole("HR"));
		fdmRoleRepository.save(new FDMRole("Trainee"));
		fdmRoleRepository.save(new FDMRole("Trainer"));
		fdmRoleRepository.save(new FDMRole("Account Manager"));
	}

	public void saveStreams() {
		streamRepository.save(new Stream("Java Development"));
		streamRepository.save(new Stream("Business Intelligence"));
		streamRepository.save(new Stream("Data engineering"));
		streamRepository.save(new Stream("Cybersecurity"));
	}
	
	public void saveEmployees() {
		Trainee trainee1 = new Trainee();
		trainee1.setEmail("min@fdm.com");
		trainee1.setPassword("password");
		trainee1.setFirstName("Min");
		trainee1.setLastName("Park");
		trainee1.setSalary(60000);
		trainee1.setHasPersonallySetPassword(false);
		trainee1.setStream(streamRepository.findById(1).get());
	
		
		Trainee trainee2 = new Trainee();
		trainee2.setEmail("min2@fdm.com");
		trainee2.setPassword("password");
		trainee2.setFirstName("Min2");
		trainee2.setLastName("Park2");
		trainee2.setSalary(60000);
		trainee2.setHasPersonallySetPassword(false);
		trainee2.setStream(streamRepository.findById(2).get());
		
		Trainee trainee3 = new Trainee();
		trainee3.setEmail("min3@fdm.com");
		trainee3.setPassword("password");
		trainee3.setFirstName("Min3");
		trainee3.setLastName("Park3");
		trainee3.setSalary(60000);
		trainee3.setHasPersonallySetPassword(false);
		trainee3.setStream(streamRepository.findById(3).get());
		
		Trainee trainee4 = new Trainee();
		trainee4.setEmail("min4@fdm.com");
		trainee4.setPassword("password");
		trainee4.setFirstName("Min4");
		trainee4.setLastName("Park4");
		trainee4.setSalary(60000);
		trainee4.setHasPersonallySetPassword(false);
		trainee4.setStream(streamRepository.findById(4).get());
		
		Trainee trainee5 = new Trainee();
		trainee5.setEmail("min5@fdm.com");
		trainee5.setPassword("password");
		trainee5.setFirstName("Min5");
		trainee5.setLastName("Park5");
		trainee5.setSalary(60000);
		trainee5.setHasPersonallySetPassword(false);
		trainee5.setStream(streamRepository.findById(1).get());

		
		Trainer trainer1 = new Trainer();
		trainer1.setEmail("don@fdm.com");
		trainer1.setPassword("password");
		trainer1.setFirstName("Don");
		trainer1.setLastName("Witcombe");
		trainer1.setSalary(60000);
		trainer1.setHasPersonallySetPassword(false);
		
		Trainer trainer2 = new Trainer();
		trainer2.setEmail("don2@fdm.com");
		trainer2.setPassword("password");
		trainer2.setFirstName("Don2");
		trainer2.setLastName("Witcombe2");
		trainer2.setSalary(60000);
		trainer2.setHasPersonallySetPassword(false);

		traineeRepository.save(trainee1);
		traineeRepository.save(trainee2);
		traineeRepository.save(trainee3);
		traineeRepository.save(trainee4);
		traineeRepository.save(trainee5);
		trainerRepository.save(trainer1);	
		trainerRepository.save(trainer2);
	}
	
	public void saveClasses() {
		EClass class1 = new EClass();
		class1.setStream(streamRepository.findByName("Java Development"));
		class1.setStartDate(Date.valueOf("2023-05-01"));
		class1.setEndDate(Date.valueOf("2023-08-01"));
		class1.setTrainers(trainerRepository.findAll());
		//class1.addTrainees(traineeRepository.findAll());
		
		EClass class2 = new EClass();
		class2.setStream(streamRepository.findByName("Cybersecurity"));
		class2.setStartDate(Date.valueOf("2023-06-01"));
		class2.setEndDate(Date.valueOf("2023-09-01"));
		class2.setTrainers(trainerRepository.findAll());

		eClassRepository.save(class1);
	    eClassRepository.save(class2);

		
		//traineeRepository.findAll().get(0).setEclass(class1);		
	}




//	public void saveLeaveRequests() {
//		User userForLeaveRequest = userRepository.findAll().get(0);
//		LeaveRequest leaveRequest = new LeaveRequest();
//		leaveRequest.setSender(userForLeaveRequest);
//
//		leaveRequestRepository.save(leaveRequest);
//	}
}