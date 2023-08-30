package com.fdmgroup.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.DTO.Employee.CreateEmployeeDTO;
import com.fdmgroup.DTO.Employee.SetPasswordDTO;
import com.fdmgroup.DTO.Employee.UpdateEmployeeDTO;
import com.fdmgroup.DTO.Employee.UpdatePasswordDTO;
import com.fdmgroup.Model.FDMRole;
import com.fdmgroup.Model.Employee.AccountManager;
import com.fdmgroup.Model.Employee.Employee;
import com.fdmgroup.Model.Employee.HR;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.Employee.EmployeeRepository;
import com.fdmgroup.Repository.Employee.TraineeRepository;
import com.fdmgroup.Repository.Employee.TrainerRepository;
import com.fdmgroup.Service.AccountManagerService;
import com.fdmgroup.Service.EmployeeService;
import com.fdmgroup.Service.HRService;
import com.fdmgroup.Service.TraineeService;
import com.fdmgroup.Service.TrainerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private final EmployeeRepository employeeRepository;
	private final TrainerRepository trainerRepository;
	private final TraineeRepository traineeRepository;
	private final TrainerService trainerService;
	private final TraineeService traineeService;
	private final AccountManagerService accountManagerService;
	private final HRService hrService;
	private final EmployeeService employeeService;
	private final FDMRoleRepository fdmRoleRepository;

	public EmployeeController(EmployeeRepository employeeRepository, TrainerRepository trainerRepository,
			TraineeRepository traineeRepository, TrainerService trainerService, TraineeService traineeService,
			AccountManagerService accountManagerService, HRService hrService, EmployeeService employeeService,
			FDMRoleRepository fdmRoleRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.trainerRepository = trainerRepository;
		this.traineeRepository = traineeRepository;
		this.trainerService = trainerService;
		this.traineeService = traineeService;
		this.accountManagerService = accountManagerService;
		this.hrService = hrService;
		this.employeeService = employeeService;
		this.fdmRoleRepository = fdmRoleRepository;
	}

	@GetMapping("{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();

		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
	}

	@GetMapping("/trainers")
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		List<Trainer> allTrainers = trainerRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(allTrainers);
	}

	@GetMapping("/trainees")
	public ResponseEntity<List<Trainee>> getAllTrainees() {
		List<Trainee> allTrainees = traineeRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(allTrainees);
	}

	// Get all trainees(in a specific stream) that are NOT currently registered to a
	// class
	@GetMapping("/trainees-by-stream")
	public ResponseEntity<List<Trainee>> getAllTraineesWithoutClassByStreamId(@RequestParam("streamId") int streamId) {
		List<Trainee> allTrainees = traineeService.getAllTraineesWithoutClassByStreamId(streamId);

		return ResponseEntity.status(HttpStatus.OK).body(allTrainees);

	}

	// Get all trainees(in a specific stream) regardless of class
	@GetMapping("/all-trainees-by-stream")
	public ResponseEntity<List<Trainee>> getAllTraineesByStreamId(@RequestParam("streamId") int streamId) {
		List<Trainee> allTrainees = traineeRepository.findAllByStreamId(streamId);

		return ResponseEntity.status(HttpStatus.OK).body(allTrainees);
	}

	@GetMapping("/roles")
	public ResponseEntity<List<FDMRole>> getAllRoles() {
		List<FDMRole> allRoles = fdmRoleRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(allRoles);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid UpdateEmployeeDTO updateEmployeeDTO) {
		Employee updatedEmployee = employeeService.updateEmployee(updateEmployeeDTO);

		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
	}

	@DeleteMapping("/{employeeId}/{role}")
	public ResponseEntity deleteEmployee(@PathVariable int employeeId, @PathVariable String role) {
		if (role.equals("Trainee")) {
			traineeRepository.deleteById(employeeId);
		} else if (role.equals("Trainer")) {
			trainerService.deleteEmployee(employeeId);
		} else if (role.equals("Account Manager")) {
			accountManagerService.deleteEmployee(employeeId);
		} else {
			hrService.deleteEmployee(employeeId);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid CreateEmployeeDTO createEmployeeDTO) {
		if (createEmployeeDTO.getRole().equals("Trainee")) {
			Trainee newTrainee = traineeService.createTrainee(createEmployeeDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(newTrainee);
		} else if (createEmployeeDTO.getRole().equals("Trainer")) {
			Trainer newTrainer = trainerService.createTrainer(createEmployeeDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(newTrainer);
		} else if (createEmployeeDTO.getRole().equals("Account Manager")) {
			AccountManager newAccountManager = accountManagerService.createAccountManager(createEmployeeDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(newAccountManager);
		} else {
			HR newHR = hrService.createHR(createEmployeeDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(newHR);
		}
	}

	@PatchMapping("/password")
	public ResponseEntity updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
		try {
			Employee employee = employeeService.updatePassword(updatePasswordDTO);
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Old password doesn't match");
		}
	}

	@PatchMapping("/set-password")
	public ResponseEntity setPassword(@RequestBody SetPasswordDTO setPasswordDTO) {
		Employee employee = employeeService.setPassword(setPasswordDTO);

		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	
	
	

//	private final UserService userService;
//	private final UserRepository userRepository;
//	private final UserRoleRepository userRoleRepository;
//
//	public UserController(UserService userService, UserRepository userRepository, TrainerRepository trainerRepository,
//			TraineeRepository traineeRepository, UserRoleRepository userRoleRepository) {
//		super();
//		this.userService = userService;
//		this.userRepository = userRepository;
//		this.trainerRepository = trainerRepository;
//		this.traineeRepository = traineeRepository;
//		this.userRoleRepository = userRoleRepository;
//	}
//	
//	@GetMapping("users")
//	public ResponseEntity<List<User>> getAllUsers() {
//		List<User> allUsers = userRepository.findAll();
//
//		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
//	}
//
//	
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUser(@PathVariable UUID id) {
//		User user = userRepository.findById(id).get();
//
//		return ResponseEntity.status(HttpStatus.OK).body(user);
//	}
//
//	@PostMapping("/create")
//	public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
////		Don't need to use DTO for password hiding purposes. Discovered @JsonProperty(access = Access.WRITE_ONLY) 
////		User user = userService.createUser(createUserDTO);
////		
////		var responseBody = PublicUserDTO.builder()
////					.id(user.getId())
////					.email(user.getEmail())
////					.firstName(user.getFirstName())
////					.lastName(user.getLastName())
////					.build();
////		
////		return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
//
//		User user = userService.createUser(createUserDTO);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(user);
//	}
//
//
//
//	@GetMapping("/roles")
//	public ResponseEntity<List<UserRole>> getAllRoles() {
//		List<UserRole> allRoles = userRoleRepository.findAll();
//
//		return ResponseEntity.status(HttpStatus.OK).body(allRoles);
//	}
//

}
