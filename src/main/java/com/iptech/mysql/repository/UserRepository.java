package com.iptech.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iptech.mysql.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
