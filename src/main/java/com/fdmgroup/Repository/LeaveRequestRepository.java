package com.fdmgroup.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, UUID>{

}
