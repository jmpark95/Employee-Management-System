package com.fdmgroup.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.Config.WebSecurityConfig;
import com.fdmgroup.DTO.CreateUserDTO;
import com.fdmgroup.Model.Employee.User;
import com.fdmgroup.Repository.UserRoleRepository;
import com.fdmgroup.Service.UserService;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = WebSecurityConfig.class)
@Import(UserController.class)
class UserControllerTest {
	@MockBean
	UserService userService;

	@MockBean
	UserRoleRepository userRoleRepository;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

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
	void createUser_successfully_adds_user_and_returns_201_and_returns_DTO() throws JsonProcessingException, Exception {
        when(userService.createUser(createUserDTO)).thenReturn(user);

		mockMvc.perform(post("/api/user/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createUserDTO))
				)
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.email").value("min@fdm.com"))
				.andExpect(jsonPath("$.firstName").value("Min"))
				.andExpect(jsonPath("$.lastName").value("Park"));
	}
	

}
