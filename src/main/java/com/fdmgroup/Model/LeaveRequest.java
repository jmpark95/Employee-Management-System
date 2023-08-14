package com.fdmgroup.Model;

import java.sql.Timestamp;
import java.util.UUID;

import com.fdmgroup.Enum.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "FK_USER_ID")
	private User sender;
	
	private Timestamp startDate;
	
	private Timestamp endDate;
	
    @Enumerated(EnumType.STRING)
	private Status status;
}

