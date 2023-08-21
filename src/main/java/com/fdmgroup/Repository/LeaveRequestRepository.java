package com.fdmgroup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {

}
