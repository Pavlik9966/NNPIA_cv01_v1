package com.nnpia.cv01.services;

import com.nnpia.cv01.domain.AppUser;
import com.nnpia.cv01.domain.Role;
import com.nnpia.cv01.repositories.IAppUserRepository;
import com.nnpia.cv01.repositories.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserService {
    private final IAppUserRepository appUserRepository;
    private final IRoleRepository roleRepository;

    public List<AppUser> findActiveUsers() {
        return appUserRepository.findByActive(true);
    }

    public AppUser findUserById(final Long id) throws ResponseStatusException {
        Optional<AppUser> result = appUserRepository.findById(id);

        if (result.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: " + id + " not found.");

        return result.get();
    }

    public List<AppUser> findUsersByRole(final String roleName) {
        Role roleResult = roleRepository.findRoleByName(roleName);

        if (roleResult == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role: " + roleName + " not found.");

        return appUserRepository.findUsersByRole(roleResult);
    }

    public AppUser createUser(final AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser updateUser(final AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public void deleteUser(final Long id) {
        appUserRepository.deleteById(id);
    }
}