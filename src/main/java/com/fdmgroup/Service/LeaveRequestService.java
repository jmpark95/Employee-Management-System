package com.fdmgroup.Service;

import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Leave.LeaveRequestDTO;
import com.fdmgroup.Enum.Status;
import com.fdmgroup.Model.LeaveRequest;
import com.fdmgroup.Repository.LeaveRequestRepository;
import com.fdmgroup.Repository.Employee.EmployeeRepository;

@Service
public class LeaveRequestService {
	private final LeaveRequestRepository leaveRequestRepository;
	private final EmployeeRepository employeeRepository;

	public LeaveRequestService(LeaveRequestRepository leaveRequestRepository, EmployeeRepository employeeRepository) {
		super();
		this.leaveRequestRepository = leaveRequestRepository;
		this.employeeRepository = employeeRepository;
	}



	public LeaveRequest createLeaveRequest(LeaveRequestDTO leaveRequestDTO) {		
		var newLeaveRequest = LeaveRequest.builder()
				.requester(employeeRepository.findById(leaveRequestDTO.getEmployeeID()).get())
				.startDate(leaveRequestDTO.getStartDate())
				.endDate(leaveRequestDTO.getEndDate())
				.totalHours(leaveRequestDTO.getTotalHours())
				.status(Status.Pending)
				.build();
				
		return leaveRequestRepository.save(newLeaveRequest);
	}

}
