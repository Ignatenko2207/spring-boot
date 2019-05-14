package org.itstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.itstep"})
public class ApplicationRunner
{
    public static void main( String[] args )
    {
//        SpringApplication.run(ApplicationRunner.class, args);

        // Run with profiles
            SpringApplication context = new SpringApplication(ApplicationRunner.class);
            context.setAdditionalProfiles("dev");
            context.run(args);

    }
}
