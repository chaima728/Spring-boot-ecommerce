package com.example.springbootecommerce.Repository;

import com.example.springbootecommerce.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
