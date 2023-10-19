package com.gr2.fashionshop.controller;

import com.gr2.fashionshop.service.UserService;
import com.gr2.fashionshop.service.dto.ResponseDTO;
import com.gr2.fashionshop.service.dto.user.SignInDTO;
import com.gr2.fashionshop.service.dto.user.SignInReponseDTO;
import com.gr2.fashionshop.service.dto.user.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    // two apis

    // signup

    @PostMapping("/signup")
    public ResponseDTO signup(@RequestBody SignUpDTO signupDTO) {
        return userService.signUp(signupDTO);
    }


    // signin

    @PostMapping("/signin")
    public SignInReponseDTO signIn(@RequestBody SignInDTO signInDTO) {
        return userService.signIn(signInDTO);
    }

}
