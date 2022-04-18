package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
