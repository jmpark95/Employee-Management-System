package com.fdmgroup;

import java.sql.Timestamp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fdmgroup.Model.LeaveRequest;
import com.fdmgroup.Model.Stream;
import com.fdmgroup.Model.UserRole;
import com.fdmgroup.Model.User.User;
import com.fdmgroup.Repository.LeaveRequestRepository;
import com.fdmgroup.Repository.StreamRepository;
import com.fdmgroup.Repository.UserRepository;
import com.fdmgroup.Repository.UserRoleRepository;

@Component
public class DataLoader implements ApplicationRunner {
	private final UserRoleRepository userRoleRepository;
	private final StreamRepository streamRepository;
	private final UserRepository userRepository;
	private final LeaveRequestRepository leaveRequestRepository;

	public DataLoader(UserRoleRepository userRoleRepository, StreamRepository streamRepository,
			UserRepository userRepository, LeaveRequestRepository leaveRequestRepository) {
		super();
		this.userRoleRepository = userRoleRepository;
		this.streamRepository = streamRepository;
		this.userRepository = userRepository;
		this.leaveRequestRepository = leaveRequestRepository;
	}

	public void run(ApplicationArguments args) {
		saveUserRoles();
		saveStreams();
		saveUsers();
		saveLeaveRequests();
	}

	public void saveUserRoles() {
		userRoleRepository.save(new UserRole("HR"));
		userRoleRepository.save(new UserRole("Trainee"));
		userRoleRepository.save(new UserRole("Trainer"));
		userRoleRepository.save(new UserRole("Account Manager"));
	}

	public void saveStreams() {
		Stream java = new Stream();
		java.setStreamName("Java");
		java.setStartDate(Timestamp.valueOf("2023-05-01 09:01:15"));
		java.setEndDate(Timestamp.valueOf("2023-08-01 09:01:15"));

		Stream ba = new Stream();
		ba.setStreamName("Business Intelligence");
		ba.setStartDate(Timestamp.valueOf("2023-06-01 09:01:15"));
		ba.setEndDate(Timestamp.valueOf("2023-09-01 09:01:15"));

		streamRepository.save(java);
		streamRepository.save(ba);
	}

	public void saveUsers() {
		User user = new User();
		user.setEmail("min@fdm.com");
		user.setPassword("password");
		user.setFirstName("Min");
		user.setLastName("Park");
		user.setSalary(60000);
		user.setHasPersonallySetPassword(false);
		
		userRepository.save(user);
	}

	public void saveLeaveRequests() {
		User userForLeaveRequest = userRepository.findAll().get(0);
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setSender(userForLeaveRequest);
		
		leaveRequestRepository.save(leaveRequest);
	}
}