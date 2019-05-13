package org.itstep.config;

import org.itstep.dao.UserDAO;
import org.itstep.dao.connection.ConnectionFactory;
import org.itstep.dao.connection.H2Factory;
import org.itstep.dao.connection.PostgresFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.itstep")
public class AppConfig {

    @Bean()
    @Qualifier("h2Factory")
    @Profile("dev")
    public ConnectionFactory getH2Factory() {
        return new H2Factory();
    }

    @Bean()
    @Qualifier("postgresFactory")
    @Profile("test")
    public ConnectionFactory getPostgresFactory() {
        return new PostgresFactory();
    }


    @Bean
    @Qualifier("userDAO")
    public UserDAO getUserDAO(ConnectionFactory connectionFactory) {
        UserDAO userDAO = new UserDAO();
        userDAO.setConnectionFactory(connectionFactory);
        return userDAO;
    }


}
