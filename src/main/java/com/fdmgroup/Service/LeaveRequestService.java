package com.fdmgroup.Service;

import org.springframework.stereotype.Service;

import com.fdmgroup.DTO.Leave.LeaveRequestDTO;
import com.fdmgroup.Enum.Status;
import com.fdmgroup.Model.LeaveRequest;
import com.fdmgroup.Model.Employee.Employee;
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
				.startDate(leaveRequestDTO.getStartDate()).endDate(leaveRequestDTO.getEndDate())
				.totalHours(leaveRequestDTO.getTotalHours()).status(Status.Pending).build();

		return leaveRequestRepository.save(newLeaveRequest);
	}

	public LeaveRequest approveLeaveRequest(int leaveId, int employeeId, float totalHours) {
		Employee employee = employeeRepository.findById(employeeId).get();
		employee.setLeaveTaken(employee.getLeaveTaken() + totalHours);
		employeeRepository.save(employee);
		
		LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveId).get();
		leaveRequest.setStatus(Status.Approved);
		return leaveRequestRepository.save(leaveRequest);
	}
	
	public LeaveRequest declineLeaveRequest(int leaveId) {
		LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveId).get();
		leaveRequest.setStatus(Status.Declined);
		return leaveRequestRepository.save(leaveRequest);
	}

}
