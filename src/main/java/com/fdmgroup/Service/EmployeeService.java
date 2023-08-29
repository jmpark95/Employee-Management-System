package com.fdmgroup.Service;

import javax.naming.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Employee.UpdateEmployeeDTO;
import com.fdmgroup.DTO.Employee.UpdatePasswordDTO;
import com.fdmgroup.Model.Employee.Employee;
import com.fdmgroup.Repository.FDMRoleRepository;
import com.fdmgroup.Repository.Employee.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	private final EmployeeRepository employeeRepository;
	private final FDMRoleRepository fdmRoleRepository;
	private final PasswordEncoder passwordEncoder;

	public EmployeeService(EmployeeRepository employeeRepository, FDMRoleRepository fdmRoleRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.employeeRepository = employeeRepository;
		this.fdmRoleRepository = fdmRoleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Employee updateEmployee(@Valid UpdateEmployeeDTO updateEmployeeDTO) {
		Employee employee = employeeRepository.findById(updateEmployeeDTO.getId()).get();
		
		employee.setEmail(updateEmployeeDTO.getEmail());
		employee.setFirstName(updateEmployeeDTO.getFirstName());
		employee.setLastName(updateEmployeeDTO.getLastName());
		employee.setSalary(updateEmployeeDTO.getSalary());
		employee.setStartDate(updateEmployeeDTO.getStartDate());	
		
		return employeeRepository.save(employee);
	}

	public Employee updatePassword(UpdatePasswordDTO updatePasswordDTO) {
		Employee employee = employeeRepository.findById(updatePasswordDTO.getEmployeeID()).get();
		
		if (!passwordEncoder.matches(updatePasswordDTO.getOldPassword(), employee.getPassword())) {
			throw new IllegalArgumentException();
		} 
		
		String newPassword = passwordEncoder.encode(updatePasswordDTO.getNewPassword());
		employee.setPassword(newPassword);
		return employeeRepository.save(employee);
	}


	
	
	

//	public Employee updateEmployee(UpdateEmployeeDTO updateEmployeeDTO) {
//		Employee employee = employeeRepository.findById(updateEmployeeDTO.getId()).get();
//		
//		
//		//Factory
//		//Employee employee = EmployeeFactory.createEmployee(updateEmployeeDTO.getRole());
//		
//		employee.setEmail(updateEmployeeDTO.getEmail());
//		employee.setFirstName(updateEmployeeDTO.getFirstName());
//		employee.setLastName(updateEmployeeDTO.getLastName());
//		employee.setSalary(updateEmployeeDTO.getSalary());
//		employee.setStartDate(updateEmployeeDTO.getStartDate());
//		if (employee instanceof Trainee) {
//			employee.setRole(fdmRoleRepository.findByRole(updateEmployeeDTO.getRole()));
//		}
//		
//		return employee;
//	}


	
	
//	private final UserRepository userRepository;
//    private final UserFactory userFactory;
//    private final PasswordEncoder passwordEncoder;
//
//	public UserService(UserRepository userRepository, UserFactory userFactory, PasswordEncoder passwordEncoder) {
//		this.userRepository = userRepository;
//		this.userFactory = userFactory;
//		this.passwordEncoder = passwordEncoder;
//	}
//	
//	
//	
//	
////	public boolean login(@Valid LoginDTO loginDTO) {
////	Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
////
////	if (user.isEmpty()) {
////		throw new UsernameNotFoundException("User not found");
////	}
////	
////	String passwordFromDatabase = user.get().getPassword();
////	String passwordFromUser = loginDTO.getPassword();
////	
////	return passwordEncoder.matches(passwordFromUser, passwordFromDatabase);	
////}
//
//
//	public User createUser(CreateUserDTO createUserDTO) {
//		//Factory pattern to dynamically instantiate subclasses(Trainer, Trainee, AccManager or HR)
//		User user = userFactory.createUser(createUserDTO.getRole());
//		user.setEmail(createUserDTO.getEmail());
//		user.setPassword(passwordEncoder.encode(createUserDTO.getEmail()));
//		user.setFirstName(createUserDTO.getFirstName());
//		user.setLastName(createUserDTO.getLastName());
//		user.setSalary(createUserDTO.getSalary());
//		
//		return userRepository.save(user);
//	}
//	
//
//	
//
//
//
//	
////	public static String generateRandomPassword(int length) {
////	    String characters = "!\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
////	    Random random = new Random();
////	    StringBuilder sb = new StringBuilder(length);
////	    
////	    for (int i = 0; i < length; i++) {
////	    	int index = random.nextInt(characters.length());
////	        char randomChar = characters.charAt(index);
////	        sb.append(randomChar);
////	    }
////	    
////	    return sb.toString();
////	}
}


