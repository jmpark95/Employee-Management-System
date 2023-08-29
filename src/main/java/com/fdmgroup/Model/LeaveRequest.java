package com.fdmgroup.Model;

import java.sql.Date;

import com.fdmgroup.Enum.Status;
import com.fdmgroup.Model.Employee.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "FK_USER_ID")
	private Employee requester;
	
	private Date startDate;
	
	private Date endDate;
	
	private float totalHours;
		
    @Enumerated(EnumType.STRING)
	private Status status = Status.Pending;
}

