package com.fdmgroup.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdmgroup.Model.Stream.Stream;

public interface StreamRepository extends JpaRepository<Stream, Integer>{
	
//    @Query("SELECT s FROM Stream s WHERE s.stream.id = :streamNameId")
//	List<Stream> findAllByStreamNameId(UUID streamNameId);
    
    Stream findByName(String streamName);
	
}
