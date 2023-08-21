package com.fdmgroup.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdmgroup.Model.Stream.EClass;

public interface EClassRepository extends JpaRepository<EClass, Integer>{
	@Query("SELECT c from EClass c WHERE c.stream.id = :streamId")
	List<EClass> findAllByStreamId(int streamId);
}
