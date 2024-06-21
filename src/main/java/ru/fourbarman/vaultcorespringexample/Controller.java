package ru.fourbarman.vaultcorespringexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Environment environment;

    @GetMapping("/hello")
    public String sayHello() {
        return String.format("db.username: %s ; db.password: %s",
                environment.getProperty("db.username"), environment.getProperty("db.password"));
    }
}