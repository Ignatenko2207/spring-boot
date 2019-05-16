package org.itstep.controller;

import org.itstep.ApplicationRunner;
import org.itstep.entity.Profile;
import org.itstep.entity.User;
import org.itstep.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.net.URI;
import java.net.URISyntaxException;

@SpringJUnitConfig(ApplicationRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserController userController;

    @MockBean
    UserService userService;

    @Test
    public void createUser() throws URISyntaxException {

        User user = new User();
        user.setId(1);
        user.setEmail("ignatenko2207@gmail.com");
        user.setFirstName("Alex");
        user.setLastName("Ignatenko");
        user.setLogin("ignatenko2207");
        user.setPassword("12345");
        user.setProfile(Profile.ADMIN);

        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(user);

        RequestEntity<User> request = new RequestEntity<>(user, HttpMethod.POST, new URI("/user"));

        ResponseEntity<User> response = testRestTemplate.exchange(request, User.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Mockito.verify(userService, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void getOne() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void delete() {
    }
}