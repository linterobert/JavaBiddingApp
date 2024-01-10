package com.LinteRobert.springboot101.repositories;

import com.LinteRobert.springboot101.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
}
