package com.phoneScamCatcher.scatcher.repository;

import com.phoneScamCatcher.scatcher.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, Integer> {

    Phone findByPhoneNumber(String phoneNumber);
}
