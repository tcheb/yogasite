package com.croissantyoga.app.controller;

import com.croissantyoga.app.entity.Group;
import com.croissantyoga.app.entity.User;
import com.croissantyoga.app.service.IGroupService;
import com.croissantyoga.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    @Autowired
    private IGroupService groupService;

    @Autowired
    private IUserService userService;

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups(@RequestParam(required = false) String name) {

        List<Group> groups = (List<Group>) groupService.findAll();

        return ResponseEntity.ok(groups);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
        List<User> users = (List<User>) userService.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/auth")
    public ResponseEntity<User> login(@RequestBody(required = false) User user) {
        return ResponseEntity.ok(user);
    }
}
