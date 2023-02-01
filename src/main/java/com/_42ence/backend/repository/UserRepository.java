package com._42ence.backend.repository;

import com._42ence.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByIntraId(String intraId);

}
