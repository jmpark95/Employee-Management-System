package com.fdmgroup.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Employee.CreateEmployeeDTO;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Repository.EClassRepository;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.TrainerRepository;

@Service
public class TrainerService {
	private static final Logger logger = LoggerFactory.getLogger(TrainerService.class);
	private final TrainerRepository trainerRepository;
	private final EClassRepository eClassRepository;
	private final FDMRoleRepository fdmRoleRepository;
	private final PasswordEncoder passwordEncoder;

	public TrainerService(TrainerRepository trainerRepository, EClassRepository eClassRepository,
			FDMRoleRepository fdmRoleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.trainerRepository = trainerRepository;
		this.eClassRepository = eClassRepository;
		this.fdmRoleRepository = fdmRoleRepository;
		this.passwordEncoder = passwordEncoder;

	}






	public void deleteEmployee(int employeeId) {
		Trainer trainer = trainerRepository.findById(employeeId).get();
		List<EClass> allClasses = trainer.getClasses();
		
		for (EClass eClass : allClasses) {
			eClass.removeTrainer(trainer);
		}
		
		eClassRepository.saveAll(allClasses); //cleans up all the foreign key constraints before finally being able to delete the trainer himself
		trainerRepository.deleteById(employeeId); 
	}

	public Trainer createTrainer(CreateEmployeeDTO createEmployeeDTO) {
		Trainer newTrainer = new Trainer();
		
		newTrainer.setEmail(createEmployeeDTO.getEmail());
		newTrainer.setFirstName(createEmployeeDTO.getFirstName());	
		newTrainer.setLastName(createEmployeeDTO.getLastName());
		newTrainer.setSalary(createEmployeeDTO.getSalary());
		newTrainer.setStartDate(createEmployeeDTO.getStartDate());
		newTrainer.setPassword(passwordEncoder.encode(createEmployeeDTO.getEmail()));
		newTrainer.setRole(fdmRoleRepository.findByRole(createEmployeeDTO.getRole()));
		
		return trainerRepository.save(newTrainer);
	}

}
