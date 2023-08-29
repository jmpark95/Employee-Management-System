package com.fdmgroup.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.DTO.Leave.LeaveRequestDTO;
import com.fdmgroup.Model.LeaveRequest;
import com.fdmgroup.Repository.LeaveRequestRepository;
import com.fdmgroup.Service.LeaveRequestService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
	private final LeaveRequestRepository leaveRequestRepository;
	private final LeaveRequestService leaveRequestService;

	public LeaveController(LeaveRequestRepository leaveRequestRepository, LeaveRequestService leaveRequestService) {
		this.leaveRequestRepository = leaveRequestRepository;
		this.leaveRequestService = leaveRequestService;
	}

	@GetMapping("/leave-requests")
	public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests(){
		List<LeaveRequest> allLeaveRequests = leaveRequestRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(allLeaveRequests);
	}
	
	@PostMapping("/leave-request")
	public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequestDTO leaveRequestDTO) {
		LeaveRequest leaveRequest = leaveRequestService.createLeaveRequest(leaveRequestDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(leaveRequest);
	}
	
	@GetMapping("/leave-requests/{employeeId}")
	public ResponseEntity<List<LeaveRequest>> getAllLeaveRequestsByEmployeeId(@PathVariable int employeeId) {
		List<LeaveRequest> allLeaveRequests = leaveRequestRepository.findAllByEmployeeId(employeeId);
		
		return ResponseEntity.status(HttpStatus.OK).body(allLeaveRequests);
	}
	
	

	
	
}
