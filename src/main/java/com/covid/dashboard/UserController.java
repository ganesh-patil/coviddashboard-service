package com.covid.dashboard;


import com.covid.dashboard.User.User;
import com.covid.dashboard.User.UserRepository;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    UserController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getUser(){

        return "Ganesh";
    }

    @PostMapping
    public User registerUser(@Valid  @RequestBody User userData){
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        return this.userRepository.save(userData);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
