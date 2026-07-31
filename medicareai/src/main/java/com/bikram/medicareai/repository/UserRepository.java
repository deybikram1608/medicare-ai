package com.bikram.medicareai.repository;

import com.bikram.medicareai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
