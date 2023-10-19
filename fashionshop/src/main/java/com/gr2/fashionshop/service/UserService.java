package com.gr2.fashionshop.service;

import com.gr2.fashionshop.domain.AuthenticationToken;
import com.gr2.fashionshop.domain.User;
import com.gr2.fashionshop.exceptions.AuthenticationFailException;
import com.gr2.fashionshop.exceptions.CustomException;
import com.gr2.fashionshop.repository.UserRepository;
import com.gr2.fashionshop.service.dto.ResponseDTO;
import com.gr2.fashionshop.service.dto.user.SignInDTO;
import com.gr2.fashionshop.service.dto.user.SignInReponseDTO;
import com.gr2.fashionshop.service.dto.user.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
    public ResponseDTO signUp(SignUpDTO signupDTO) {
        // check if user is already present
        if (Objects.nonNull(userRepository.findByEmail(signupDTO.getEmail()))) {
            // we have an user
            throw new CustomException("user already present");
        }


        // hash the password

        String encryptedpassword = signupDTO.getPassword();

        try {
            encryptedpassword = hashPassword(signupDTO.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = new User(signupDTO.getFirstName(), signupDTO.getLastName(),
                signupDTO.getEmail(), encryptedpassword);

        userRepository.save(user);

        // save the user

        // create the token

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);

        authenticationService.saveConfirmationToken(authenticationToken);

        ResponseDTO responseDTO = new ResponseDTO("success", "user created succesfully");
        return responseDTO;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInReponseDTO signIn(SignInDTO signInDTO) {
        // find user by email

        User user = userRepository.findByEmail(signInDTO.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("user is not valid");
        }

        // hash the password

        try {
            if (!user.getPasswoprd().equals(hashPassword(signInDTO.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // compare the password in DB

        // if password match

        AuthenticationToken token = authenticationService.getToken(user);

        // retrive the token

        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }

        return new SignInReponseDTO("sucess", token.getToken());

        // return response
    }
}
