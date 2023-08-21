package com.fdmgroup.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.Employee.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer>{

}
