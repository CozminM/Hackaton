package com.hackaton.eHealth.repository;

import com.hackaton.eHealth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByMail(String mail);

    User getUserById(Long userId);

    boolean existsUserByName(String username);

    boolean existsUserByMail(String email);
}
