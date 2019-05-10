package org.itstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner
{
    public static void main( String[] args )
    {

            SpringApplication.run(ApplicationRunner.class, args);

//            User admin = new User();
//            admin.setEmail("ignatenko2207@gmail.com");
//            admin.setFirstName("Alex");
//            admin.setLastName("Ignatenko");
//            admin.setLogin("ignatenko2207");
//            admin.setPassword("12345");
//            admin.setProfile(Profile.ADMIN);
//
//            User client = new User();
//            client.setEmail("ignatenko2207@gmail.com");
//            client.setFirstName("Alex");
//            client.setLastName("Ignatenko");
//            client.setLogin("ignatenko2207-client");
//            client.setPassword("12345");
//            client.setProfile(Profile.CLIENT);
//
    }
}
