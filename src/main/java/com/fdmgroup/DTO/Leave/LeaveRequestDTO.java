package com.fdmgroup.DTO.Leave;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequestDTO {
	private int employeeID;
	private Date startDate;
	private Date endDate;
	private float totalHours;
}

