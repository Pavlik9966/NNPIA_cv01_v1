package com.nnpia.cv01.controllers;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.services.AppUserService;
import com.nnpia.cv01.services.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/app-user")
@RequiredArgsConstructor
@RestController
public class AppUserController {
    private final AppUserService appUserService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable final Long id) {
        appUserService.deleteUser(id);
        return ResponseEntity.ok("User with id: " + id + " has been deleted.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable final Long id) throws ResourceNotFoundException {
        AppUser result = appUserService.findUserById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/active")
    public ResponseEntity<List<AppUser>> getActiveUsers() {
        List<AppUser> result = appUserService.findActiveUsers();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<List<AppUser>> getUsersByRole(@PathVariable String name) throws ResourceNotFoundException {
        List<AppUser> result = appUserService.findUsersByRole(name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<AppUser> createUser(@RequestBody @Validated final AppUser appUser) {
        appUser.setPassword(new BCryptPasswordEncoder().encode(appUser.getPassword()));
        AppUser result = appUserService.createUser(appUser);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable final Long id, @RequestBody final AppUser appUser) {
        var result = appUserService.updateUser(
                new AppUser(
                        id,
                        appUser.getUsername(),
                        new BCryptPasswordEncoder().encode(appUser.getPassword()),
                        appUser.getActive(),
                        appUser.getCreationDate(),
                        appUser.getUpdateDate()
                )
        );
        return ResponseEntity.ok(result);
    }
}