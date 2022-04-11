package com.revature.pms.controller;

import com.revature.pms.model.Role;
import com.revature.pms.model.UserRole;
import com.revature.pms.model.Users;
import com.revature.pms.payload.ApiResponse;
import com.revature.pms.payload.JwtResponse;
import com.revature.pms.payload.LoginRequest;
import com.revature.pms.payload.SignupRequest;
import com.revature.pms.repo.RoleRepository;
import com.revature.pms.repo.UsersRepository;
import com.revature.pms.exception.AppException;
import com.revature.pms.config.JwtTokenUtil;
import com.revature.pms.service.UsersService;
import com.revature.pms.service.UsersServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository userRepository;
    
    @Autowired
    UsersService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    	System.out.println(loginRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Users user = userService.findOne(loginRequest.getUsername());
        List<String> roles = authentication.getAuthorities().stream()
        		.map(item -> item.getAuthority())
        		.collect(Collectors.toList());
        
        String jwt = tokenProvider.generateToken(authentication, user);
        return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getUsername(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }


        // Creating user's account
        // public User(String username, String password, String firstName, String lastName,String email)
        Users user = new Users(signUpRequest.getUsername(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(UserRole.USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRole(userRole);

        Users result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}

