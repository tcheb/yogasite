package com.sylviealiceyoga.app.controller;

import com.sylviealiceyoga.app.auth.JwtTokenUtil;
import com.sylviealiceyoga.app.auth.pojo.AuthRequest;
import com.sylviealiceyoga.app.auth.pojo.AuthResponse;
import com.sylviealiceyoga.app.entity.Group;
import com.sylviealiceyoga.app.entity.User;
import com.sylviealiceyoga.app.service.IGroupService;
import com.sylviealiceyoga.app.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IUserService userService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups(@RequestParam(required = false) String name) {
        LOGGER.debug("getAllGroups");

        List<Group> groups = (List<Group>) groupService.findAll();

        return ResponseEntity.ok(groups);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
        LOGGER.debug("getAllUsers");
        List<User> users = (List<User>) userService.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
