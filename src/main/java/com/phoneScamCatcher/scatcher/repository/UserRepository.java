package com.phoneScamCatcher.scatcher.repository;

import com.phoneScamCatcher.scatcher.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPhoneNumberAndPassword(String phoneNumber, String password);
}
