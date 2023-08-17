package com.fdmgroup.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.CreateUserDTO;
import com.fdmgroup.Model.User.User;
import com.fdmgroup.Model.User.UserFactory;
import com.fdmgroup.Repository.UserRepository;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, UserFactory userFactory, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.userFactory = userFactory;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	
	
//	public boolean login(@Valid LoginDTO loginDTO) {
//	Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
//
//	if (user.isEmpty()) {
//		throw new UsernameNotFoundException("User not found");
//	}
//	
//	String passwordFromDatabase = user.get().getPassword();
//	String passwordFromUser = loginDTO.getPassword();
//	
//	return passwordEncoder.matches(passwordFromUser, passwordFromDatabase);	
//}


	public User createUser(CreateUserDTO createUserDTO) {
		//Factory pattern to dynamically instantiate subclasses(Trainer, Trainee, AccManager or HR)
		User user = userFactory.createUser(createUserDTO.getRole());
		user.setEmail(createUserDTO.getEmail());
		user.setPassword(passwordEncoder.encode(createUserDTO.getEmail()));
		user.setFirstName(createUserDTO.getFirstName());
		user.setLastName(createUserDTO.getLastName());
		user.setSalary(createUserDTO.getSalary());
		
		return userRepository.save(user);
	}
	

	



	
//	public static String generateRandomPassword(int length) {
//	    String characters = "!\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
//	    Random random = new Random();
//	    StringBuilder sb = new StringBuilder(length);
//	    
//	    for (int i = 0; i < length; i++) {
//	    	int index = random.nextInt(characters.length());
//	        char randomChar = characters.charAt(index);
//	        sb.append(randomChar);
//	    }
//	    
//	    return sb.toString();
//	}
}


