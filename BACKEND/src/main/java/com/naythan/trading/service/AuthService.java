package com.naythan.trading.service;

import com.naythan.trading.model.User;
import com.naythan.trading.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public ResponseEntity<User> register(User user){
        User newUser= new User();
        user.getTwoFactorAuth().setEnabled(user.getTwoFactorAuth().isEnabled());
        user.getTwoFactorAuth().setSendTo(user.getTwoFactorAuth().getSendTo());
        User savedUser =  authRepository.save(user);
         return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
