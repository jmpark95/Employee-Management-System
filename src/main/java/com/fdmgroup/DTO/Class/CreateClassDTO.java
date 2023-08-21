package com.fdmgroup.DTO.Class;

import java.sql.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClassDTO {
	private int streamId;
	private Date startDate;
	private Date endDate;
	private List<Integer> trainerIds;
	private List<Integer> traineeIds;
}
