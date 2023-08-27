package com.fdmgroup.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.DTO.Leave.LeaveRequestDTO;
import com.fdmgroup.Model.LeaveRequest;
import com.fdmgroup.Model.Employee.Employee;
import com.fdmgroup.Repository.LeaveRequestRepository;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
	private final LeaveRequestRepository leaveRequestRepository;

	public LeaveController(LeaveRequestRepository leaveRequestRepository) {
		this.leaveRequestRepository = leaveRequestRepository;
	}
	
	@GetMapping("/leave-requests")
	public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests(){
		List<LeaveRequest> allLeaveRequests = leaveRequestRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(allLeaveRequests);

	}
	
	
//	@GetMapping("/leave-requests")
//	public ResponseEntity<List<LeaveRequestDTO>> getAllLeaveRequests(){
//		List<LeaveRequest> allLeaveRequests = leaveRequestRepository.findAll();
//		List<LeaveRequestDTO> allLeaveRequestsDTO = new ArrayList<>();
//		
//		//For each leaveRequest, remove password from User field
//		for (LeaveRequest leaveRequest : allLeaveRequests) {
//			Employee employee = leaveRequest.getSender();
//			
//			var publicUserDTO = PublicUserDTO.builder()
//					.id(employee.getId())
//					.firstName(employee.getFirstName())
//					.lastName(employee.getLastName())
//					.email(employee.getEmail())
//					.build();
//			
//			var leaveRequestDTO = LeaveRequestDTO.builder()
//					.id(leaveRequest.getId())
//					.sender(publicUserDTO)
//					.startDate(leaveRequest.getStartDate())
//					.endDate(leaveRequest.getEndDate())
//					.status(leaveRequest.getStatus())
//					.build();
//			
//			allLeaveRequestsDTO.add(leaveRequestDTO);
//		}
//
//		return ResponseEntity.status(HttpStatus.OK).body(allLeaveRequestsDTO);
//	}
	
	
}
