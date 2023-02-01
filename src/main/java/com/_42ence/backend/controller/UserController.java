package com._42ence.backend.controller;

import com._42ence.backend.dto.Response.LoginResponseDTO;
import com._42ence.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @GetMapping("/{intraId}")
    public List<LoginResponseDTO> getUserInfo(@PathVariable String intraId) {
        return userService.getUserInfo(intraId);
    }
}
