package com._42ence.backend.service;

import com._42ence.backend.dto.Response.LoginResponseDTO;
import com._42ence.backend.entity.User;
import com._42ence.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LoginResponseDTO> getUserInfo(String intraId){
        return userRepository.findByIntraId(intraId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private LoginResponseDTO convertEntityToDto(User user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO = modelMapper.map(user, LoginResponseDTO.class);

        return loginResponseDTO;
    }
}
