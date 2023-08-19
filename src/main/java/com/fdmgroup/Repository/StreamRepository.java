package com.fdmgroup.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.Stream;

public interface StreamRepository extends JpaRepository<Stream, UUID>{

}
