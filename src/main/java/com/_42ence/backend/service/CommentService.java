package com._42ence.backend.service;

import com._42ence.backend.dto.Response.CommentResponseDTO;
import com._42ence.backend.dto.Response.LoginResponseDTO;
import com._42ence.backend.entity.Comment;
import com._42ence.backend.entity.Rating;
import com._42ence.backend.entity.Subject;
import com._42ence.backend.entity.User;
import com._42ence.backend.repository.CommentRepository;
import com._42ence.backend.repository.RatingRepository;
import com._42ence.backend.repository.SubjectRepository;
import com._42ence.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentResponseDTO> getAllSubjectComment(Subject subject) {

        List<CommentResponseDTO> list = commentRepository.findBySubject(subject)
                .stream()
                .map(this::convertEntityToCommentResponseDto)
                .collect(Collectors.toList());

        return list;
    }


    public CommentResponseDTO convertEntityToCommentResponseDto(Comment comment) {

        User user = comment.getUser();
        Subject subject = comment.getSubject();
        Rating rating = comment.getRating();

        CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
        commentResponseDTO.setIntraId(user.getIntraId());
        commentResponseDTO.setUserLevel(user.getLevel());
        commentResponseDTO.setSubjectName(subject.getName());
        commentResponseDTO.setCommentId(comment.getId());
        commentResponseDTO.setContent(comment.getContent());
        commentResponseDTO.setUpdateTime(comment.getUpdateTime());
        commentResponseDTO.setRating(rating.getStarRating());
        commentResponseDTO.setTimeTaken(rating.getTimeTaken());
        commentResponseDTO.setAmountStudy(rating.getAmountStudy());
        commentResponseDTO.setBonus(rating.getBonus());
        commentResponseDTO.setDifficulty(rating.getDifficulty());

        return commentResponseDTO;
    }
}
