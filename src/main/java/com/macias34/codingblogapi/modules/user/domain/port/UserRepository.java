package com.macias34.codingblogapi.modules.user.domain.port;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macias34.codingblogapi.modules.user.domain.entity.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByUsername(String username);
}