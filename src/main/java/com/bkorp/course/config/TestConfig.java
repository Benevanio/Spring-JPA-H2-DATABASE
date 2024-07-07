package com.bkorp.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bkorp.course.entities.User;
import com.bkorp.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999887774", "12345679");
        User u2 = new User(null, "Alex Green", "Alex@gmail.com", "198888785", "12345679");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
