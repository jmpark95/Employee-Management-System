package com.fdmgroup;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.Model.FDMRole;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Model.Stream.Stream;
import com.fdmgroup.Repository.EClassRepository;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.StreamRepository;
import com.fdmgroup.Repository.Employee.TraineeRepository;
import com.fdmgroup.Repository.Employee.TrainerRepository;

import lombok.AllArgsConstructor;
import lombok.Data;


@Component
public class DataLoader implements ApplicationRunner {
	private final FDMRoleRepository fdmRoleRepository;
	private final StreamRepository streamRepository;
	private final EClassRepository eClassRepository;
	private final TrainerRepository trainerRepository;
	private final TraineeRepository traineeRepository;
	private final PasswordEncoder passwordEncoder;	
	
	public DataLoader(FDMRoleRepository fdmRoleRepository, StreamRepository streamRepository,
			EClassRepository eClassRepository, TrainerRepository trainerRepository, TraineeRepository traineeRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.fdmRoleRepository = fdmRoleRepository;
		this.streamRepository = streamRepository;
		this.eClassRepository = eClassRepository;
		this.trainerRepository = trainerRepository;
		this.traineeRepository = traineeRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void run(ApplicationArguments args) {
		saveFDMRoles();
		saveStreams();
		saveEmployees();
		saveClasses();
//		saveLeaveRequests();
	}
	

	@Data
	@AllArgsConstructor
	public class TraineeData {
		private String email;
		private String firstName;
		private String lastName;
		private int salary;
		private Date startDate;
		private FDMRole role;
		private Stream stream;
	}
	
	@Data
	@AllArgsConstructor
	public class TrainerData {
		private String email;
		private String firstName;
		private String lastName;
		private int salary;
		private Date startDate;
		private FDMRole role;
		private float leaveTaken;
	}

	public void saveFDMRoles() {
		fdmRoleRepository.save(new FDMRole("HR"));
		fdmRoleRepository.save(new FDMRole("Trainee"));
		fdmRoleRepository.save(new FDMRole("Trainer"));
		fdmRoleRepository.save(new FDMRole("Account Manager"));
	}

	public void saveStreams() {
		streamRepository.save(new Stream("Software Development"));
		streamRepository.save(new Stream("Business Intelligence"));
		streamRepository.save(new Stream("Data Engineering"));
		streamRepository.save(new Stream("Cybersecurity"));
		streamRepository.save(new Stream("Cloud Computing"));
		streamRepository.save(new Stream("Technical Analysis"));
	}
	

	
	public void saveEmployees() {
		List<TraineeData> traineeDataList = Arrays.asList(
				new TraineeData("min@fdm.com", "Min", "Park", 60000, Date.valueOf("2022-12-10"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get()),
				new TraineeData("stan@fdm.com", "Stanley", "Chilton", 60000, Date.valueOf("2023-04-20"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get()),
				new TraineeData("matt@fdm.com", "Matthew", "Theseira", 60000, Date.valueOf("2023-03-28"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get()),
				new TraineeData("zhanzhao@fdm.com", "Zhanzhao", "Yang", 60000, Date.valueOf("2023-02-11"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get()),
				new TraineeData("sam@fdm.com", "Sam", "Jermyn", 60000, Date.valueOf("2023-01-13"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get()),
				new TraineeData("cao@fdm.com", "CaoVinh", "Lam", 60000, Date.valueOf("2023-05-07"), fdmRoleRepository.findByRole("Trainee"), streamRepository.findById(1).get())
				);
		
		List<TrainerData> trainerDataList = Arrays.asList(
			    new TrainerData("don@fdm.com", "Don", "Witcombe", 70000, Date.valueOf("2020-08-01"), fdmRoleRepository.findByRole("Trainer"), 10f),
			    new TrainerData("manisha@fdm.com", "Manisha", "Singh", 70000, Date.valueOf("2021-05-01"), fdmRoleRepository.findByRole("Trainer"), 5f),
			    new TrainerData("iffty@fdm.com", "Iffty", "Ahmed", 70000, Date.valueOf("2019-08-21"), fdmRoleRepository.findByRole("Trainer"), 20f)
				);
		
		
		
		for (TraineeData traineeData : traineeDataList) {
		    Trainee trainee = new Trainee();
		    
		    trainee.setEmail(traineeData.getEmail());
		    trainee.setPassword(passwordEncoder.encode("password"));
		    trainee.setFirstName(traineeData.getFirstName());
		    trainee.setLastName(traineeData.getLastName());
		    trainee.setSalary(traineeData.getSalary());
		    trainee.setStartDate(traineeData.getStartDate());
		    trainee.setHasPersonallySetPassword(false);
		    trainee.setStream(traineeData.getStream());
		    trainee.setRole(traineeData.getRole());

		    traineeRepository.save(trainee);
		}
		
		
		
		for (TrainerData trainerData : trainerDataList) {
		    Trainer trainer = new Trainer();
		    
		    trainer.setEmail(trainerData.getEmail());
		    trainer.setPassword(passwordEncoder.encode("password"));
		    trainer.setFirstName(trainerData.getFirstName());
		    trainer.setLastName(trainerData.getLastName());
		    trainer.setSalary(trainerData.getSalary());
		    trainer.setStartDate(trainerData.getStartDate());
		    trainer.setHasPersonallySetPassword(false);
		    trainer.setRole(trainerData.getRole());
		    trainer.setLeaveTaken(trainerData.getLeaveTaken());;

		    trainerRepository.save(trainer);
		}			
	}
	
	
	public void saveClasses() {
		EClass class1 = new EClass();
		class1.setStream(streamRepository.findByName("Software Development"));
		class1.setStartDate(Date.valueOf("2023-05-01"));
		class1.setEndDate(Date.valueOf("2023-08-01"));
		class1.setTrainers(trainerRepository.findAll());
		
		EClass class2 = new EClass();
		class2.setStream(streamRepository.findByName("Cybersecurity"));
		class2.setStartDate(Date.valueOf("2023-06-01"));
		class2.setEndDate(Date.valueOf("2023-09-01"));
		class2.setTrainers(trainerRepository.findAll());

		eClassRepository.save(class1);
	    eClassRepository.save(class2);
	}




//	public void saveLeaveRequests() {
//		User userForLeaveRequest = userRepository.findAll().get(0);
//		LeaveRequest leaveRequest = new LeaveRequest();
//		leaveRequest.setSender(userForLeaveRequest);
//
//		leaveRequestRepository.save(leaveRequest);
//	}
}