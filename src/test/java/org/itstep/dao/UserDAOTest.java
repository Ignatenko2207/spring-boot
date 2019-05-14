package org.itstep.dao;

import org.itstep.ApplicationRunner;
import org.itstep.config.AppConfig;
import org.itstep.entity.Profile;
import org.itstep.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("dev")
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void getConnectionFactory() {
        assertNotNull(userDAO.getConnectionFactory());
        assertTrue(userDAO.getConnectionFactory().getClass().getSimpleName().equals("H2Factory"));
    }

    @Test
    public void saveAndGetAndDelete(){
        User testUser = new User();
        testUser.setEmail("ignatenko2207@gmail.com");
        testUser.setFirstName("Alex");
        testUser.setLastName("Ignatenko");
        testUser.setLogin("ignatenko2207");
        testUser.setPassword("12345");
        testUser.setProfile(Profile.ADMIN);

        testUser.setId(userDAO.save(testUser));
        assertNotNull(testUser);
        assertNotNull(testUser.getId());

        assertNotNull(userDAO.findOne(testUser.getId()));

        userDAO.delete(testUser);
        assertNull(userDAO.findOne(testUser.getId()));
    }

}