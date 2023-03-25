package com.nnpia.cv01.controllers;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.repositories.IAppUserRepository;
import com.nnpia.cv01.services.AppUserService;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppUserControllerTest {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Autowired
    private AppUserService appUserService;
    private final AppUser appUser = new AppUser(100L, "usernameTest", "passwordTest", true, LocalDateTime.now(), LocalDateTime.now());
    private AppUser createdAppUser = null;
    private CloseableHttpClient client;
    private HttpHost host;
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        createdAppUser = appUserService.createUser(appUser);
        client = HttpClientBuilder.create().build();
        host = new HttpHost("localhost", port);
    }

    @AfterEach
    public void tearDown() throws IOException {
        appUserRepository.deleteAll();
        client.close();
    }

    @Test
    public void validUserEndpoint() throws IOException {
        HttpGet request = new HttpGet("/api/v1/app-user/" + createdAppUser.getId());
        HttpResponse response = client.execute(host, request);
        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    public void invalidUserEndpoint() throws IOException {
        HttpGet request = new HttpGet("/api/v1/app-user/101");
        HttpResponse response = client.execute(host, request);
        assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusLine().getStatusCode());
    }
}