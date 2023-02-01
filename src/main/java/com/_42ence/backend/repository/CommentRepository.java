package com._42ence.backend.repository;

import com._42ence.backend.entity.Comment;
import com._42ence.backend.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findBySubject(Subject subject);
}
