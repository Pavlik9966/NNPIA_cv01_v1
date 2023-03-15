package com.nnpia.cv01.services;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.domains.Role;
import com.nnpia.cv01.repositories.IAppUserRepository;
import com.nnpia.cv01.repositories.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public AppUser findUserById(final Long id) throws ResourceNotFoundException {
        Optional<AppUser> result = appUserRepository.findById(id);

        if (result.isEmpty()) throw new ResourceNotFoundException();

        return result.get();
    }

    public List<AppUser> findUsersByRole(final String roleName) throws ResourceNotFoundException {
        Role roleResult = roleRepository.findRoleByName(roleName);

        if (roleResult == null) throw new ResourceNotFoundException();

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

    public AppUser findUserByUsername(final String username) throws ResourceNotFoundException {
        AppUser result = appUserRepository.findAppUserByUsername(username);

        if (result == null) throw new ResourceNotFoundException();

        return result;
    }
}