package com.fdmgroup.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Model.User.User;


public interface UserRepository extends JpaRepository<User, UUID>{
}
