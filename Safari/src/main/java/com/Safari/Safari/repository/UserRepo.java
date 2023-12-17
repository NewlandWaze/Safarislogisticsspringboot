package com.Safari.Safari.repository;

import com.Safari.Safari.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByLoginAndPassword(String login, String password);
    Optional<UserModel> findFirstByLogin(String login);
    Optional<UserModel> findFirstByEmail(String email);
}
