package com.example.fpstore.repos;

import com.example.fpstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByMail(String mail);

    User findByActivationCode(String code);

    User findByUsername(String username);
}
