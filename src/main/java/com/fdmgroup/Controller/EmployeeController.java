package com.fdmgroup.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.Model.Employee.Employee;
import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;
import com.fdmgroup.Model.Stream.EClass;
import com.fdmgroup.Repository.EmployeeRepository;
import com.fdmgroup.Repository.TraineeRepository;
import com.fdmgroup.Repository.TrainerRepository;
import com.fdmgroup.Service.TraineeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private final EmployeeRepository employeeRepository;
	private final TrainerRepository trainerRepository;
	private final TraineeRepository traineeRepository;
	private final TraineeService traineeService;


	public EmployeeController(EmployeeRepository employeeRepository, TrainerRepository trainerRepository,
			TraineeRepository traineeRepository, TraineeService traineeService) {
		super();
		this.employeeRepository = employeeRepository;
		this.trainerRepository = trainerRepository;
		this.traineeRepository = traineeRepository;
		this.traineeService = traineeService;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
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
	
	//Get all trainees in a specific stream
	@GetMapping("/trainees-by-stream")
	public ResponseEntity<List<Trainee>> getAllTraineesByStreamId(@RequestParam("streamId") int streamId) {
		List<Trainee> allTrainees = traineeService.getAllTraineesByStreamId(streamId);
		
		return ResponseEntity.status(HttpStatus.OK).body(allTrainees);

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
