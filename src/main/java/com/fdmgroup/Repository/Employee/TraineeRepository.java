package com.fdmgroup.Repository.Employee;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdmgroup.Model.Employee.Trainee;
import com.fdmgroup.Model.Stream.EClass;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
	@Query("SELECT t from Trainee t WHERE t.stream.id = :streamId")
	List<Trainee> findAllByStreamId(int streamId);
}
