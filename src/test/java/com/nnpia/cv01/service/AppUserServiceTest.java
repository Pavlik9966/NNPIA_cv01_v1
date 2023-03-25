package com.nnpia.cv01.service;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.repositories.IAppUserRepository;
import com.nnpia.cv01.services.AppUserService;
import com.nnpia.cv01.services.ResourceNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AppUserServiceTest {
    @Autowired
    // @MockBean
    private IAppUserRepository appUserRepository;
    @Autowired
    private AppUserService appUserService;
    private final AppUser appUser = new AppUser(100L, "usernameTest", "passwordTest", true, LocalDateTime.now(), LocalDateTime.now());
    private AppUser createdAppUser = null;

    @BeforeEach
    public void setUp() {
        // Mockito.when(appUserRepository.findById(100L)).thenReturn(Optional.of(appUser));
        createdAppUser = appUserService.createUser(appUser);
    }

    @AfterEach
    public void tearDown() {
        // appUserService.deleteUser(createdAppUser.getId());
        appUserRepository.deleteAll();
    }

    /*
     * In JUnit 5, to write the test code that is expected to throw an exception, we should use assertThrows().
     * Note that in JUnit 4, we needed to use @Test(expected = Exception.class) syntax.
     * */
    @Test
    public void findById() throws ResourceNotFoundException {
        // AppUser result = appUserService.findUserById(100L);
        AppUser actual = appUserService.findUserById(createdAppUser.getId());
        assertEquals(appUser, actual);
    }
}