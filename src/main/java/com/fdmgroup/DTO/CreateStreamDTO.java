package com.fdmgroup.DTO;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Employee.Trainer;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateStreamDTO {
	private Date endDate;
	private Date startDate;
	private UUID streamNameId;
	private List<UUID> trainees;
	private List<UUID> trainers;
}
