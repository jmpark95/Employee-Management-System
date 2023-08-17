package com.fdmgroup.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.DTO.CreateUserDTO;
import com.fdmgroup.DTO.PublicUserDTO;
import com.fdmgroup.Model.UserRole;
import com.fdmgroup.Model.User.User;
import com.fdmgroup.Repository.UserRoleRepository;
import com.fdmgroup.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;
	private final UserRoleRepository userRoleRepository;


	public UserController(UserService userService, UserRoleRepository userRoleRepository) {
		this.userService = userService;
		this.userRoleRepository = userRoleRepository;

	}
	
	
	

	@PostMapping("/create")
	public ResponseEntity<PublicUserDTO> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
		User user = userService.createUser(createUserDTO);
		
		var responseBody = PublicUserDTO.builder()
					.id(user.getId())
					.email(user.getEmail())
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<UserRole>> getAllRoles() {
		List<UserRole> allRoles = userRoleRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(allRoles);
	}

	
	
	
//	@PostMapping("/login")
//	public ResponseEntity<> login(@Valid @RequestBody LoginDTO loginDTO) {
//		try {
//			
//		} catch {
//			
//		}
//		Optional<User> user = userService.login(loginDTO);
//	}

}
