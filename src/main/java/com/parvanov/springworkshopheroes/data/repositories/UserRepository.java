package com.parvanov.springworkshopheroes.data.repositories;

import com.parvanov.springworkshopheroes.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String name);
    Optional<User> findByUsernameAndPassword(String username, String password);
    User findByUsername(String name);
}
