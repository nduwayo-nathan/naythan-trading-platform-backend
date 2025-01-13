package com.naythan.trading.controller;

import com.naythan.trading.model.User;
import com.naythan.trading.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody @Validated User user) {
        // Check for null or empty strings for required fields
        if (user == null || isNullOrEmpty(user.getFullName()) || isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            return authService.register(user);
        } catch (IllegalArgumentException e) {
            // Handle bad request due to invalid arguments
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ResponseStatusException e) {
            // Handle custom errors triggered within service
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Catch any other unexpected errors
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Helper method to check if a string is null or empty
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
