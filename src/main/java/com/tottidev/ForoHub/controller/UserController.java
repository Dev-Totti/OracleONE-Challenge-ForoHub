package com.tottidev.ForoHub.controller;

import com.tottidev.ForoHub.domain.user.UserDataDisplay;
import com.tottidev.ForoHub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Page<UserDataDisplay>> getUsers(@PageableDefault(size=5)Pageable pageable) {
        return ResponseEntity.ok(userRepository.findByActiveTrue(pageable).map(UserDataDisplay::new));
    }





}
