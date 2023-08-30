package com.fdmgroup.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdmgroup.Model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
	@Query("SELECT l from LeaveRequest l WHERE l.requester.id = :employeeId")
	List<LeaveRequest> findAllByEmployeeId(int employeeId);

	@Query("SELECT l from LeaveRequest l WHERE l.status = Pending")
	List<LeaveRequest> findAllPendingLeaveRequests();

}
