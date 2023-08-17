package com.fdmgroup.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fdmgroup.DTO.CreateUserDTO;
import com.fdmgroup.Model.User.Trainee;
import com.fdmgroup.Model.User.User;
import com.fdmgroup.Model.User.UserFactory;
import com.fdmgroup.Repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	UserFactory userFactory;
	
	@Mock
	PasswordEncoder passwordEncoder;

	CreateUserDTO createUserDTO;

	User user;

	@BeforeEach
	void setup() {
		createUserDTO = CreateUserDTO.builder()
				.email("min@fdm.com")
				.firstName("Min")
				.lastName("Park")
				.role("Trainee")
				.salary(60000)
				.build();

		user = User.builder()
				.id(UUID.randomUUID())
				.email("min@fdm.com")
				.firstName("Min")
				.lastName("Park")
				.build();
	}

	
	
	
	
	@Test
	void createUser_should_create_user() {
		User trainee = new Trainee();
		when(userFactory.createUser(createUserDTO.getRole())).thenReturn(trainee);
		when(userRepository.save(trainee)).thenReturn(trainee);

		userService.createUser(createUserDTO);
		
		assertEquals("min@fdm.com", trainee.getEmail());
		assertEquals("Min", trainee.getFirstName());
		assertEquals("Park", trainee.getLastName());
		assertEquals(60000, trainee.getSalary());

		verify(userRepository, times(1)).save(trainee);
		assertEquals(trainee, userService.createUser(createUserDTO));		
	}


}
