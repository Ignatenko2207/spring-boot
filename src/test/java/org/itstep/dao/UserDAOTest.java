package org.itstep.dao;

import org.itstep.ApplicationRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(ApplicationRunner.class)
@ActiveProfiles("test")
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void getConnectionFactory() {
        assertNotNull(userDAO.getConnectionFactory());
        assertTrue(userDAO.getConnectionFactory().getClass().getSimpleName().equals("PostgresFactory"));
    }
}